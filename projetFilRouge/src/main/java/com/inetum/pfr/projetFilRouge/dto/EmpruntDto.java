package com.inetum.pfr.projetFilRouge.dto;

import java.util.Date;

import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@ToString
public class EmpruntDto {
	private Long id;
	private String personneFirstName;
	private String personneLastName;
	private Long livreId;
	private String titre;
	private Date dateDebut;
	private Date dateFin;
	private boolean enCours;
	private TypeEmprunt type;
	
	
	public EmpruntDto(Long id, String personneFirstName, String personneLastName, Long livreId, String titre, Date dateDebut,
			Date dateFin, boolean enCours, TypeEmprunt type) {
		super();
		this.id = id;
		this.personneFirstName = personneFirstName;
		this.personneLastName = personneLastName;
		this.livreId = livreId;
		this.titre = titre;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.enCours = enCours;
		this.type = type;
	}	
}
