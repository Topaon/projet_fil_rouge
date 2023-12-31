package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import com.inetum.pfr.projetFilRouge.dto.EmpruntDto;
import com.inetum.pfr.projetFilRouge.dto.EmpruntDtoIds;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface ServiceEmprunt extends GenericService<Emprunt, Long, EmpruntDto> {
	
	//	Méthodes hérités de AbstractGenericService :
	
	//  List<Emprunt> searchAll()
	//	<Optional> Emprunt searchById (Long empruntId)
	//	void removeById (Long emopruntId);
	//	Emprunt saveOrUpdate (Emprunt emprunt);		
	//	boolean existsById (Long empruntId);
	
	
	
	// Méthodes métier
	
	Emprunt emprunter(Long personneId, Long livreId) throws EmpruntException;
	EmpruntDtoIds emprunter(EmpruntDtoIds emprunDtoIds) throws EmpruntException;
	void prolonger(Long empruntId) throws NotFoundException;
	void retourner(Long empruntId) throws NotFoundException;
	
	//  Méthodes SpringData & NamedQueries
	
	Emprunt searchByPersonneIdAndLivreIdAndEnCoursTrue(Long personneId, Long livreId) throws NotFoundException;
	Emprunt searchByPersonneIdAndLivreId(Long personneId, Long livreId) throws NotFoundException;
	List <EmpruntDto> searchByPersonneId(Long personneId) throws NotFoundException;
	List<Emprunt> tousLesRetards();

	

}
