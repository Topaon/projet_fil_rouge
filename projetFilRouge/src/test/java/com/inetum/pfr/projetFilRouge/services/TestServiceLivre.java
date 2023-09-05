package com.inetum.pfr.projetFilRouge.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.dao.TestDaoLivre;
import com.inetum.pfr.projetFilRouge.entity.Domaine;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceLivre {
Logger logger = LoggerFactory.getLogger(TestDaoLivre.class);
	
	@Autowired
	ServiceLivre serviceLivre;
	@Autowired
	ServiceDomaine serviceDomaine;
	
	@Test
	public void testQueries() {
		
		Livre livre1 = serviceLivre.saveOrUpdate(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre2 = serviceLivre.saveOrUpdate(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
		Livre livre3 = serviceLivre.saveOrUpdate(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
		
		assertTrue(serviceLivre.searchAll().size()== 3);
		
		
		Domaine sciences = serviceDomaine.saveOrUpdate(new Domaine(null, "Sciences", "Domaine des sciences"));
		Domaine sociologie = serviceDomaine.saveOrUpdate(new Domaine(null, "Sociologie", "Domaine de la sociologie"));
		Domaine histoire = serviceDomaine.saveOrUpdate(new Domaine(null, "Histoire", "Domaine de l'histoire"));
		Domaine informatique = serviceDomaine.saveOrUpdate(new Domaine(null, "Informatique", "Domaine de l'informatique"));
		
		assertTrue(serviceDomaine.searchAll().size()== 7);

		livre1.getDomaines().add(sciences);
		livre1.getDomaines().add(histoire);
		livre2.getDomaines().add(histoire);
		livre3.getDomaines().add(informatique);
		
		serviceLivre.saveOrUpdate(livre1); 
		serviceLivre.saveOrUpdate(livre2);
		serviceLivre.saveOrUpdate(livre3);
		
//		logger.trace("test update:" + ServiceLivre.searchWithDomainById(livre1.getId()).getDomaines().size());
//		logger.trace("test update:" + ServiceLivre.searchWithDomainById(livre1.getId()).getDomaines().get(0).toString());
//		assertTrue(ServiceLivre.searchWithDomainById(livre1.getId()).getDomaines().size() == 2);
		

	}
}
