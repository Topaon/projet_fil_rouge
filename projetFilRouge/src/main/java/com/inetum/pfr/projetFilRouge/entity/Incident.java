package com.inetum.pfr.projetFilRouge.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Incident {

	public enum TypeIncident {LIVRE_ABIME, LIVRE_PERDU};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private TypeIncident typeIncident;
	
	@OneToOne
	@JoinColumn(name = "livreId" , unique=true)
	private Livre livre;
	
	@OneToOne
	@JoinColumn(name = "personneId" , unique=true)
	private Personne personne;
	
	@Enumerated(EnumType.STRING)
	private EtatLivre ancienEtat;
	@Enumerated(EnumType.STRING)
	private EtatLivre nouvelEtat;
	
	@Temporal(TemporalType.DATE)
	private Date dateCreationIncident = new Date();
	private String description;
	
	public Incident(Long id, TypeIncident typeIncident, Livre livre, Personne personne, EtatLivre ancienEtat , String description) {
		super();
		this.id = id;
		this.typeIncident = typeIncident;
		this.ancienEtat = ancienEtat;
		this.livre = livre;
		this.personne = personne;
		this.description = description;
	}
	
	
	public Incident(Long id, TypeIncident typeIncident, Livre livre, Personne personne, Emprunt emprunt, EtatLivre ancienEtat , EtatLivre nouvelEtat, String description) {
		super();
		this.id = id;
		this.typeIncident = typeIncident;
		this.ancienEtat = ancienEtat;
		this.nouvelEtat = nouvelEtat;
		this.livre = livre;
		this.personne = personne;
		this.description = description;
	}
	
	public Incident(Long id, TypeIncident typeIncident, Livre livre, Personne personne, EtatLivre ancienEtat , EtatLivre nouvelEtat, String description) {
		super();
		this.id = id;
		this.typeIncident = typeIncident;
		this.ancienEtat = ancienEtat;
		this.nouvelEtat = nouvelEtat;
		this.livre = livre;
		this.personne = personne;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Incident [id=" + id + ", typeIncident=" + typeIncident + " dateCreationIncident=" + dateCreationIncident + ", description=" + description + "]";
	}
}
