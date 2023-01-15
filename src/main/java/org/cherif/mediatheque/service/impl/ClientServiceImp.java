package org.cherif.mediatheque.service.impl;

import org.cherif.mediatheque.dao.ClientDao;
import org.cherif.mediatheque.dto.ClientRequestDto;
import org.cherif.mediatheque.dto.ClientResponseDto;
import org.cherif.mediatheque.exceptions.EntityNotFoundException;
import org.cherif.mediatheque.models.ClientEntity;
import org.cherif.mediatheque.service.facade.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
// le but de cette implimentation et creration de ClientServiceImp :
// ajouter le traitemnt aux methodes et les exception...
// application fermée à la modification mais ouverte à l'extention

@Service
public class ClientServiceImp implements ClientService {

// inection du clientDao et du modell Mapper par constructeur
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    public ClientServiceImp(ClientDao clientDao,ModelMapper modelMapper){
        this.clientDao=clientDao;
        this.modelMapper = modelMapper;
    }
    @Override
    // enregistrement d'un nouveau client
    // à partir d'un clientRequestDto on construit un ClientResponseDto
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        // pour avoir un clientEntity: on transform clientRequestDto avec map vers clienEntity)
        ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
        //ClientEntity communique seulemnt avec clientDao
        ClientEntity saved =  clientDao.save(clientEntity);
        //à partir d'un saved on transform saved avec map vers ClientResponseDto
        return modelMapper.map(saved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(Integer id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()->new EntityNotFoundException("Client not fond"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByNom(String nom) {
        ClientEntity clientEntity = clientDao.findByNom(nom);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void delete(Integer id) {
        clientDao.deleteById(id);

    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientRequestDto, Integer id) throws NotFoundException {
        Optional<ClientEntity> clientEntityOptional = clientDao.findById(id);
        if(clientEntityOptional.isPresent()){
            ClientEntity clientEntity = modelMapper.map(clientRequestDto,ClientEntity.class);
            clientEntity.setId(id);
            ClientEntity updated =clientDao.save(clientEntity);
            return  modelMapper.map(updated,ClientResponseDto.class);

        }else {
            throw new EntityNotFoundException("Client not fond");

        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
       return clientDao.findAll()
               .stream().map(el->modelMapper.map(el,ClientResponseDto.class))
               .collect(Collectors.toList());
    }
}
