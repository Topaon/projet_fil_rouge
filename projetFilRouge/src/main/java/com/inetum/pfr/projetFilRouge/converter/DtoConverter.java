package com.inetum.pfr.projetFilRouge.converter;

import com.inetum.pfr.projetFilRouge.dto.EmpruntDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;

public class DtoConverter {
	
	
	public  EmpruntDto empruntToEmpruntDto(Emprunt entity) {

		EmpruntDto empruntDto = new EmpruntDto();
		
		empruntDto.setId(entity.getId());
		empruntDto.setPersonneLastName(entity.getPersonne().getNom().toUpperCase());
		empruntDto.setPersonneFirstName(entity.getPersonne().getPrenom());
		empruntDto.setLivreId(entity.getLivre().getId());
		empruntDto.setDateDebut(entity.getDateDebut());
		empruntDto.setDateFin(entity.getDateFin());
		
		return empruntDto;
		
	}

}