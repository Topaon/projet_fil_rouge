package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;

public interface ServiceEmprunt extends GenericService<Emprunt, Long> {
	
	//	Méthodes hérités de AbstractGenericService :

	//	<Optional> Emprunt searchById (Long empruntId)
	//	void removeById (Long emopruntId);
	//	Emprunt saveOrUpdate (Emprunt emprunt);		
	//	boolean existsById (Long empruntId);
	
	
	
	// Méthodes métier
	
	void emprunter(Long personneId, Long livreId);
	void prolonger(Long empruntId);
	void retourner(Long empruntId);
	
	// NamedQuery
	
	List<Emprunt> tousLesRetards();
	

}
