package com.inetum.pfr.projetFilRouge.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Livre {

	public enum EtatLivre {
		BON_ETAT, ABIME, HORS_SERVICE
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titre;
	private String auteur;
	private String editeur;
	private Boolean dispo;

	@Enumerated(EnumType.STRING)
	private EtatLivre etat;

	// POUR GERER LA RELATION AVEC LES DOMAINES PLUS TARD

	@ManyToOne(fetch=FetchType.LAZY)
	private Domaine domaine;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="livre")
	@JsonIgnore
	private List<Emprunt> emprunts;
	
	public Livre(Long id, String titre, String auteur, String editeur, Boolean dispo, EtatLivre etat) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.dispo = dispo;
		this.etat = etat;
	}
	
	public Livre(Long id, String titre, String auteur, String editeur, Boolean dispo, EtatLivre etat, Domaine domaine) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
		this.dispo = dispo;
		this.etat = etat;
		this.domaine = domaine;
	}
	

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + ", editeur=" + editeur + ", dispo="
				+ dispo + ", etat=" + etat + "]";
	
	}
}
