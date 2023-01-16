package org.cherif.mediatheque.controllers;


import jakarta.validation.Valid;
import org.cherif.mediatheque.dto.ClientRequestDto;
import org.cherif.mediatheque.dto.ClientResponseDto;
import org.cherif.mediatheque.service.facade.ClientService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")


public class ClientController {
     // injection du service dans le contoller
    // @Autowired pour l'injection du service dans le controller


    // @Autowired
    private ClientService clientService;

    //ou faire une injection par constructeur
    public ClientController(ClientService clientService){
        this.clientService =clientService;
    }


    @GetMapping("")
    //utilisation de responseEntity.
    public ResponseEntity<List<ClientResponseDto>>  getClient(){

        //return clientService.findAll();
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK); //ok pour la requete Get code 200
    }
    @PostMapping("")
    //RequestBody() : represente donnees externes
    //@Valid: c'est pour appliquer la data validation exigée dans requestDto
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientRequestDto){
       // return clientService.save(clientRequestDto);
        ClientResponseDto clientResponseDto =  clientService.save(clientRequestDto);
        return new ResponseEntity<>(clientResponseDto,HttpStatus.CREATED);
    }

    @GetMapping("/id/{id_client}")
    public ResponseEntity<ClientResponseDto>  findById(@PathVariable("id_client") Integer id) {
       // return clientService.findById(id);
        ClientResponseDto clientResponseDto =clientService.findById(id);
        return  ResponseEntity.ok(clientResponseDto); // methode deux acces static aux methode
    }

    @GetMapping("/nom/{nom_client}")
    public ResponseEntity<ClientResponseDto>  findByNom(@PathVariable("nom_client")String nom) {
        ClientResponseDto clientResponseDto =clientService.findByNom(nom);
        return  ResponseEntity.ok(clientResponseDto);
       // return clientService.findByNom(nom);
    }
    @DeleteMapping("/id/{id_client}")
    //public void delete(@PathVariable("id_client")Integer id) {
        //clientService.delete(id);
    public ResponseEntity<?> delete(@PathVariable("id_client")Integer id) {
        //clientService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id_client}")
    //RequestBody() : represente donnees externes
    //@Valid: c'est pour appliquer la data validation exigée dans requestDto
    public ResponseEntity<ClientResponseDto> update(@Valid @RequestBody() ClientRequestDto clientRequestDto, @PathVariable("id_client") Integer id) throws ChangeSetPersister.NotFoundException {
        ClientResponseDto clientResponseDto= clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);
   }
}
