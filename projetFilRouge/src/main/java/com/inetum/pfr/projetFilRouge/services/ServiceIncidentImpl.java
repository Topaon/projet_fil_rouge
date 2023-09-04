package com.inetum.pfr.projetFilRouge.services;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.inetum.pfr.projetFilRouge.dao.DaoEmprunt;
import com.inetum.pfr.projetFilRouge.dao.DaoIncident;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dto.IncidentDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Incident;
import com.inetum.pfr.projetFilRouge.entity.Incident.TypeIncident;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;

@Service
@Transactional
public class ServiceIncidentImpl extends AbstractGenericService<Incident, Long, IncidentDto> implements ServiceIncident {
	
	// ATTRIBUTS -------------------
	
	private DaoIncident daoIncident;
	private DaoEmprunt daoEmprunt;
	private ServiceEmprunt serviceEmprunt;
	
		// attributs remonté à la classe mère
	
	public CrudRepository<Incident, Long> getDao() {
		return this.daoIncident;
	}

	public Class<IncidentDto> getDtoClass() {
		return IncidentDto.class;
	}
	
	// CONSTRUCTEUR ----------------
	
	public ServiceIncidentImpl (DaoIncident daoIncident, DaoEmprunt daoEmprunt) {
		this.daoIncident = daoIncident;
		this.daoEmprunt = daoEmprunt;
	}
	
	
	// METHODES ---------------------
	
			// méthodes métiers

	public Incident declarerIncident(Long empruntId, String typeIncident, String description) throws EmpruntException {
		
		Emprunt emprunt = daoEmprunt.findById(empruntId).orElse(null);
		TypeIncident typeIncidentEnum = TypeIncident.valueOf(typeIncident);
		EtatLivre ancienEtat = emprunt.getLivre().getEtat();
		Incident incident = null;
		
			if (typeIncident == "LIVRE_ABIME") {
				serviceEmprunt.retourner(empruntId);
				emprunt.getLivre().setEtat(EtatLivre.ABIME);
				incident = new Incident(null, typeIncidentEnum, emprunt, ancienEtat, EtatLivre.ABIME, description);
			} 
			
			
			else if (typeIncident == "LIVRE_PERDU") {
				serviceEmprunt.retourner(empruntId);
				emprunt.getLivre().setEtat(EtatLivre.HORS_SERVICE);
				emprunt.getLivre().setDispo(false);
				incident = new Incident(null, typeIncidentEnum, emprunt, ancienEtat, EtatLivre.HORS_SERVICE, description);
			}
			return incident;
	}
	
}
