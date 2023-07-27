package com.inetum.pfr.projetFilRouge.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestDaoLivre {
	
	@Autowired
	DaoLivre daoLivre;
	
	@Test
	public void testQueries() {
		daoLivre.insert(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre2", "auteur2", "editeuré", true, EtatLivre.ABIME));
		
		assertTrue(daoLivre.findAll().size()== 2);
	}
	
	
	

}
