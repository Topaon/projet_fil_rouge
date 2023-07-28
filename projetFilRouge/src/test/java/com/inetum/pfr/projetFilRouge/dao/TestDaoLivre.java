package com.inetum.pfr.projetFilRouge.dao;

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
public class TestDaoLivre {
	
	Logger logger = LoggerFactory.getLogger(TestDaoLivre.class);
	
	@Autowired
	DaoLivre daoLivre;
	@Autowired
	DaoDomaine daoDomaine;
	
	@Test
	public void testQueries() {
		
		Livre livre1 = daoLivre.insert(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre2 = daoLivre.insert(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
		Livre livre3 = daoLivre.insert(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
		
		assertTrue(daoLivre.findAll().size()== 3);
		
		
		Domaine sciences = daoDomaine.insert(new Domaine(null, "Sciences", "Domaine des sciences"));
		Domaine sociologie = daoDomaine.insert(new Domaine(null, "Sociologie", "Domaine de la sociologie"));
		Domaine histoire = daoDomaine.insert(new Domaine(null, "Histoire", "Domaine de l'histoire"));
		Domaine informatique = daoDomaine.insert(new Domaine(null, "Informatique", "Domaine de l'informatique"));
		
		assertTrue(daoDomaine.findAll().size()== 4);

		livre1.getDomaines().add(sciences);
		livre1.getDomaines().add(histoire);
		livre2.getDomaines().add(histoire);
		livre3.getDomaines().add(informatique);
		
		daoLivre.update(livre1); 
		daoLivre.update(livre2);
		daoLivre.update(livre3);
		
		logger.trace("test update:" + daoLivre.findById(livre1.getId()).getDomaines().size());
//		assertTrue(daoLivre.findById(livre1.getId()).getDomaines().size() == 2);
	}
}
