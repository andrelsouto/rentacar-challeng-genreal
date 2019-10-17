package com.andre.desafio.rentacar.services.impl;

import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.exceptions.RentacarValidacoes;
import com.andre.desafio.rentacar.models.Setor;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.SetorDTO;
import com.andre.desafio.rentacar.models.dto.VagaDTO;
import com.andre.desafio.rentacar.repositories.SetorRepository;
import com.andre.desafio.rentacar.services.GenericService;
import com.andre.desafio.rentacar.services.SetorService;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class SetorServiceImpl extends GenericServiceImpl<SetorRepository> implements SetorService {

    @Override
    public Setor cadastrarSetor(Setor setor) {
        return getRepository().save(setor);
    }

    @Override
    public List<SetorDTO> listarSetores() throws CustomException {

        List<Setor> setores = getRepository().findAll();

        Type type = new TypeToken<List<SetorDTO>>() {
        }.getType();

        PropertyMap<Vaga, VagaDTO> propertyMap = new PropertyMap<Vaga, VagaDTO>() {
            @Override
            protected void configure() {
                skip().setSetor(null);
            }
        };

        getModelMapper().addMappings(propertyMap);
        return getModelMapper().map(setores, type);
    }
}
