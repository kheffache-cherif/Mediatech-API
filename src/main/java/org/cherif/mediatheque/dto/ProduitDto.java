package org.cherif.mediatheque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor


public class ProduitDto {

    @NotBlank
    private String ref;
    @NotBlank
    private String libelle;
    @NotNull
    private BigDecimal prix;
    @NotNull
    private Long quantiteStock;


}
