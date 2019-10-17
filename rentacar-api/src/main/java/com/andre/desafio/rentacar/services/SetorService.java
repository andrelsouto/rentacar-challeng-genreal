package com.andre.desafio.rentacar.services;

import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Setor;
import com.andre.desafio.rentacar.models.dto.SetorDTO;

import java.util.List;

public interface SetorService extends GenericService {

    Setor cadastrarSetor(Setor setor);

    List<SetorDTO> listarSetores() throws CustomException;
}
