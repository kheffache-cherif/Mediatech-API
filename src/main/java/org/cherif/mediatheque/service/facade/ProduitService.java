package org.cherif.mediatheque.service.facade;

import org.cherif.mediatheque.dao.ProduitDao;
import org.cherif.mediatheque.dto.ProduitDto;



public interface ProduitService {

    // dan le sservice don le Dto pas le Dao



    ProduitDto save(ProduitDto produitDto);

    int delete(String ref);

    ProduitDto update(ProduitDto produitDto);


    ProduitDto findByRef(String ref);



}
