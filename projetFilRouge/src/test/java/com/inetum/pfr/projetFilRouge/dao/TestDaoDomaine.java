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
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

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
		
		Domaine domaine1 = daoDomaine.insert(new Domaine(null, "Domaine test", "Domaine créé pour le test junit"));
		
		assertEquals(daoDomaine.findById(domaine1.getId()).getDescription(), "Domaine créé pour le test junit");
		
		assertTrue(daoDomaine.findAll().size() == 4);
		
		domaine1.setDescription("Nouvelle description après mise à jour");
		daoDomaine.update(domaine1);
		assertEquals(daoDomaine.findById(domaine1.getId()).getDescription(), "Nouvelle description après mise à jour");
	}
}
