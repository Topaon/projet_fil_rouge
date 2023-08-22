package com.inetum.pfr.projetFilRouge.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Domaine;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestDaoDomaine {
	
	Logger logger = LoggerFactory.getLogger(TestDaoDomaine.class);
	
	@Autowired
	DaoLivre daoLivre;
	@Autowired
	DaoDomaine daoDomaine;
	
	@Test
	public void testQueries() {
		
		Domaine domaine1 = daoDomaine.save(new Domaine(null, "Domaine test", "Domaine créé pour le test junit"));
		Domaine domaine2 = daoDomaine.save(new Domaine(null, "Domaine siences", "Domaine créé pour le test sciences"));
		Domaine domaine3 = daoDomaine.save(new Domaine(null, "Domaine histoire", "Domaine créé pour le test histoire"));
		
		assertEquals(daoDomaine.findById(domaine1.getId()).orElse(null).getDescription(), "Domaine créé pour le test junit");
		
		assertTrue(daoDomaine.findAll().size() == 7);
		
		domaine1.setDescription("Nouvelle description après mise à jour");
		daoDomaine.save(domaine1);
		assertEquals(daoDomaine.findById(domaine1.getId()).orElse(null).getDescription(), "Nouvelle description après mise à jour");
	}
}
