package org.cherif.mediatheque.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Produit")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ProduitEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8418704153533376078L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String libelle;
	
	@Column(nullable = false)
	private String ref;
	
	
	@Column(nullable = false)
	private BigDecimal prix;
	
	@Column(nullable = false)
	private double qantiteStock;
	
	@OneToMany( mappedBy = "produit",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<LigneFactureEntity> ligneFactures;
}


	