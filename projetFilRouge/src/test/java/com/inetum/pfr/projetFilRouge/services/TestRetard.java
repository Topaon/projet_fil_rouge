package com.inetum.pfr.projetFilRouge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.util.AppUtil;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestRetard {

	@Autowired
	ServiceEmprunt serviceEmprunt;
	@Autowired
	ServiceLivre serviceLivre;
	@Autowired
	ServicePersonne servicePersonne;
	
	@Test
	public void testRetard() {
		Personne pers1 = servicePersonne.saveOrUpdate(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne pers2 = servicePersonne.saveOrUpdate(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne pers3 = servicePersonne.saveOrUpdate(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
		Livre livre1 = serviceLivre.saveOrUpdate(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		Livre livre2 = serviceLivre.saveOrUpdate(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.ABIME));
		Livre livre3 = serviceLivre.saveOrUpdate(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.HORS_SERVICE));
		
		Emprunt emprunt1 = new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, pers1);
		Emprunt emprunt2 = new Emprunt(null, TypeEmprunt.EFFECTIF, livre2, pers1);
		Emprunt emprunt3 = new Emprunt(null, TypeEmprunt.EFFECTIF, livre3, pers1);
		
		emprunt1.setDateDebut(AppUtil.retirerJours(emprunt1.getDateDebut(), 10));
		emprunt1.setDateFin(AppUtil.ajouterJours(emprunt1.getDateDebut(), 5));
		
		emprunt2.setDateDebut(AppUtil.retirerJours(emprunt1.getDateDebut(), 8));
		emprunt2.setDateFin(AppUtil.ajouterJours(emprunt1.getDateDebut(), 3));
		
		emprunt2.setEnCours(false);
		
		serviceEmprunt.saveOrUpdate(emprunt1);
		serviceEmprunt.saveOrUpdate(emprunt2);
		serviceEmprunt.saveOrUpdate(emprunt3);
		
		assertEquals(serviceEmprunt.tousLesRetards().size(), 1);
	}
}
