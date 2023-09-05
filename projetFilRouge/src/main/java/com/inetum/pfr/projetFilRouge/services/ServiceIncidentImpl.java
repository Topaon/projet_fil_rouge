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
	
	public ServiceIncidentImpl (DaoIncident daoIncident, DaoEmprunt daoEmprunt, ServiceEmprunt serviceEmprunt) {
		this.daoIncident = daoIncident;
		this.daoEmprunt = daoEmprunt;
		this.serviceEmprunt = serviceEmprunt;
	}
	
	
	// METHODES ---------------------
	
			// méthodes métiers

	public Incident declarerIncident(Long empruntId, String typeIncident, String nouvelEtat, String description) throws EmpruntException {
		
		Emprunt emprunt = daoEmprunt.findById(empruntId).orElse(null);
		TypeIncident typeIncidentEnum = TypeIncident.valueOf(typeIncident);
		EtatLivre ancienEtat = emprunt.getLivre().getEtat();
		EtatLivre nouvelEtatEnum = EtatLivre.valueOf(nouvelEtat);
		
		Incident incident = null;
		
			if (typeIncident.equals("LIVRE_ABIME")) {
				System.out.println(typeIncident.equals("LIVRE_ABIME"));
				serviceEmprunt.retourner(empruntId);
				emprunt.getLivre().setEtat(nouvelEtatEnum);
				incident = new Incident(null, typeIncidentEnum, emprunt, ancienEtat, nouvelEtatEnum, description);
			} 
			
			else if (typeIncident.equals("LIVRE_PERDU")) {
				serviceEmprunt.retourner(empruntId);
				emprunt.getLivre().setEtat(EtatLivre.HORS_SERVICE);
				emprunt.getLivre().setDispo(false);
				incident = new Incident(null, typeIncidentEnum, emprunt, ancienEtat, nouvelEtatEnum, description);
			} 
		
		daoIncident.save(incident);
		return incident;
		
	}
	
	public IncidentDto declarerIncidentDto(IncidentDto incidentDto) throws EmpruntException {
		
		Emprunt emprunt = daoEmprunt.findById(incidentDto.getEmpruntId()).orElse(null);
		TypeIncident typeIncidentEnum = TypeIncident.valueOf(incidentDto.getTypeIncident());
		EtatLivre ancienEtat = emprunt.getLivre().getEtat();
		EtatLivre nouvelEtatEnum = EtatLivre.valueOf(incidentDto.getNouvelEtat());
		
		Incident incident = null;
		
			if (incidentDto.getTypeIncident().equals("LIVRE_ABIME")) {
				System.out.println(incidentDto.getTypeIncident().equals("LIVRE_ABIME"));
//				serviceEmprunt.retourner(incidentDto.getEmpruntId());
				emprunt.getLivre().setEtat(nouvelEtatEnum);
				incident = new Incident(null, typeIncidentEnum, emprunt, ancienEtat, nouvelEtatEnum, incidentDto.getDescription());
			} 
			
			else if (incidentDto.getTypeIncident().equals("LIVRE_PERDU")) {
//				serviceEmprunt.retourner(incidentDto.getEmpruntId());
				emprunt.getLivre().setEtat(EtatLivre.HORS_SERVICE);
				emprunt.getLivre().setDispo(false);
				incident = new Incident(null, typeIncidentEnum, emprunt, ancienEtat, nouvelEtatEnum, incidentDto.getDescription());
			} 
		
		daoIncident.save(incident);
		return incidentDto;
		
	}
	
}
