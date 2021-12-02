package com.example.alga.repository;

import com.example.alga.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

//      @Query("from Restaurante where nome like %:nome%" and cozinha.id =:id)
//      List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);

    List<Restaurante> queryByTaxaFreteBetween(Long taxaInicial, Long taxaFinal);

    Optional<Restaurante> findByNomeContaining(String nome);

    boolean existsByNome(String nome);

    List<Restaurante> findByNomeContainingTaxaFreteGratis(String nome);


}
