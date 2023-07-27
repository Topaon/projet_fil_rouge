package com.inetum.pfr.projetFilRouge.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nom;
	private String description;

	// POUR GERER LA RELATION AVEC LES livres PLUS TARD

//	@ManyToMany(fetch=FetchType.LAZY, mappedBy="domaines") 
//	private List<Livre> livres;

	@Override
	public String toString() {
		return "Domaine [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}

}
