package com.andre.desafio.rentacar.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SituacaoVagaEnum {

    LIVRE (0, "Vaga livre"),
    OCUPADA (1, "Vaga ocupada");

    private final int codigo;
    private final String descricao;

    SituacaoVagaEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static SituacaoVagaEnum valueOf(int codigo) {
        return
                Arrays.stream(SituacaoVagaEnum.values()).filter(cod -> cod.getCodigo() == codigo).collect(Collectors.toList()).get(0);
    }
}
