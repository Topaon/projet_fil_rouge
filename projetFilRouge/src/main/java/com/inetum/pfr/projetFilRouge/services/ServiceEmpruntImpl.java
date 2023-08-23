package com.inetum.pfr.projetFilRouge.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.pfr.projetFilRouge.dao.DaoEmprunt;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.dto.EmpruntDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;
import com.inetum.pfr.projetFilRouge.util.AppUtil;

@Service
@Transactional
public class ServiceEmpruntImpl extends AbstractGenericService<Emprunt, Long, EmpruntDto> implements ServiceEmprunt {
	
	@Override
	public Class<EmpruntDto> getDtoClass() {
		return EmpruntDto.class;
	}

	
	// ATTRIBUTS -------------------
	
	private DaoEmprunt daoEmprunt;
	private DaoLivre daoLivre;
	private DaoPersonne daoPersonne;
	
		// attributs remonté à la classe mère
	public CrudRepository<Emprunt, Long> getDao() {
		return this.daoEmprunt;
	}
	
	// CONSTRUCTEUR ----------------
	
	public ServiceEmpruntImpl (DaoEmprunt daoEmprunt, DaoPersonne daoPersonne, DaoLivre daoLivre) {
		this.daoEmprunt = daoEmprunt;
		this.daoLivre = daoLivre;
		this.daoPersonne = daoPersonne;
	}
	
	
	// METHODES ---------------------
	
		// méthodes métiers
	
	@Override
	public void emprunter(Long personneId, Long livreId) {
		
		Livre livreAEmprunter = daoLivre.findById(livreId).orElse(null);
		Personne emprunteur = daoPersonne.findById(personneId).orElse(null);
		
		boolean dispoLivre = livreAEmprunter.getDispo();
		boolean maxEmprunts = daoPersonne.countLoansById(personneId).size() >= Personne.maxEmprunts;
		
		if (dispoLivre == true && maxEmprunts == false) {
			Emprunt livreEmprunte = new Emprunt (null, TypeEmprunt.EFFECTIF, livreAEmprunter, emprunteur);
			daoEmprunt.save(livreEmprunte);
		} else {
				throw new EmpruntException("Disponibilité du livre = " 
						+ dispoLivre + "\t Nombre d'emprunts maximum du lecteur atteint = " + maxEmprunts);
		}
	}
	
	@Override
	public void prolonger(Long empruntId) {
		
		Emprunt empruntAProlonger = daoEmprunt.findById(empruntId).orElse(null);
		Date dateFinEmprunt = empruntAProlonger.getDateFin();
		Date dateDuJour = new Date();
		Long joursDeRetard = ChronoUnit.DAYS.between(AppUtil.asLocalDate(dateFinEmprunt), AppUtil.asLocalDate(dateDuJour));
		
		if (joursDeRetard <= 7) {
			empruntAProlonger.setDateFin(AppUtil.ajouterJours(dateFinEmprunt, 7));	
		} else {
			throw new EmpruntException("Prolongement de l'emprunt non autorisé car retard de retour au delà de 7 jours, nombre de jours de retard = " + joursDeRetard);
		};		
	}
	
	
	@Override
	public void retourner(Long empruntId) {
		
		Emprunt empruntARetourner = daoEmprunt.findById(empruntId).orElse(null);
		Livre livreARetourner = empruntARetourner.getLivre();
		
		empruntARetourner.setEnCours(false);
		livreARetourner.setDispo(true);
		
	}
	
	
		// Méthodes SpringData & NamedQueries

	@Override
	public Emprunt searchByPersonneIdAndLivreIdAndEnCoursTrue(Long personneId, Long livreId) {
		return daoEmprunt.findByPersonneIdAndLivreIdAndEnCoursTrue(personneId, livreId);
		
	}

	@Override
	public Emprunt searchByPersonneIdAndLivreId(Long personneId, Long livreId) {
		return daoEmprunt.findByPersonneIdAndLivreId(personneId, livreId);
	}

	@Override
	public List<Emprunt> tousLesRetards() {
		return daoEmprunt.getLateReturn();
	}
}
