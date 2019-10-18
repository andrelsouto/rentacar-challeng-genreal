package com.andre.desafio.rentacar.exceptions;

public class CustomException extends Exception {

    private static final long serialVersionUID = 4637570687462554806L;
    private final RentacarValidacoes rentacarValidacoes;

    public CustomException(RentacarValidacoes dafaultError) {
        super(dafaultError.getDescricaoMsg());
        this.rentacarValidacoes = dafaultError;
    }



    public RentacarValidacoes getRentacarValidacoes() {
        return rentacarValidacoes;
    }
}
