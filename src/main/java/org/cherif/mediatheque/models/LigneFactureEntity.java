package org.cherif.mediatheque.models;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
									//Table d'association

@Entity
@Table(name = "ligne_facture")
@Data
@Getter
@Setter
@ToString
public class LigneFactureEntity implements Serializable { // cette class est en relation avec produit et facture

	/**
	 * 
	 */
	private static final long serialVersionUID = 2976533318551665458L;
	
	
	@EmbeddedId  // cle primaire
	private LigneFactureKey id;
	
	@ManyToOne
	@MapsId("factureId")  // pour dire que le champs est une partie de la cle primaire et c'est un e cle etrangere d'une relation manytoMany
	@JoinColumn(name ="facture_id")
	private FactureEntity facture;
	
	@ManyToOne()
	@MapsId("produitId")
	@JoinColumn(name ="produit_id")
	private ProduitEntity produit;
	
	
	
	private double quantite ;

}
