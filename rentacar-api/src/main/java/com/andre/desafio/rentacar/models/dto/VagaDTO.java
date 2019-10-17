package com.andre.desafio.rentacar.models.dto;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Calendar;
import java.util.List;

public class VagaDTO  extends AbstractDTO {

    private static final long serialVersionUID = -7190999254456170853L;

    private String descricao;
    private SetorDTO setor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-br", timezone = "America/Recife")
    private Calendar dhOcupacao;
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private SituacaoVagaEnum situacao;

    private String placaVeiculo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public SetorDTO getSetor() {
        return setor;
    }

    public void setSetor(SetorDTO setor) {
        this.setor = setor;
    }

    public Calendar getDhOcupacao() {
        return dhOcupacao;
    }

    public void setDhOcupacao(Calendar dhOcupacao) {
        this.dhOcupacao = dhOcupacao;
    }

    public SituacaoVagaEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoVagaEnum situacao) {
        this.situacao = situacao;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}
