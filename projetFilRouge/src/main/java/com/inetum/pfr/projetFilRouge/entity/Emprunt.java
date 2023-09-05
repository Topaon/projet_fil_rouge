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
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@NamedQuery(name = "Emprunt.getLateReturn", query = "SELECT e FROM Emprunt e"
													+ " WHERE e.dateFin<CURRENT_TIMESTAMP AND e.enCours=true AND e.type='EFFECTIF'")
public class Emprunt {
	
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
	
	private boolean enCours;
	

	public Emprunt(Long id, TypeEmprunt type, Livre livre, Personne personne) {
		super();
		this.id = id;
		this.type = type;
		this.livre = livre;
		this.personne = personne;
		this.enCours = true;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id +  ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", type=" + type + "]";
	}
}
