package org.cherif.mediatheque.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.cherif.mediatheque.dto.ProduitDto;
import org.cherif.mediatheque.service.facade.ProduitService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    //ALT SUP DELEGUETE METHODES
    @PostMapping("/")
    public ProduitDto save(@Valid @RequestBody ProduitDto produitDto) {
        return produitService.save(produitDto);
    }

    @GetMapping("/ref{ref}/")
    public ProduitDto findByRef(@PathVariable String ref) {
        return produitService.findByRef(ref);
    }
}
