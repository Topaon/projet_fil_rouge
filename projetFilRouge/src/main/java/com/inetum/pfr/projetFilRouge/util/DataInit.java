package com.inetum.pfr.projetFilRouge.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.inetum.pfr.projetFilRouge.dao.DaoDomaine;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.entity.Domaine;
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
	DaoPersonne daoPersonne;
	
	@PostConstruct
	public void initializeDb() {
		daoLivre.insert(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre4", "auteur4", "editeur4", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre5", "auteur5", "editeur5", true, EtatLivre.BON_ETAT));
		
		daoDomaine.insert(new Domaine(null, "Aventure", "Ce livre parle d'aventure"));
		daoDomaine.insert(new Domaine(null, "Amour", "Ce livre parle d'amour"));
		daoDomaine.insert(new Domaine(null, "Policier", "Ce livre parle d'enquètes"));
		
		daoPersonne.insert(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		daoPersonne.insert(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		daoPersonne.insert(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
	}
}