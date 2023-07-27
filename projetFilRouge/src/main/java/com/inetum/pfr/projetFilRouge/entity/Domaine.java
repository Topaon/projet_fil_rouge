package com.inetum.pfr.projetFilRouge.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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

	@ManyToMany(fetch=FetchType.LAZY, mappedBy="domaines") 
	private List<Livre> livres;
	
	
	public Domaine(Long id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "Domaine [id=" + id + ", nom=" + nom + ", description=" + description + "]";
	}

}
