package org.cherif.mediatheque.dao;

import org.cherif.mediatheque.models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientDao extends JpaRepository<ClientEntity,Integer> {

    //objet client entité verification des attributs de l'objet
    // spring data va deduire la requette.
    ClientEntity findByNom(String nom);
}
