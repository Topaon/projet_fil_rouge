package com.inetum.pfr.projetFilRouge.dto;

import java.util.Date;

import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor@ToString
public class EmpruntDtoIds {
	
	private Long id;
	private Long personneId;
	private Long livreId;

	public EmpruntDtoIds(Long id, Long personneId, Long livreId) {
		this.id = id;
		this.personneId = personneId;
		this.livreId = livreId;
		
	}
}