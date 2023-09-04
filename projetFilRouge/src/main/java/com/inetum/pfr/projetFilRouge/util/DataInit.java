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
		Livre livre1 = daoLivre.save(new Livre (null, "Le Mystère de la Chambre Jaune", "Gaston Leroux", "Le Livre de Poche", false, EtatLivre.BON_ETAT));
		Livre livre2 = daoLivre.save(new Livre (null, "1984", "George Orwell", "Gallimard", false, EtatLivre.BON_ETAT));
		Livre livre3 = daoLivre.save(new Livre (null, "L'Étranger", "Albert Camus", "Folio", true, EtatLivre.BON_ETAT));
		Livre livre4 = daoLivre.save(new Livre (null, "Le Petit Prince", "Antoine de Saint-Exupéry", "Gallimard", true, EtatLivre.BON_ETAT));
		Livre livre5 = daoLivre.save(new Livre (null, "Harry Potter à l'École des Sorciers", "J.K. Rowling", "Gallimard Jeunesse", true, EtatLivre.BON_ETAT));
		Livre livre6 = daoLivre.save(new Livre (null, "Le Seigneur des Anneaux : La Communauté de l'Anneau", "J.R.R. Tolkien", "Christian Bourgois Éditeur", true, EtatLivre.BON_ETAT));
		Livre livre7 = daoLivre.save(new Livre (null, "Orgueil et Préjugés", "Jane Austen", "Le Livre de Poche", true, EtatLivre.BON_ETAT));
		Livre livre8 = daoLivre.save(new Livre (null, "Le Comte de Monte-Cristo", "Alexandre Dumas", "Le Livre de Poche", true, EtatLivre.BON_ETAT));
		Livre livre9 = daoLivre.save(new Livre (null, "Le Parfum", "Patrick Süskind", "Folio", true, EtatLivre.BON_ETAT));
		Livre livre10 = daoLivre.save(new Livre (null, "Fondation", "Isaac Asimov", "Pocket", true, EtatLivre.BON_ETAT));
		Livre livre11 = daoLivre.save(new Livre (null, "Les Misérables", "Victor Hugo", "Le Livre de Poche", true, EtatLivre.BON_ETAT));
		Livre livre12 = daoLivre.save(new Livre (null, "La Guerre des Mondes", "H.G. Wells", "Folio SF", true, EtatLivre.BON_ETAT));
		Livre livre13 = daoLivre.save(new Livre (null, "Le Rouge et le Noir", "Stendhal", "Le Livre de Poche", true, EtatLivre.BON_ETAT));
		Livre livre14 = daoLivre.save(new Livre (null, "La Nuit des temps", "René Barjavel", "Pocket", true, EtatLivre.BON_ETAT));
		Livre livre15 = daoLivre.save(new Livre (null, "Le Hobbit", "J.R.R. Tolkien", "Pocket", true, EtatLivre.BON_ETAT));
		Livre livre16 = daoLivre.save(new Livre (null, "Les Fourmis", "Bernard Werber", "Le Livre de Poche", true, EtatLivre.BON_ETAT));
		Livre livre17 = daoLivre.save(new Livre (null, "Neuromancien", "William Gibson", "J'ai lu", true, EtatLivre.BON_ETAT));
		Livre livre18 = daoLivre.save(new Livre (null, "Le Silmarillion", "J.R.R. Tolkien", "Christian Bourgois Éditeur", true, EtatLivre.BON_ETAT));
		Livre livre19 = daoLivre.save(new Livre (null, "Les Cerfs-volants de Kaboul", "Khaled Hosseini", "10/18", true, EtatLivre.BON_ETAT));
		Livre livre20 = daoLivre.save(new Livre (null, "Le Meilleur des Mondes", "Aldous Huxley", "Pocket", true, EtatLivre.BON_ETAT));
		
		daoDomaine.save(new Domaine(null, "Aventure", "Ce livre parle d'aventure"));
		daoDomaine.save(new Domaine(null, "Amour", "Ce livre parle d'amour"));
		daoDomaine.save(new Domaine(null, "Policier", "Ce livre parle d'enquètes"));
		
		Personne personne1 = daoPersonne.save(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne personne2 = daoPersonne.save(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne personne3 = daoPersonne.save(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		Personne personne4 = daoPersonne.save(new Personne(null, "Martin", "Sophie", "sophie.martin@gmail.com", "Paris"));
		Personne personne5 = daoPersonne.save(new Personne(null, "Dubois", "Pierre", "pierre.dubois@yahoo.com", "Marseille"));
		Personne personne6 = daoPersonne.save(new Personne(null, "Lefebvre", "Marie", "marie.lefebvre@hotmail.com", "Lyon"));
		Personne personne7 = daoPersonne.save(new Personne(null, "Moreau", "Isabelle", "isabelle.moreau@gmail.com", "Toulouse"));
		Personne personne8 = daoPersonne.save(new Personne(null, "Dupont", "Jean", "jean.dupont@yahoo.com", "Bordeaux"));
		Personne personne9 = daoPersonne.save(new Personne(null, "Bernard", "Luc", "luc.bernard@gmail.com", "Nice"));
		Personne personne10 = daoPersonne.save(new Personne(null, "Petit", "Laura", "laura.petit@hotmail.com", "Strasbourg"));
		Personne personne11 = daoPersonne.save(new Personne(null, "Garcia", "Julien", "julien.garcia@gmail.com", "Nantes"));
		Personne personne12 = daoPersonne.save(new Personne(null, "Thomas", "Sylvie", "sylvie.thomas@yahoo.com", "Montpellier"));
		Personne personne13 = daoPersonne.save(new Personne(null, "Muller", "François", "francois.muller@hotmail.com", "Rennes"));
		Personne personne14 = daoPersonne.save(new Personne(null, "Perrot", "Catherine", "catherine.perrot@gmail.com", "Lille"));
		Personne personne15 = daoPersonne.save(new Personne(null, "Roux", "Philippe", "philippe.roux@yahoo.com", "Brest"));
		Personne personne16 = daoPersonne.save(new Personne(null, "Fournier", "Anne", "anne.fournier@gmail.com", "Grenoble"));
		Personne personne17 = daoPersonne.save(new Personne(null, "Lopez", "Antoine", "antoine.lopez@hotmail.com", "Aix-en-Provence"));
		Personne personne18 = daoPersonne.save(new Personne(null, "Girard", "Paul", "paul.girard@yahoo.com", "Toulon"));
		Personne personne19 = daoPersonne.save(new Personne(null, "Granier", "Laurent", "laurent.granier@sfr.fr", "Fontenay-sous-Bois"));
		Personne personne20 = daoPersonne.save(new Personne(null, "Granier", "Philipe", "philipe.granier@sfr.fr", "Sceaux"));
		

		
//		Emprunt emprunt1 = daoEmprunt.insert(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1));
		daoEmprunt.save(new Emprunt(null, TypeEmprunt.RESERVATION,livre1, personne2));
		daoEmprunt.save(new Emprunt(null, TypeEmprunt.EFFECTIF, livre2, personne3));
		
		personne1.getEmprunts().add(new Emprunt(null, TypeEmprunt.EFFECTIF, livre1, personne1));
		

	}
}