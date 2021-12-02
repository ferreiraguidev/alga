package com.example.alga.controller;

import com.example.alga.model.Cozinha;
import com.example.alga.model.CozinhaPostReqBody;
import com.example.alga.model.CozinhaPutReqBody;
import com.example.alga.repository.CozinhaRepository;
import com.example.alga.service.CozinhaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    private CozinhaRepository cozinhaRepository;


    private final CozinhaService cozinhaService;

    public CozinhaController(CozinhaService cozinhaService) {
        this.cozinhaService = cozinhaService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Cozinha>> listarCozinhas() {
        return new ResponseEntity<>(cozinhaService.cozinhaList(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> listarCozinhasPorId(@PathVariable Long id) {

        Cozinha cozinha = cozinhaService.findById(id);
        return ResponseEntity.ok(cozinha);
    }

    @PostMapping
    public Cozinha adicionar(@RequestBody CozinhaPostReqBody cozinhaPostReqBody) {
        return cozinhaService.salvar(cozinhaPostReqBody);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> update(@RequestBody CozinhaPutReqBody cozinhaPutReqBody) {

        cozinhaService.editar(cozinhaPutReqBody);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> deletar(@PathVariable Long id) {

        cozinhaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/cozinhas/restaurante-id")
    public int restauranteCozinhaId(Long restauranteId) {
        return cozinhaRepository.countByRestauranteId(restauranteId);
    }

}
