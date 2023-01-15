package org.cherif.mediatheque.models;

import java.io.Serializable;

					//cle composite

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable  //integrable dans une autre classe "LigneFactureEntity"
public class LigneFactureKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6493789771454073227L;
	
	// cle composite 
	
	@Column(name = "facture_id")	
	private Integer factureId;
	
	@Column(name = "product_id")	
	private Integer productId;

}
