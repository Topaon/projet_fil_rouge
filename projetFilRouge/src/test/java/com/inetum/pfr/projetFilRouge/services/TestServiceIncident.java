package com.inetum.pfr.projetFilRouge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Incident;
import com.inetum.pfr.projetFilRouge.entity.Incident.TypeIncident;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;
import com.inetum.pfr.projetFilRouge.entity.Personne;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceIncident {
Logger logger = LoggerFactory.getLogger(TestServiceIncident.class);
	
	@Autowired
	ServiceIncident serviceIncident;
	@Autowired
	ServiceEmprunt serviceEmprunt;
	@Autowired
	ServiceLivre serviceLivre;
	@Autowired
	ServicePersonne servicePersonne;
	
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
		
//		Incident inc1 = serviceIncident.saveOrUpdate(new Incident(null, TypeIncident.LIVRE_ABIME, emprunt1, EtatLivre.BON_ETAT, EtatLivre.ABIME, "Pages mouillées, couverture abimée"));
//		Incident inc2 = serviceIncident.saveOrUpdate(new Incident(null, TypeIncident.LIVRE_ABIME, emprunt2, EtatLivre.ABIME, EtatLivre.HORS_SERVICE, "Mangé par son chien"));
//		Incident inc3 = serviceIncident.saveOrUpdate(new Incident(null, TypeIncident.LIVRE_PERDU, emprunt3, EtatLivre.BON_ETAT, EtatLivre.HORS_SERVICE, "Déchiré"));
//	
//		assertEquals(serviceIncident.searchById(inc1.getId()).getDescription(), "Pages mouillées, couverture abimée");
//		
//		assertTrue(serviceIncident.searchAll().size() == 3);
//		
//		inc2.setNouvelEtat(EtatLivre.HORS_SERVICE);
//		serviceIncident.saveOrUpdate(inc2);
//		assertEquals(serviceIncident.searchById(inc2.getId()).getNouvelEtat(), EtatLivre.HORS_SERVICE);	
//		
//		serviceIncident.removeById(inc3.getId());
//		assertTrue(serviceIncident.searchAll().size() == 2);
		
		Incident incService =  serviceIncident.declarerIncident(emprunt1.getId(), "LIVRE_ABIME", "HORS_SERVICE", "le livre a été déchiré par Simon");
		System.out.println("test end");
		

	}
}
