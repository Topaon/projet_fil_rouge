package com.inetum.pfr.projetFilRouge.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;

@Component
public class DataInit {

	@Autowired
	DaoLivre daoLivre;
	
//	@PostConstruct
	public void initializeDb() {
		daoLivre.insert(new Livre (null, "titre1", "auteur1", "editeur1", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre2", "auteur2", "editeur2", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre3", "auteur3", "editeur3", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre4", "auteur4", "editeur4", true, EtatLivre.BON_ETAT));
		daoLivre.insert(new Livre (null, "titre5", "auteur5", "editeur5", true, EtatLivre.BON_ETAT));
	}
}