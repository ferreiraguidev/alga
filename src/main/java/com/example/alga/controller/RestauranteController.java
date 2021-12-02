package com.example.alga.controller;

import com.example.alga.model.Restaurante;
import com.example.alga.model.RestaurantePostReqBody;
import com.example.alga.model.RestaurantePutReqBody;
import com.example.alga.repository.RestauranteRepository;
import com.example.alga.service.RestauranteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private RestauranteRepository restauranteRepository;


    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Restaurante>> listarRestaurantes() {
        return new ResponseEntity<>(restauranteService.listRestaurants(), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> listarRestaurantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(restauranteService.findById(id));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Restaurante> criar(@RequestBody RestaurantePostReqBody restaurantePostReqBody) {
        return new ResponseEntity<>(restauranteService.salvar(restaurantePostReqBody)
                , HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public ResponseEntity<Void> editar(@RequestBody RestaurantePutReqBody restaurantePutReqBody) {
        restauranteService.editar(restaurantePutReqBody);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity<Restaurante> deletar(@PathVariable Long id) {
        restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/restauranteId")
    public ResponseEntity<?> editarParcial(@PathVariable Long restauranteId,
                                           @RequestBody Map<String, Object> campos) {
        ObjectMapper objectMapper = new ObjectMapper();

        Restaurante newRest = restauranteService.findById(restauranteId);

        if (newRest == null) {
            return ResponseEntity.noContent().build();
        }

        campos.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            field.setAccessible(true);
            System.out.println(nomePropriedade + " = " + valorPropriedade);

            ReflectionUtils.setField(field, newRest, valorPropriedade);

        });
        return ResponseEntity.ok().build();

    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(String nome, Long cozinhaId) {

        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);

    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/restaurantes/por-taxa")
    public List<Restaurante> restaurantesPorTaxa(Long taxaInicial, Long taxaFinal) {
        return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);

    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/restaurantes/nome")
    public Optional<Restaurante> restaurantesPorTaxa(String nome) {
        return restauranteRepository.findByNomeContaining(nome);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/restaurantes/exists")
    public boolean restauranteExiste(String nome) {
        return restauranteRepository.existsByNome(nome);
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/restaurantes/frete-gratis")
    public List<Restaurante> restauranteComFreteGratis(String nome) {
        return restauranteRepository.findByNomeContainingTaxaFreteGratis(nome);
    }


}
