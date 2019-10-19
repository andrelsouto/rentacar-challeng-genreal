package com.andre.desafio.rentacar.models;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Where(clause = "deleted = false")
public class Setor extends AbstractEntity {

    private static final long serialVersionUID = 2051503415947879342L;

    @NotNull(message = "{notnull}")
    @NotBlank(message = "{notblank}")
    private String descricao;
<<<<<<< HEAD
    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    private List<Vaga> vagas;

=======

    @OneToMany(mappedBy = "setor", fetch = FetchType.LAZY)
    private List<Vaga> vagas;


>>>>>>> ajustes
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
}
