package com.andre.desafio.rentacar.services;

import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Pagamento;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.PagamentoDTO;

import java.util.Calendar;
import java.util.List;

public interface PagamentoService extends GenericService {

    PagamentoDTO cadastrar(PagamentoDTO pagamento) throws CustomException;

    PagamentoDTO consultarTotal(Vaga vaga) throws CustomException;

    List<PagamentoDTO> consultarPagamentosPorPeriodo(String dtInicial, String dtFinal) throws CustomException;
}
