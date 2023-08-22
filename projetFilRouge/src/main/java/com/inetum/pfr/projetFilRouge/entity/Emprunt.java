package com.inetum.pfr.projetFilRouge.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.inetum.pfr.projetFilRouge.util.AppUtil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Emprunt {
	
//	@EmbeddedId
//	private EmpruntPersonneId pk ;
	
	public enum TypeEmprunt {
		RESERVATION, EFFECTIF
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "personneId")
	private Personne personne;
	
	@ManyToOne
	@JoinColumn(name = "livreId")
	private Livre livre;

	
	@Temporal(TemporalType.DATE)
	private Date dateDebut = new Date();
	@Temporal(TemporalType.DATE)
	private Date dateFin = AppUtil.ajouterJours(dateDebut, 21);
	
	@Enumerated(EnumType.STRING)
	private TypeEmprunt type;

	public Emprunt(Long id, TypeEmprunt type, Livre livre, Personne personne) {
		super();
		this.id = id;
		this.type = type;
		this.livre = livre;
		this.personne = personne;
	}
	
	public Emprunt(Long id, TypeEmprunt type) {
		super();
		this.id = id;
		this.type = type;
	}
	

	@Override
	public String toString() {
		return "Emprunt [id=" + id +  ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", type=" + type + "]";
	}
	
	

}