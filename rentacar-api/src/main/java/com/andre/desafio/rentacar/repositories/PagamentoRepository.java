package com.andre.desafio.rentacar.repositories;

import com.andre.desafio.rentacar.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {

    List<Pagamento> findByDtPagamentoBetween(Calendar dtInical, Calendar dtFinal);
}
