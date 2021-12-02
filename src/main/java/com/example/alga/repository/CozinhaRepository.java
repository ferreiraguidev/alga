package com.example.alga.repository;

import com.example.alga.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    int countByRestauranteId(Long restauranteId);
}
