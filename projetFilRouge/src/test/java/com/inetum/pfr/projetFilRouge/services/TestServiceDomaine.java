package com.inetum.pfr.projetFilRouge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.dao.TestDaoDomaine;
import com.inetum.pfr.projetFilRouge.entity.Domaine;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceDomaine {
Logger logger = LoggerFactory.getLogger(TestDaoDomaine.class);
	
	@Autowired
	ServiceLivre ServiceLivre;
	@Autowired
	ServiceDomaine ServiceDomaine;
	
	@Test
	public void testQueries() {
		
		Domaine domaine1 = ServiceDomaine.saveOrUpdate(new Domaine(null, "Domaine test", "Domaine créé pour le test junit"));
		Domaine domaine2 = ServiceDomaine.saveOrUpdate(new Domaine(null, "Domaine siences", "Domaine créé pour le test sciences"));
		Domaine domaine3 = ServiceDomaine.saveOrUpdate(new Domaine(null, "Domaine histoire", "Domaine créé pour le test histoire"));
		
		assertEquals(ServiceDomaine.searchById(domaine1.getId()).getDescription(), "Domaine créé pour le test junit");
		
		assertTrue(ServiceDomaine.searchAll().size() == 3);
		
		domaine1.setDescription("Nouvelle description après mise à jour");
		ServiceDomaine.saveOrUpdate(domaine1);
		assertEquals(ServiceDomaine.searchById(domaine1.getId()).getDescription(), "Nouvelle description après mise à jour");
	}
}
