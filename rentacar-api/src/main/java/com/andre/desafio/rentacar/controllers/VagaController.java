package com.andre.desafio.rentacar.controllers;

import com.andre.desafio.rentacar.enums.SituacaoVagaEnum;
import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Vaga;
import com.andre.desafio.rentacar.models.dto.VagaDTO;
import com.andre.desafio.rentacar.services.VagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vaga")
public class VagaController extends GenericController<VagaService> {

    @PostMapping("cadastrar")
    public ResponseEntity<Vaga> cadastrarVaga(@RequestBody @Valid Vaga vaga) {

        return ResponseEntity.status(HttpStatus.CREATED).body(getService().cadastrarVaga(vaga));
    }

    @GetMapping("listar")
    public ResponseEntity<Map<String, List<VagaDTO>>> listarVags() {

        return ResponseEntity.ok(getService().listarVaga());
    }
    @PostMapping("estacionar")
    public ResponseEntity<Vaga> estacionar (@RequestBody Vaga vaga) throws CustomException {

        return ResponseEntity.ok(getService().estacionarVeiculo(vaga));
    }

    @GetMapping("listar-por-situacao/{situacao}")
    public ResponseEntity<Map> vagasDisponiveis(@PathVariable int situacao) {

        return ResponseEntity.ok(getService().vagasPorSituacao(SituacaoVagaEnum.valueOf(situacao)));
    }
}
