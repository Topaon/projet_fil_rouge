package com.inetum.pfr.projetFilRouge.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.converter.DtoConverter;
import com.inetum.pfr.projetFilRouge.dao.DaoEmprunt;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;
import com.inetum.pfr.projetFilRouge.entity.Personne;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestEmpruntDto {
	
	Logger logger = LoggerFactory.getLogger(TestEmpruntDto.class);
	DtoConverter dtoConverter = new DtoConverter();
	
	@Test
	public void testpersonneDto() {
		Livre livre1 = new Livre(1L, "Titre du livre", "Auteur", "Editeur", true, EtatLivre.BON_ETAT);
		Personne personne1 = new Personne(1L, "Nom", "Prenom", "Email", "Adresse");
		Emprunt emprunt1 = new Emprunt(1L, TypeEmprunt.EFFECTIF, livre1, personne1);
		
		EmpruntDto emprunt1Dto = dtoConverter.empruntToEmpruntDto(emprunt1);
		assertEquals(emprunt1.getPersonne().getNom().toUpperCase(), emprunt1Dto.getPersonneLastName());
		assertEquals(emprunt1.getPersonne().getPrenom(), emprunt1Dto.getPersonneFirstName());
		assertEquals(emprunt1.getLivre().getId(), emprunt1Dto.getLivreId());
		assertEquals(emprunt1.getDateDebut(), emprunt1Dto.getDateDebut());
		assertEquals(emprunt1.getDateFin(), emprunt1Dto.getDateFin());
		
		logger.trace("emprunt1:" + emprunt1);
		logger.trace("emprunt1Dto:" + emprunt1Dto);
	}
}