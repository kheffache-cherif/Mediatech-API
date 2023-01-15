package org.cherif.mediatheque.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // pour dire que c'est possible qu'elle soit une entity
@Table(name="Client")
@Data // vient de lombock pour creer les getter et setters
@AllArgsConstructor  // un constructeur avec tout les arguments
@NoArgsConstructor  //// un constructeur sans arguments
public class ClientEntity implements Serializable {
		// Serializable pour dire que cette Entity est possible de la serealiser

	@Id()
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)  // le nom est obligatoir
	private String nom;
	@Column(nullable = false)  // le prenom est obligatoir
	private String prenom;
	@Column(name = "clientTel") 
	private String telephone;
	
	//FetchType.LAZY : chargement deferer findByid pour ramener dans cette relation que 

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
	private List<FactureEntity> factures;



}
