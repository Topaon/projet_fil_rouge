package com.inetum.pfr.projetFilRouge.dto;

import java.util.Date;

import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Personne;

import lombok.AllArgsConstructor;
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
	private Date dateDebut;
	private Date dateFin;
	
	
	public EmpruntDto(Long id, String personneFirstName, String personneLastName, Long livreId, Date dateDebut,
			Date dateFin) {
		super();
		this.id = id;
		this.personneFirstName = personneFirstName;
		this.personneLastName = personneLastName;
		this.livreId = livreId;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}	
}
