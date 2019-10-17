package com.andre.desafio.rentacar.models.dto;

import java.util.List;

public class SetorDTO extends AbstractDTO {

    private String descricao;
    private List<VagaDTO> vagas;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<VagaDTO> getVagas() {
        return vagas;
    }

    public void setVagas(List<VagaDTO> vagas) {
        this.vagas = vagas;
    }
}
