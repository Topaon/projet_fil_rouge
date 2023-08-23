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
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;

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
	public void testEmpruntOk() {
		
		Personne pers1 = servicePersonne.saveOrUpdate(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne pers2 = servicePersonne.saveOrUpdate(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne pers3 = servicePersonne.saveOrUpdate(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
		Livre livre1 = serviceLivre.saveOrUpdate(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre2 = serviceLivre.saveOrUpdate(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
		Livre livre3 = serviceLivre.saveOrUpdate(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
		Livre livre4 = serviceLivre.saveOrUpdate(new Livre (null, "titre4", "auteur4", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre5 = serviceLivre.saveOrUpdate(new Livre (null, "titre5", "auteur5", "editeur4", true, EtatLivre.BON_ETAT));
		Livre livre6 = serviceLivre.saveOrUpdate(new Livre (null, "titre6", "auteur6", "editeur5", true, EtatLivre.BON_ETAT));
		Livre livre7 = serviceLivre.saveOrUpdate(new Livre (null, "titre7", "auteur7", "editeur6", true, EtatLivre.BON_ETAT));
		Livre livre8 = serviceLivre.saveOrUpdate(new Livre (null, "titre8", "auteur8", "editeur3", true, EtatLivre.BON_ETAT));
		Livre livre9 = serviceLivre.saveOrUpdate(new Livre (null, "titre9", "auteur9", "editeur4", true, EtatLivre.BON_ETAT));
		Livre livre10 = serviceLivre.saveOrUpdate(new Livre (null, "titre10", "auteur10", "editeur5", true, EtatLivre.BON_ETAT));
		
		Emprunt emprunt1 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, pers1));
		Emprunt emprunt2 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.RESERVATION, livre2, pers1));
		Emprunt emprunt3 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre3, pers1));
		Emprunt emprunt4 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre4, pers1));
		Emprunt emprunt5 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre5, pers1));
		Emprunt emprunt6 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre6, pers1));
		Emprunt emprunt7 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre9, pers2));

	assertTrue(serviceEmprunt.searchAll().size()== 7);
	
	try {
		serviceEmprunt.emprunter(pers1.getId(), livre8.getId());
	} catch (EmpruntException e) {
		logger.trace("Emprunt impossible: " + e.getMessage());
	}
	
	assertTrue(serviceEmprunt.searchAll().size()== 8);
	
	
	Emprunt empruntARetourner = serviceEmprunt.searchByPersonneIdAndLivreIdAndEnCoursTrue(pers1.getId(), livre8.getId());
	assertTrue(serviceEmprunt.searchByPersonneIdAndLivreIdAndEnCoursTrue(pers1.getId(), livre8.getId()).isEnCours() == true);
	logger.trace("Emprunt à retourner: " + empruntARetourner.isEnCours());
	
	serviceEmprunt.retourner(empruntARetourner.getId());
	
	assertTrue(serviceEmprunt.searchAll().size()== 8);
	assertTrue(serviceEmprunt.searchByPersonneIdAndLivreId(pers1.getId(), livre8.getId()).isEnCours() == false);
	logger.trace("Emprunt retourné: " + serviceEmprunt.searchByPersonneIdAndLivreId(pers1.getId(), livre8.getId()).isEnCours());
	

	}
	
	@Test
	public void testEmpruntNOk() {
		
		Personne pers1 = servicePersonne.saveOrUpdate(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne pers2 = servicePersonne.saveOrUpdate(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne pers3 = servicePersonne.saveOrUpdate(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
		Livre livre1 = serviceLivre.saveOrUpdate(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre2 = serviceLivre.saveOrUpdate(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
		Livre livre3 = serviceLivre.saveOrUpdate(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
		Livre livre4 = serviceLivre.saveOrUpdate(new Livre (null, "titre4", "auteur4", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre5 = serviceLivre.saveOrUpdate(new Livre (null, "titre5", "auteur5", "editeur4", true, EtatLivre.BON_ETAT));
		Livre livre6 = serviceLivre.saveOrUpdate(new Livre (null, "titre6", "auteur6", "editeur5", true, EtatLivre.BON_ETAT));
		Livre livre7 = serviceLivre.saveOrUpdate(new Livre (null, "titre7", "auteur7", "editeur6", true, EtatLivre.BON_ETAT));
		Livre livre8 = serviceLivre.saveOrUpdate(new Livre (null, "titre8", "auteur8", "editeur3", true, EtatLivre.BON_ETAT));
		Livre livre9 = serviceLivre.saveOrUpdate(new Livre (null, "titre9", "auteur9", "editeur4", true, EtatLivre.BON_ETAT));
		Livre livre10 = serviceLivre.saveOrUpdate(new Livre (null, "titre10", "auteur10", "editeur5", true, EtatLivre.BON_ETAT));
		
		Emprunt emprunt1 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, pers1));
		Emprunt emprunt2 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.RESERVATION, livre2, pers1));
		Emprunt emprunt3 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre3, pers1));
		Emprunt emprunt4 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre4, pers1));
		Emprunt emprunt5 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre5, pers1));
		Emprunt emprunt6 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre6, pers1));
		Emprunt emprunt7 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre7, pers1));
		Emprunt emprunt8 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF, livre9, pers2));
		
		
		try {
			serviceEmprunt.emprunter(pers1.getId(), livre10.getId());
		} catch (EmpruntException e) {
			logger.trace("Emprunt impossible: " + e.getMessage());
		}
		
		assertTrue(serviceEmprunt.searchAll().size()== 8);
		
	}
	
	
	
	
	
	
	

}