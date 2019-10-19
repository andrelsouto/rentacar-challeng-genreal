package com.andre.desafio.rentacar.services.impl;

import com.andre.desafio.rentacar.configurations.ParametrosRentacar;
import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.exceptions.RentacarValidacoes;
import com.andre.desafio.rentacar.models.Pagamento;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.PagamentoDTO;
import com.andre.desafio.rentacar.repositories.PagamentoRepository;
import com.andre.desafio.rentacar.services.PagamentoService;
import com.andre.desafio.rentacar.services.VagaService;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@Transactional(rollbackOn = CustomException.class)
public class PagamentoServiceImpl extends GenericServiceImpl<PagamentoRepository> implements PagamentoService {

    private VagaService vagaService;
    private ParametrosRentacar parametrosRentacar;

    @Autowired
    public PagamentoServiceImpl(VagaService vagaService, ParametrosRentacar parametrosRentacar) {
        this.vagaService = vagaService;
        this.parametrosRentacar = parametrosRentacar;
    }

    @Override
    public PagamentoDTO cadastrar(PagamentoDTO pagamento) throws CustomException {

        if (pagamento.getTotalAPago() == null) {
           throw new CustomException(RentacarValidacoes.ERRO_AO_PAGAR_VALOR_NULO);
        }

        if (pagamento.getVagas().isEmpty() || pagamento.getVagas().size() != 1) {
            throw new CustomException(RentacarValidacoes.ERRO_AO_PAGAR_SEM_VAGA);
        }

        PropertyMap<PagamentoDTO, Pagamento> propertyMap = new PropertyMap<PagamentoDTO, Pagamento>() {
            @Override
            protected void configure() {
                map(source.getTotalAPago(), destination.getValor());
            }
        };

        Vaga vaga = getModelMapper().map(pagamento.getVagas().get(0), Vaga.class);
        PagamentoDTO valorAPagar = consultarTotal(vaga);

        if (pagamento.getTotalAPago() < valorAPagar.getTotalAPagar()) {
            throw new CustomException(RentacarValidacoes.ERRO_AO_PAGAR_VALOR_BAIXO);
        }

        pagamento.setTroco(pagamento.getTotalAPago() - valorAPagar.getTotalAPagar());

        pagamento.setDtPagamento(Calendar.getInstance());
        pagamento.setValor(pagamento.getTotalAPago());
        Pagamento p = getModelMapper().map(pagamento, Pagamento.class);
        p = getRepository().save(p);
        vagaService.liberarEstacionamento(vaga);
        getModelMapper().map(p, pagamento);
        pagamento.getVagas().get(0).setDhOcupacao(null);
        pagamento.getVagas().get(0).setSituacao(SituacaoVagaEnum.LIVRE);
        return pagamento;
    }

    @Override
    public PagamentoDTO consultarTotal(Vaga vaga) throws CustomException {
        Vaga aPagar = vagaService.consultarVaga(vaga);
        if (aPagar.getSituacao().equals(SituacaoVagaEnum.LIVRE)) {
            throw new CustomException(RentacarValidacoes.ERRO_AO_PAGAR_VAGA_LIVRE);
        }

        LocalDateTime dhSaida = LocalDateTime.now();
        LocalDateTime dhEntrada = LocalDateTime.ofInstant(aPagar.getDhOcupacao().toInstant(), aPagar.getDhOcupacao().getTimeZone().toZoneId());
        Double totalHoras = (double) Duration.between(dhEntrada, dhSaida).getSeconds() / 60 / 60;
        Double totalAPagar = parametrosRentacar.getEstacionamentoValor();

        if (totalHoras > parametrosRentacar.getEstacionamentoHoraPermanencia()) {
            int hr = totalHoras.intValue();
            hr -= parametrosRentacar.getEstacionamentoHoraPermanencia().intValue();
            totalAPagar += ((double) hr > 0 ? hr : 1) * parametrosRentacar.getEstacionamentoValorExcedente();
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(totalAPagar);

        PropertyMap<Pagamento, PagamentoDTO> propertyMap = new PropertyMap<Pagamento, PagamentoDTO>() {
            @Override
            protected void configure() {
                map(source.getValor(), destination.getTotalAPagar());
                skip().setValor(null);
            }
        };
        getModelMapper().addMappings(propertyMap);
        PagamentoDTO pagamentoDTO = getModelMapper().map(pagamento, PagamentoDTO.class);
        return pagamentoDTO;
    }

    @Override
    public List<PagamentoDTO> consultarPagamentosPorPeriodo(String dtInicial, String dtFinal) throws CustomException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "br"));

        LocalDate dataInical = LocalDate.from(formatter.parse(dtInicial));
        LocalDate dataFinal = LocalDate.from(formatter.parse(dtFinal));

        if (ChronoUnit.DAYS.between(dataInical, dataFinal) < 0) {
            throw new CustomException(RentacarValidacoes.ERRO_AO_PAGAR_SEM_VAGA);
        }

        Calendar c = new GregorianCalendar(dataInical.getYear(), dataInical.getMonth().getValue() - 1, dataInical.getDayOfMonth());
        Calendar d = new GregorianCalendar(dataFinal.getYear(), dataFinal.getMonth().getValue() - 1, dataFinal.getDayOfMonth());

        List<Pagamento> pagamentosPorPeriodo = getRepository().findByDtPagamentoBetween(c, d);
        PropertyMap<Pagamento, PagamentoDTO> propertyMap = new PropertyMap<Pagamento, PagamentoDTO>() {
            @Override
            protected void configure() {
                skip().setVagas(null);
            }
        };

        getModelMapper().addMappings(propertyMap);
        Type type = new TypeToken<List<PagamentoDTO>>(){}.getType();

        return getModelMapper().map(pagamentosPorPeriodo, type);
    }
}
