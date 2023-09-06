package com.inetum.pfr.projetFilRouge.converter;

import java.util.List;

import com.inetum.pfr.projetFilRouge.dto.EmpruntDto;
import com.inetum.pfr.projetFilRouge.dto.LivreDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;

public class DtoConverter {
	
	
	public  EmpruntDto empruntToEmpruntDto(Emprunt entity) {

		EmpruntDto empruntDto = new EmpruntDto();
		
		empruntDto.setId(entity.getId());
		empruntDto.setPersonneLastName(entity.getPersonne().getNom().toUpperCase());
		empruntDto.setPersonneFirstName(entity.getPersonne().getPrenom());
		empruntDto.setLivreId(entity.getLivre().getId());
		empruntDto.setTitre(entity.getLivre().getTitre());
		empruntDto.setDateDebut(entity.getDateDebut());
		empruntDto.setDateFin(entity.getDateFin());
		empruntDto.setEnCours(entity.isEnCours());
		empruntDto.setType(entity.getType());
		
		return empruntDto;
		
	}
	
	public List<EmpruntDto> empruntToEmpruntDto(List<Emprunt> entityList) {
		return entityList.stream()
		       .map((entity)->empruntToEmpruntDto(entity))
		       .toList();
	}
	
	public  LivreDto livreToLivreDto(Livre entity) {

		LivreDto livreDto = new LivreDto();
		
		livreDto.setId(entity.getId());
		livreDto.setTitre(entity.getTitre());
		livreDto.setAuteur(entity.getAuteur());
		livreDto.setEditeur(entity.getEditeur());
		livreDto.setDispo(entity.getDispo());
		livreDto.setEtat(entity.getEtat());
		livreDto.setDomaine(entity.getDomaine().getNom());
		
		return livreDto;
		
	}
	
	
	public List<LivreDto> livreToLivreDto(List<Livre> entityList) {
		return entityList.stream()
		       .map((entity)->livreToLivreDto(entity))
		       .toList();
	}

}
