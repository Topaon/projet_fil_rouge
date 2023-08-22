package com.inetum.pfr.projetFilRouge.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.pfr.projetFilRouge.dao.DaoDomaine;
import com.inetum.pfr.projetFilRouge.dao.DaoEmprunt;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.entity.Domaine;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

@Component
@Profile("init")
public class DataInit {

	@Autowired
	DaoLivre daoLivre;
	
	@Autowired
	DaoDomaine daoDomaine;
	
	@Autowired
	DaoEmprunt daoEmprunt;

	@Autowired
	DaoPersonne daoPersonne;
	
	@PostConstruct
	public void initializeDb() {
		Livre livre1 = daoLivre.save(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		daoLivre.save(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.BON_ETAT));
		daoLivre.save(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.BON_ETAT));
		daoLivre.save(new Livre (null, "titre4", "auteur4", "editeur4", true, EtatLivre.BON_ETAT));
		daoLivre.save(new Livre (null, "titre5", "auteur5", "editeur5", true, EtatLivre.BON_ETAT));
		
		daoDomaine.save(new Domaine(null, "Aventure", "Ce livre parle d'aventure"));
		daoDomaine.save(new Domaine(null, "Amour", "Ce livre parle d'amour"));
		daoDomaine.save(new Domaine(null, "Policier", "Ce livre parle d'enquètes"));
		
		Personne personne1 = daoPersonne.save(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne personne2 = daoPersonne.save(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne personne3 = daoPersonne.save(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
//		Emprunt emprunt1 = daoEmprunt.insert(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1));
		daoEmprunt.save(new Emprunt(null, TypeEmprunt.RESERVATION,livre1, personne2));
		daoEmprunt.save(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, personne3));
		
		personne1.getEmprunts().add(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, personne1));
		

	}
}