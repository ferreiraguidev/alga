package com.example.alga.service;

import com.example.alga.exceptions.BadRequestException;
import com.example.alga.model.Restaurante;
import com.example.alga.model.RestaurantePostReqBody;
import com.example.alga.model.RestaurantePutReqBody;
import com.example.alga.repository.CozinhaRepository;
import com.example.alga.repository.RestauranteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CozinhaRepository cozinhaRepository;

    public Restaurante findById(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Could not find correspondent id"));

    }

    public Restaurante salvar(RestaurantePostReqBody restaurantePostReqBody) {

        Restaurante restaurante = Restaurante.builder()
                .nome(restaurantePostReqBody.getNome())
                .taxaFrete(restaurantePostReqBody.getTaxaFrete())
                .cozinha(cozinhaRepository.findById(restaurantePostReqBody.getCozinhaId())
                        .orElseThrow(() -> new BadRequestException("not found")))
                .build();

        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listRestaurants() {
        return restauranteRepository.findAll();
    }

    public void delete(Long id) {
        restauranteRepository.deleteById(id);

    }

    public void editar(RestaurantePutReqBody restaurantePutReqBody) {

        Restaurante savedRestaurant = findById(restaurantePutReqBody.getId());

        Restaurante restaurante = Restaurante.builder()
                .id(savedRestaurant.getId())
                .nome(restaurantePutReqBody.getNome())
                .taxaFrete(restaurantePutReqBody.getTaxaFrete())
                .cozinha(cozinhaRepository.findById(restaurantePutReqBody.getCozinhaId())
                        .orElseThrow(() -> new BadRequestException("NOT FOUND")))
                .build();

        restauranteRepository.save(restaurante);
    }

}
