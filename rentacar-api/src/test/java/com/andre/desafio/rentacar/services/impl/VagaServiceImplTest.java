package com.andre.desafio.rentacar.services.impl;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Setor;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.VagaDTO;
import com.andre.desafio.rentacar.repositories.VagaRepository;
import com.andre.desafio.rentacar.services.VagaService;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class VagaServiceImplTest {

    @InjectMocks
    private VagaService vagaService = new VagaServiceImpl() {

        @Override
        public ModelMapper getModelMapper() {
            return new ModelMapper();
        }
    };
    @Mock
    private VagaRepository vagaRepository;

    @Test
    void consultarVagaTest() {
        setUpListar();
        Map<String, List<VagaDTO>> mapaVagas = vagaService.listarVaga();

        assertThat(mapaVagas.isEmpty()).isFalse();
        assertThat(mapaVagas.get("A")).hasSize(1);

    }

    @Test
    void estacionarVeiculoTest() throws CustomException {
        setUpEstacionar();
        Vaga est = new Vaga();
        est.setId(UUID.fromString("ee1f280c-a150-4c90-9d91-63ab34a91aa0"));
        est.setPlacaVeiculo("ABC1234");
        Vaga vaga = vagaService.estacionarVeiculo(est);

        assertThat(vaga.getId().toString()).isEqualTo(UUID.fromString("ee1f280c-a150-4c90-9d91-63ab34a91aa0").toString());
        assertThat(vaga.getSituacao().getCodigo()).isEqualTo(SituacaoVagaEnum.OCUPADA.getCodigo());
        assertThat(vaga.getDhOcupacao()).isNotNull();
    }

    private void setUpEstacionar() {
        Vaga v = new Vaga();
        v.setId(UUID.fromString("ee1f280c-a150-4c90-9d91-63ab34a91aa0"));
        v.setDescricao("A1");
        v.setSituacao(SituacaoVagaEnum.LIVRE);

        Vaga estacionado = new Vaga();
        estacionado.setId(UUID.fromString("ee1f280c-a150-4c90-9d91-63ab34a91aa0"));
        estacionado.setDescricao("A1");
        estacionado.setSituacao(SituacaoVagaEnum.OCUPADA);
        estacionado.setDhOcupacao(Calendar.getInstance());
        Setor setor = new Setor();
        setor.setId(UUID.fromString("ce269fdf-38a2-497a-bd23-5030f6b8a967"));
        setor.setDescricao("A");
        estacionado.setSetor(setor);

        when(vagaRepository.save(v)).thenReturn(estacionado);
        when(vagaRepository.getOne(UUID.fromString("ee1f280c-a150-4c90-9d91-63ab34a91aa0"))).thenReturn(v);
    }
    private void setUpListar() {
        Vaga v = new Vaga();
        v.setId(UUID.fromString("ee1f280c-a150-4c90-9d91-63ab34a91aa0"));
        v.setDescricao("A1");

        Setor s = new Setor();
        s.setDescricao("A");
        v.setSetor(s);

        ImmutableList<Vaga> vagas = new ImmutableList.Builder<Vaga>()
                .add(v)
                .build();
        when(vagaRepository.findAll()).thenReturn(vagas);
    }
}