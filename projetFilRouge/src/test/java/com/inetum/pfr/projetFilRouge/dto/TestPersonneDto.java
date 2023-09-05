package com.inetum.pfr.projetFilRouge.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.converter.GenericConverter;
import com.inetum.pfr.projetFilRouge.entity.Personne;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestPersonneDto {
	
	Logger logger = LoggerFactory.getLogger(TestPersonneDto.class);
	
	@Test
	public void testpersonneDto() {
		Personne personne1 = new Personne(1L, "Nom", "Prenom", "Email", "Adresse");
		
		PersonneDto personne1Dto = GenericConverter.map(personne1, PersonneDto.class);
		assertEquals(personne1.getId(), personne1Dto.getId());
		assertEquals(personne1.getNom(), personne1Dto.getNom());
		assertEquals(personne1.getPrenom(), personne1Dto.getPrenom());
		assertEquals(personne1.getEmail(), personne1Dto.getEmail());
	}
}