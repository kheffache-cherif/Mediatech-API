package org.cherif.mediatheque.service.impl;

import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;

import org.cherif.mediatheque.dao.ProduitDao;
import org.cherif.mediatheque.dto.ProduitDto;
import org.cherif.mediatheque.models.ProduitEntity;
import org.cherif.mediatheque.service.facade.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {


    // inection du clientDao et du modell Mapper par constructeur

    @Autowired
    private  ProduitDao produitDao;
    @Autowired
    private ModelMapper modelMapper;

    public ProduitServiceImpl(ProduitDao produitDao, ModelMapper modelMapper){
        this.produitDao = produitDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProduitDto save(ProduitDto produitDto) {
        //EZnregisteremnt d'un produitDto.
        //1- veriffication s'il existe
        if(findByRef(produitDto.getRef()) != null) return null;
        //2- transformation de l'objet dto en une entuty PRODUIT
        ProduitEntity produitEntity = modelMapper.map(produitDto,ProduitEntity.class);
        ProduitEntity savedProduit = produitDao.save(produitEntity);
        return modelMapper.map(savedProduit, ProduitDto.class);
    }

    @Transactional // quant on fazut castum la produitDao
    @Override
    public int delete(String ref) {
       return  produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {
        //1) je recupere l'entity elle meme car elle contient l'entité
        //optionnel pour dire si elle existe d'ou le if
        Optional<ProduitEntity> produitEntity = produitDao.findByRef((produitDto.getRef()));
        if(produitEntity.isEmpty()) return null;
        //les champs modifiable
        update(produitEntity.get(),produitDto); // appel par reference

        // recuperer le produit en question
        ProduitEntity saved = produitDao.save((produitEntity.get()));
        // renvoyer un produitDTO
        return modelMapper.map(saved,ProduitDto.class);
    }

    private void update(ProduitEntity produitEntity,ProduitDto produitDto){
        //les champs modifiable
        produitEntity.setLibelle(produitDto.getLibelle());
        produitEntity.setPrix(produitDto.getPrix());
        produitEntity.setQantiteStock(produitDto.getQuantiteStock());
    }

    @Override
    public ProduitDto findByRef(String ref) {
        ProduitEntity produitEntity= produitDao.findByRef(ref).orElse(null);
        if(produitEntity==null) return  null;
        return modelMapper.map(produitEntity,ProduitDto.class);
    }



    public List<ProduitDto>findAll(){
        return produitDao.findAll().stream().map(el-> modelMapper.map(el,ProduitDto.class)).collect(Collectors.toList());
    }

}
