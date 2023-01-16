package org.cherif.mediatheque.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.cherif.mediatheque.dto.ProduitDto;
import org.cherif.mediatheque.service.facade.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    @Autowired
    private   ProduitService produitService;

    public ProduitController (ProduitService produitService){
        this.produitService=produitService;
    }

    //ALT SUP DELEGUETE METHODES
    @PostMapping("/")
    public ProduitDto save(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @RequestMapping(value = "/ref/{ref_produit}", method = RequestMethod.GET)
    public ProduitDto findByRef(@PathVariable("ref_produit") String ref) {
        return produitService.findByRef(ref);
    }

    @RequestMapping(value = "/ref/{ref}", method = RequestMethod.DELETE)

    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }

    @RequestMapping(value = "/ref/{ref}", method = RequestMethod.PUT)
    public ProduitDto update(@Valid @RequestBody ProduitDto produitDto) {
            return produitService.update(produitDto);
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ProduitDto> findAll(){

        return produitService.findAll();
    }
}
