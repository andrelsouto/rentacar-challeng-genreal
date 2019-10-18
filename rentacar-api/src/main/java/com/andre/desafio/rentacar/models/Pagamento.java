package com.andre.desafio.rentacar.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import org.hibernate.annotations.Where;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.List;

@Entity
@Where(clause = "deleted = false")
public class Pagamento extends AbstractEntity {

    private static final long serialVersionUID = -5211865143050051835L;

    @NotNull(message = "{notnull}")
    private Double valor;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-br", timezone = "America/Recife")
    private Calendar dtPagamento;
    @NotNull(message = "{notnull}")
    @ManyToMany
    private List<Vaga> vagas;

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

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
}
