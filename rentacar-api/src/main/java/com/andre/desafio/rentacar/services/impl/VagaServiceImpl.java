package com.andre.desafio.rentacar.services.impl;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.exceptions.RentacarValidacoes;
import com.andre.desafio.rentacar.models.Setor;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.SetorDTO;
import com.andre.desafio.rentacar.models.dto.VagaDTO;
import com.andre.desafio.rentacar.repositories.VagaRepository;
import com.andre.desafio.rentacar.services.VagaService;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VagaServiceImpl extends GenericServiceImpl<VagaRepository> implements VagaService {

    @Override
    public Vaga cadastrarVaga(Vaga vaga) {

        vaga.setSituacao(SituacaoVagaEnum.LIVRE);
        return getRepository().save(vaga);
    }

    @Override
    public Vaga consultarVaga(Vaga vaga) {

        return getRepository().getOne(vaga.getId());
    }

    @Override
    public Map vagasPorSituacao(SituacaoVagaEnum situacaoVagaEnum) {

        List<Vaga> vagas = getRepository().findBySituacaoOrderBySetorDescDescricao(situacaoVagaEnum);
        return vagas.isEmpty() ? null : getVagas(vagas);
    }

    private Map<String, List<VagaDTO>> getVagas(List<Vaga> vagasDisponiveis) {
        PropertyMap<Setor, SetorDTO> propertyMap = new PropertyMap<Setor, SetorDTO>() {
            @Override
            protected void configure() {
                skip().setVagas(null);
            }
        };
        Type type = new TypeToken<List<VagaDTO>>() {
        }.getType();
        getModelMapper().addMappings(propertyMap);
        List<VagaDTO> vagasDisponiveisDTO = getModelMapper().map(vagasDisponiveis, type);
        Map<String, List<VagaDTO>> setorVagas = vagasDisponiveisDTO.stream().collect(Collectors.groupingBy(setor -> setor.getSetor().getDescricao()));

        return setorVagas;
    }

    @Override
    public Map<String, List<VagaDTO>> listarVaga() {
        List<Vaga> vagas = getRepository().findAll();
        return vagas.isEmpty() ? null : getVagas(vagas);
    }

    @Override
    public Vaga estacionarVeiculo(Vaga vaga) throws CustomException {

        Vaga v = getRepository().getOne(vaga.getId());

        if (v.getSituacao().equals(SituacaoVagaEnum.OCUPADA)) {

            throw new CustomException(RentacarValidacoes.ERRO_AO_ESTACIONAR);
        }

        if (vaga.getPlacaVeiculo() == null) {

            throw new CustomException(RentacarValidacoes.ERRO_AO_ESTACIONAR_PLACA);
        }

        v.setSituacao(SituacaoVagaEnum.OCUPADA);
        v.setDhOcupacao(Calendar.getInstance());
        return getRepository().save(v);
    }

    @Override
    public Vaga liberarEstacionamento(Vaga vaga) throws CustomException {

        Vaga vagaConsulta = getRepository().getOne(vaga.getId());
        if (vagaConsulta.getSituacao().equals(SituacaoVagaEnum.LIVRE)) {
            throw new CustomException(RentacarValidacoes.ERRO_AO_PAGAR_VAGA_LIVRE);
        }

        vagaConsulta.setSituacao(SituacaoVagaEnum.LIVRE);
        vagaConsulta.setDhOcupacao(null);
        vagaConsulta.setPlacaVeiculo(null);
        return getRepository().save(vagaConsulta);
    }

}
