package com.andre.desafio.rentacar.models;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Where;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Calendar;
import java.util.List;

@Entity
@Where(clause = "deleted = false")
public class Vaga extends AbstractEntity {

    private static final long serialVersionUID = 5065593400107335778L;

    @NotNull(message = "{notnull}")
    @NotBlank(message = "{notblank}")
    private String descricao;
    @ManyToOne
    @NotNull(message = "{notnull}")
    private Setor setor;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss", locale = "pt-br", timezone = "America/Recife")
    private Calendar dhOcupacao;
    @Enumerated(EnumType.ORDINAL)
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    private SituacaoVagaEnum situacao;
    @ManyToMany(mappedBy = "vagas", fetch = FetchType.LAZY)
    private List<Pagamento> pagamentos;
    @Pattern(regexp = "^([A-Z]{3})([0-9]{4}$)", message = "{patterplaca}")
    private String placaVeiculo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public SituacaoVagaEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoVagaEnum situacao) {
        this.situacao = situacao;
    }

    public Calendar getDhOcupacao() {
        return dhOcupacao;
    }

    public void setDhOcupacao(Calendar dhOcupacao) {
        this.dhOcupacao = dhOcupacao;
    }


    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
}
