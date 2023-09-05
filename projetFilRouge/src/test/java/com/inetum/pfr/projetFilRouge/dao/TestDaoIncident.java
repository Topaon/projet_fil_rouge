package com.inetum.pfr.projetFilRouge.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Incident;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Incident.TypeIncident;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestDaoIncident {
	
	@Autowired
	DaoIncident daoIncident;
	@Autowired
	DaoEmprunt daoEmprunt;
	@Autowired
	DaoLivre daoLivre;
	@Autowired
	DaoPersonne daoPersonne;
	
	@Test
	public void testIncidentWithoutEmprunt() {
//		Incident inc1 = daoIncident.save(new Incident(null, TypeIncident.LIVRE_ABIME, EtatLivre.BON_ETAT, EtatLivre.ABIME, "Pages mouillées, couverture abimée"));
//		Incident inc2 = daoIncident.save(new Incident(null, TypeIncident.LIVRE_ABIME, EtatLivre.ABIME, EtatLivre.HORS_SERVICE, "Mangé par son chien"));
//		Incident inc3 = daoIncident.save(new Incident(null, TypeIncident.LIVRE_PERDU, EtatLivre.BON_ETAT, EtatLivre.HORS_SERVICE, "Déchiré"));
//		
//		assertEquals(daoIncident.findById(inc1.getId()).orElse(null).getDescription(), "Pages mouillées, couverture abimée");
//		
//		assertTrue(daoIncident.findAll().size() == 5);
//		
//		inc2.setNouvelEtat(EtatLivre.HORS_SERVICE);
//		daoIncident.save(inc2);
//		assertEquals(daoIncident.findById(inc2.getId()).orElse(null).getNouvelEtat(), EtatLivre.HORS_SERVICE);	
//		
//		daoIncident.deleteById(inc3.getId());
//		assertTrue(daoIncident.findAll().size() == 4);
	}
	
	@Test
	public void testIncidentWithEmprunt() {
//		Personne pers1 = daoPersonne.save(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
//		Personne pers2 = daoPersonne.save(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
//		Personne pers3 = daoPersonne.save(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
//		
//		Livre livre1 = daoLivre.save(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
//		Livre livre2 = daoLivre.save(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
//		Livre livre3 = daoLivre.save(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
//		
//		Emprunt emprunt1 = daoEmprunt.save(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, pers1));
//		Emprunt emprunt2 = daoEmprunt.save(new Emprunt(null, TypeEmprunt.RESERVATION, livre2, pers1));
//		Emprunt emprunt3 = daoEmprunt.save(new Emprunt(null, TypeEmprunt.EFFECTIF, livre3, pers1));
//		
//		Incident inc1 = daoIncident.save(new Incident(null, TypeIncident.LIVRE_ABIME, emprunt1, EtatLivre.BON_ETAT, EtatLivre.ABIME, "Pages mouillées, couverture abimée"));
//		Incident inc2 = daoIncident.save(new Incident(null, TypeIncident.LIVRE_ABIME, emprunt2, EtatLivre.ABIME, EtatLivre.HORS_SERVICE, "Mangé par son chien"));
//		Incident inc3 = daoIncident.save(new Incident(null, TypeIncident.LIVRE_PERDU, emprunt3, EtatLivre.BON_ETAT, EtatLivre.HORS_SERVICE, "Déchiré"));
//	
//		assertEquals(daoIncident.findById(inc1.getId()).orElse(null).getDescription(), "Pages mouillées, couverture abimée");
//		
//		assertTrue(daoIncident.findAll().size() == 3);
//		
//		inc2.setNouvelEtat(EtatLivre.HORS_SERVICE);
//		daoIncident.save(inc2);
//		assertEquals(daoIncident.findById(inc2.getId()).orElse(null).getNouvelEtat(), EtatLivre.HORS_SERVICE);	
//		
//		daoIncident.deleteById(inc3.getId());
//		assertTrue(daoIncident.findAll().size() == 2);
	
	}
}