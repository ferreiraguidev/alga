package com.example.alga.controller;

import com.example.alga.model.Estado;
import com.example.alga.model.EstadoPostReqBody;
import com.example.alga.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {


    private final EstadoService estadoService;

    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity <List<Estado>> estadoList() {
        return new ResponseEntity<>(estadoService.listaEstados(),HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Estado> adicionar(@RequestBody EstadoPostReqBody estadoPostReqBody) {
        return new ResponseEntity<>(estadoService.salvar(estadoPostReqBody), HttpStatus.CREATED);
    }

}
