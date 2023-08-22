package com.inetum.pfr.projetFilRouge.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@NamedQuery(name = "Personne.countLoansById", query = "SELECT e FROM Emprunt e LEFT JOIN FETCH e.personne p WHERE e.enCours = true AND p.id  = ?1")
public class Personne {
	
	@Transient
	public static Integer maxEmprunts = 7;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="personne")
	private List<Emprunt> emprunts = new ArrayList<>();
	
	// Constructeur
	public Personne(Long id, String nom, String prenom, String email, String adresse) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	// ToString
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse="
				+ adresse + "]";
	}
}