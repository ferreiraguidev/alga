package com.example.alga.controller;

import com.example.alga.model.Cidade;
import com.example.alga.model.CidadePostReqBody;
import com.example.alga.service.CidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> listAll() {
        return new ResponseEntity<>(cidadeService.listaEstados(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cidade> adicionar(@RequestBody CidadePostReqBody cidadePostReqBody) {
        return new ResponseEntity<>(cidadeService.salvar(cidadePostReqBody), HttpStatus.CREATED);
    }


}
