package com.inetum.pfr.projetFilRouge.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.pfr.projetFilRouge.dao.DaoEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;

@Service
@Transactional
public class ServiceEmpruntImpl extends AbstractGenericService<Emprunt, Long> implements ServiceEmprunt {

	
	// ATTRIBUTS -------------------
	
	private DaoEmprunt daoEmprunt;
	
		// attributs remonté à la classe mère
	public CrudRepository<Emprunt, Long> getDao() {
		return this.daoEmprunt;
	}
	
	// CONSTRUCTEUR ----------------
	
	public ServiceEmpruntImpl (DaoEmprunt daoEmprunt) {
		this.daoEmprunt = daoEmprunt;
	}
	
	
	// METHODES ---------------------
	
	


}
