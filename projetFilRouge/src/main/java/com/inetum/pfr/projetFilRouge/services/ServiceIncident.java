package com.inetum.pfr.projetFilRouge.services;

import com.inetum.pfr.projetFilRouge.dto.IncidentDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Incident;
import com.inetum.pfr.projetFilRouge.entity.Incident.TypeIncident;
import com.inetum.pfr.projetFilRouge.entity.Livre.EtatLivre;
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface ServiceIncident extends GenericService<Incident, Long, IncidentDto> {
	
//	Méthodes hérités de AbstractGenericService :
	
	//  List<Emprunt> searchAll()
	//	<Optional> Emprunt searchById (Long empruntId)
	//	void removeById (Long emopruntId);
	//	Emprunt saveOrUpdate (Emprunt emprunt);		
	//	boolean existsById (Long empruntId);
	
	
	
	// Méthodes métier
	
	Incident declarerIncident(Long empruntId, String typeIncident, String description) throws EmpruntException;
}