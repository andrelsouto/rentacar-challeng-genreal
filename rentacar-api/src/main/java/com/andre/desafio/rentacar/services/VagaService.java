package com.andre.desafio.rentacar.services;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.VagaDTO;

import java.util.List;
import java.util.Map;

public interface VagaService extends GenericService {

    Vaga cadastrarVaga(Vaga vaga);

    Vaga consultarVaga(Vaga vaga);

    Map vagasPorSituacao(SituacaoVagaEnum situacaoVagaEnum);

    Map listarVaga();

    Vaga estacionarVeiculo(Vaga vaga) throws CustomException;

    Vaga liberarEstacionamento(Vaga vaga) throws CustomException;

}
