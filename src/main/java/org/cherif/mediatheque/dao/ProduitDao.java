package org.cherif.mediatheque.dao;

import org.cherif.mediatheque.models.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProduitDao extends JpaRepository<ProduitEntity,Integer> {

            // Optional introduit depuis java 8 facilite la recherche avec les nulls

    Optional<ProduitEntity> findByRef(String ref);

    Optional<ProduitEntity> findAllByLibelle(String libelle);

    List<ProduitEntity> findByPrixGreaterThan(BigDecimal value);

    int deleteByRef(String ref);

    List<ProduitEntity> findAll();


}
