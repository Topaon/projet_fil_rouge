package com.inetum.pfr.projetFilRouge.services;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;
import java.util.List;

public interface ServiceEmprunt extends GenericService<Emprunt, Long> {
	
	//	Méthodes hérités de AbstractGenericService :

	//	<Optional> Emprunt searchById (Long empruntId)
	//	void removeById (Long emopruntId);
	//	Emprunt saveOrUpdate (Emprunt emprunt);		
	//	boolean existsById (Long empruntId);
	
	
	
	// Méthodes métier
	
	void emprunter(Long personneId, Long livreId) throws EmpruntException;
	void prolonger(Long empruntId);
	void retourner(Long empruntId);
	
	// NamedQuery
	
	Emprunt searchByPersonneIdAndLivreIdAndEnCoursTrue(Long personneId, Long livreId);
	Emprunt searchByPersonneIdAndLivreId(Long personneId, Long livreId);
	List<Emprunt> tousLesRetards();
	

}
