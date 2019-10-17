package com.andre.desafio.rentacar.repositories;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.models.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, UUID> {

    List<Vaga> findBySituacaoOrderBySetorDescDescricao(SituacaoVagaEnum situacao);
}
