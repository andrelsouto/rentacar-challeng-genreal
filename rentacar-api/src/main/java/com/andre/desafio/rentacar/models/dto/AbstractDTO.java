package com.andre.desafio.rentacar.models.dto;

import java.io.Serializable;
import java.util.UUID;

public class AbstractDTO implements Serializable {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
