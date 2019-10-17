package com.andre.desafio.rentacar.controllers;

import com.andre.desafio.rentacar.exceptions.CustomException;
import com.andre.desafio.rentacar.models.Setor;
import com.andre.desafio.rentacar.models.dto.SetorDTO;
import com.andre.desafio.rentacar.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("setor")
public class SetorController extends GenericController<SetorService> {

    @PostMapping("cadastrar")
    public ResponseEntity<Setor> cadastrarSetor(@RequestBody @Valid Setor setor) {

        return ResponseEntity.ok(getService().cadastrarSetor(setor));
    }

    @GetMapping("listar")
    public ResponseEntity<List<SetorDTO>> listarSetor() throws CustomException {

        return ResponseEntity.ok(getService().listarSetores());
    }
}
