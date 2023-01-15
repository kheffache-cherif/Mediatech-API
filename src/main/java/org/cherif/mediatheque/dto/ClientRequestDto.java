package org.cherif.mediatheque.dto;

// Represente l'objet et donner venant de l'exterieur exp: ajout d'un client et ses champs.
// requete Http: dans le requestBody ----> on reçoit un objet request.


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {

// Validation data spring boot  puis fiare la validation dans le controller : Methode avec RequestBody.
    //@NotNull(message="Le nom doit etre obligatoirement rensigné")
   // @Size(min = 4 ,max = 15,message = "le nombre de caractere doit etre compris entre 50et 15")


    @NotBlank() // pas d'espace au champs vide
    @Size(min = 4 ,max = 15,message = "le nombre de caractere doit etre compris entre 4 et 15")
    private String nom;

    @NotNull(message="Le nom doit etre obligatoirement rensigné")
    @Size(min = 4 ,max = 15,message = "le nombre de caractere doit etre compris entre 4 et 15")
    private String prenom;

    @NotNull
    @Pattern(regexp = "^(\\+33|0)([ \\-_/]*)(\\d[ \\-_/]*){9}$",message = "format invalid à mon amiii")
    private String telephone;
}
