package org.cherif.mediatheque.service.facade;

import org.cherif.mediatheque.dto.ClientRequestDto;
import org.cherif.mediatheque.dto.ClientResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;


public interface ClientService {

    ClientResponseDto save(ClientRequestDto clientRequestDto);

    ClientResponseDto findById(Integer id);

    ClientResponseDto findByNom(String nom);

    void delete(Integer id);

    ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws ChangeSetPersister.NotFoundException;

    List<ClientResponseDto> findAll();


}
