package com.andre.desafio.rentacar.controllers;

import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Pagamento;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.PagamentoDTO;
import com.andre.desafio.rentacar.services.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("pagamento")
public class PagamentoController extends GenericController<PagamentoService> {

    @PostMapping("pagar")
    public ResponseEntity<PagamentoDTO> pagarEstacionamento(@RequestBody @Valid PagamentoDTO pagamento) throws CustomException {

        return ResponseEntity.ok(getService().cadastrar(pagamento));
    }

    @PostMapping("consultar-total-a-pagar")
    public ResponseEntity<PagamentoDTO> consultar(@RequestBody Vaga vaga) throws CustomException {

        return ResponseEntity.ok(getService().consultarTotal(vaga));
    }

    @GetMapping("consultar-pagamentos")
    public ResponseEntity<List<PagamentoDTO>> relatorioPagamentos(@RequestParam String dtInicial, @RequestParam String dtFinal) throws CustomException {

        return ResponseEntity.ok(getService().consultarPagamentosPorPeriodo(dtInicial, dtFinal));
    }
}
