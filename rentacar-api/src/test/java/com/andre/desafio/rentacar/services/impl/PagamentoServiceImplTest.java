package com.andre.desafio.rentacar.services.impl;

import com.andre.desafio.rentacar.configurations.ParametrosRentacar;
import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.PagamentoDTO;
import com.andre.desafio.rentacar.repositories.VagaRepository;
import com.andre.desafio.rentacar.services.PagamentoService;
import com.andre.desafio.rentacar.services.VagaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Calendar;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PagamentoServiceImplTest {

    @InjectMocks
    private VagaService vagaService = new VagaServiceImpl();
    @Mock
    private VagaRepository vagaRepository;
    private ParametrosRentacar parametrosRentacar = new ParametrosRentacar() {
        @Override
        public Double getEstacionamentoHoraPermanencia() {
            return 3d;
        }

        @Override
        public Double getEstacionamentoValor() {
            return 7d;
        }

        @Override
        public Double getEstacionamentoValorExcedente() {
            return 3d;
        }
    };
    @InjectMocks
    private PagamentoService pagamentoService = new PagamentoServiceImpl(vagaService, parametrosRentacar){
        @Override
        public ModelMapper getModelMapper() {
            return new ModelMapper();
        }
    };

    @BeforeEach
    public void setUp() {

        UUID id = UUID.randomUUID();
        Vaga v = new Vaga();
        v.setSituacao(SituacaoVagaEnum.OCUPADA);
        v.setDhOcupacao(Calendar.getInstance());
        v.setId(id);

        when(vagaRepository.getOne(any())).thenReturn(v);

    }


    @Test
    void consultarTotalTest() throws CustomException {

        Vaga vaga = new Vaga();
        vaga.setId(UUID.randomUUID());
        PagamentoDTO pagamentoDTO = pagamentoService.consultarTotal(vaga);

        assertThat(pagamentoDTO).isNotNull();
        assertThat(pagamentoDTO.getValor()).isEqualTo(7d);
    }
}