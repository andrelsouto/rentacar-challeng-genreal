package com.andre.desafio.rentacar.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;
import java.util.List;

public class PagamentoDTO extends AbstractDTO {

    private static final long serialVersionUID = 7515428931969596281L;

    private Double valor;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-br", timezone = "America/Recife")
    private Calendar dtPagamento;
    private List<VagaDTO> vagas;
    private Double totalAPagar;
    private Double totalAPago;
    private Double troco;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Calendar dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public List<VagaDTO> getVagas() {
        return vagas;
    }

    public void setVagas(List<VagaDTO> vagas) {
        this.vagas = vagas;
    }

    public Double getTotalAPago() {
        return totalAPago;
    }

    public void setTotalAPago(Double totalAPago) {
        this.totalAPago = totalAPago;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
}
