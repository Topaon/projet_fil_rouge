package com.inetum.pfr.projetFilRouge.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.converter.GenericConverter;
import com.inetum.pfr.projetFilRouge.dao.TestDaoEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestLivreDto {
	
	Logger logger = LoggerFactory.getLogger(TestLivreDto.class);
	
	@Test
	public void testLivreDto() {
		Livre livre1 = new Livre(1L, "Titre du livre", "Auteur", "Editeur", true, EtatLivre.BON_ETAT);
		
		LivreDto livre1Dto = GenericConverter.map(livre1, LivreDto.class);
		assertEquals(livre1.getId(), livre1Dto.getId());
		assertEquals(livre1.getTitre(), livre1Dto.getTitre());
		assertEquals(livre1.getAuteur(), livre1Dto.getAuteur());
		assertEquals(livre1.getEditeur(), livre1Dto.getEditeur());
		assertEquals(livre1.getDispo(), livre1Dto.getDispo());
	}
}