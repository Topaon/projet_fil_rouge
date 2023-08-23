package com.inetum.pfr.projetFilRouge.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Emprunt emprunt;
	@Enumerated(EnumType.STRING)
	private EtatLivre ancienEtat;
	@Enumerated(EnumType.STRING)
	private EtatLivre nouvelEtat;
	@Temporal(TemporalType.DATE)
	private Date dateCreationIncident = new Date();
	private String description;
	
	public Incident(Long id, TypeIncident typeIncident, EtatLivre ancienEtat, EtatLivre nouvelEtat,
			String description) {
		super();
		this.id = id;
		this.typeIncident = typeIncident;
		this.ancienEtat = ancienEtat;
		this.nouvelEtat = nouvelEtat;
		this.description = description;
	}
	
	public Incident(Long id, TypeIncident typeIncident, Emprunt emprunt, EtatLivre ancienEtat, EtatLivre nouvelEtat,
			String description) {
		super();
		this.id = id;
		this.typeIncident = typeIncident;
		this.emprunt = emprunt;
		this.ancienEtat = ancienEtat;
		this.nouvelEtat = nouvelEtat;
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "Incident [id=" + id + ", typeIncident=" + typeIncident + ", ancienEtat=" + ancienEtat + ", nouvelEtat="
				+ nouvelEtat + ", dateCreationIncident=" + dateCreationIncident + ", description=" + description + "]";
	}
}
