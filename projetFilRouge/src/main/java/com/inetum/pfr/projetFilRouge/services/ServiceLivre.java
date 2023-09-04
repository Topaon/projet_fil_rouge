package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import com.inetum.pfr.projetFilRouge.dto.LivreDto;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface ServiceLivre extends GenericService<Livre, Long, LivreDto> {
	
//	Méthodes hérités de AbstractGenericService :

	//	<Optional> Personne searchById (Long personneId)
	//	void removeById (Long personneId);
	//	Personne saveOrUpdate (Personne personne);		
	//	boolean existsById (Long personneId);
	
	
	
//  Méthodes SpringData & NamedQueries
	
	List <LivreDto> searchByTitre(String titreLivre) throws NotFoundException;
	
}
