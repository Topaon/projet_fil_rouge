package com.inetum.pfr.projetFilRouge.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Domaine;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestDomaineDto {
	
	Logger logger = LoggerFactory.getLogger(TestDomaineDto.class);
	
	@Test
	public void testLivreDto() {
		Domaine domaine1 = new Domaine(1L, "Nom du domaine", "Description du domaine");
		
		DomaineDto domaine1Dto = GenericConverter.map(domaine1, DomaineDto.class);
		assertEquals(domaine1.getNom(), domaine1Dto.getNom());
		assertEquals(domaine1.getDescription(), domaine1Dto.getDescription());
	}
}