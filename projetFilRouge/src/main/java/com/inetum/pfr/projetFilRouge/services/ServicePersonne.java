package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import com.inetum.pfr.projetFilRouge.dto.PersonneDto;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface ServicePersonne extends GenericService<Personne, Long, PersonneDto> {
	
	//	Méthodes hérités de AbstractGenericService :

	//	<Optional> Personne searchById (Long personneId)
	//	void removeById (Long personneId);
	//	Personne saveOrUpdate (Personne personne);		
	//	boolean existsById (Long personneId);
	
	
	// Méthodes métier
	
	
	//  Méthodes SpringData & NamedQueries
	
	List <PersonneDto> searchByNom(String nomPersonne) throws NotFoundException;
	
}
