package com.inetum.pfr.projetFilRouge.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;
import com.inetum.pfr.projetFilRouge.entity.Personne;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestDaoEmprunt {
	
	Logger logger = LoggerFactory.getLogger(TestDaoEmprunt.class);
	
	@Autowired
	DaoEmprunt daoEmprunt;
	@Autowired
	DaoLivre daoLivre;
	@Autowired
	DaoPersonne daoPersonne;
	
	@Test
	public void testQueries() {

		Personne pers1 = daoPersonne.save(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne pers2 = daoPersonne.save(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne pers3 = daoPersonne.save(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
		Livre livre1 = daoLivre.save(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre2 = daoLivre.save(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
		Livre livre3 = daoLivre.save(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
		
		Emprunt emprunt1 = daoEmprunt.save(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, pers1));
		Emprunt emprunt2 = daoEmprunt.save(new Emprunt(null, TypeEmprunt.RESERVATION, livre2, pers1));
		Emprunt emprunt3 = daoEmprunt.save(new Emprunt(null, TypeEmprunt.EFFECTIF, livre3, pers1));
	
	assertTrue(daoEmprunt.findAll().size()== 3);
		
	assertTrue(daoPersonne.countLoansById(pers1.getId()).size() == 3);
	


	}

}
