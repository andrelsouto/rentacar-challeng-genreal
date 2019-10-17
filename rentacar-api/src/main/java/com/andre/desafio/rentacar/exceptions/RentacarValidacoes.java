package com.andre.desafio.rentacar.exceptions;

import org.springframework.http.HttpStatus;

public enum RentacarValidacoes {

    DAFAULT_ERROR("erro.default.rentacar", HttpStatus.INTERNAL_SERVER_ERROR.value()),
    ERRO_AO_ESTACIONAR("RENT01", HttpStatus.BAD_REQUEST.value()),
    ERRO_AO_PAGAR_VAGA_LIVRE("RENT02", HttpStatus.BAD_REQUEST.value()),
    ERRO_AO_PAGAR_VALOR_NULO("RENT03", HttpStatus.BAD_REQUEST.value()),
    ERRO_AO_PAGAR_VALOR_BAIXO("RENT04", HttpStatus.BAD_REQUEST.value()),
    ERRO_AO_PAGAR_SEM_VAGA("RENT05", HttpStatus.BAD_REQUEST.value()),
    ERRO_AO_ESTACIONAR_PLACA("RENT06", HttpStatus.BAD_REQUEST.value());

    private final String codigo;
    private final int httpStatus;

    RentacarValidacoes(String codigo, int httpStatus) {
        this.codigo = codigo;
        this.httpStatus = httpStatus;
    }

    public String getDescricaoMsg() {
        return MessageProperty.getMessage(this.codigo);
    }

    public String getCodigo() {
        return codigo;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
