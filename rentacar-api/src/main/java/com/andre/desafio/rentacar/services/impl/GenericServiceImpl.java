package com.andre.desafio.rentacar.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class GenericServiceImpl<T extends JpaRepository> {

    @Autowired
    private T repository;

    @Autowired
    private ModelMapper modelMapper;

    public T getRepository() {
        return repository;
    }

    public ModelMapper getModelMapper() {
        return modelMapper;
    }
}
