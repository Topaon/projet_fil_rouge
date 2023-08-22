package com.inetum.pfr.projetFilRouge.services;

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
public class TestServiceEmprunt {
	
	Logger logger = LoggerFactory.getLogger(TestServiceEmprunt.class);
	
	@Autowired
	ServiceEmprunt serviceEmprunt;
	@Autowired
	ServicePersonne servicePersonne;
	@Autowired
	ServiceLivre serviceLivre;
	
	@Test
	public void testQueries() {
		
	Personne pers1 = servicePersonne.saveOrUpdate(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
	Personne pers2 = servicePersonne.saveOrUpdate(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
	Personne pers3 = servicePersonne.saveOrUpdate(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
	
	Livre livre1 = serviceLivre.saveOrUpdate(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
	Livre livre2 = serviceLivre.saveOrUpdate(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
	Livre livre3 = serviceLivre.saveOrUpdate(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
	
	Emprunt emprunt1 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, pers1));
	Emprunt emprunt2 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.RESERVATION, livre2, pers1));
	Emprunt emprunt3 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre3, pers1));
	
	assertTrue(serviceEmprunt.searchAll().size()== 3);
	
	serviceEmprunt.emprunter(pers1.getId(), livre3.getId());
	
	

	}

}