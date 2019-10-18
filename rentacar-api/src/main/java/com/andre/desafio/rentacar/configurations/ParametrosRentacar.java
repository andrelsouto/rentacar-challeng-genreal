package com.andre.desafio.rentacar.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@PropertySource(value = "classpath:parametros-rentacar.properties")
public class ParametrosRentacar implements Serializable {

    private static final long serialVersionUID = -1646670419054964319L;

    @Value("${estacionamento.valor}")
    private Double estacionamentoValor;
    @Value("${estacionamento.valor.excedente}")
    private Double estacionamentoValorExcedente;
    @Value("${estacionamento.hora.permanencia}")
    private Double estacionamentoHoraPermanencia;

    public Double getEstacionamentoValor() {
        return estacionamentoValor;
    }

    public void setEstacionamentoValor(Double estacionamentoValor) {
        this.estacionamentoValor = estacionamentoValor;
    }

    public Double getEstacionamentoValorExcedente() {
        return estacionamentoValorExcedente;
    }

    public void setEstacionamentoValorExcedente(Double estacionamentoValorExcedente) {
        this.estacionamentoValorExcedente = estacionamentoValorExcedente;
    }

    public Double getEstacionamentoHoraPermanencia() {
        return estacionamentoHoraPermanencia;
    }

    public void setEstacionamentoHoraPermanencia(Double estacionamentoHoraPermanencia) {
        this.estacionamentoHoraPermanencia = estacionamentoHoraPermanencia;
    }
}
