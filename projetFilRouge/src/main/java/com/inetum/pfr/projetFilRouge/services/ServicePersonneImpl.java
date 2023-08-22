package com.inetum.pfr.projetFilRouge.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.entity.Personne;

@Service
@Transactional
public class ServicePersonneImpl extends AbstractGenericService<Personne, Long> implements ServicePersonne{
	
	Logger logger = LoggerFactory.getLogger(ServicePersonne.class);
	
	
	// ATTRIBUTS -------------------
	
	private DaoPersonne daoPersonne;
	
	
		// attributs remonté à la classe mère
	public CrudRepository<Personne, Long> getDao() {
		return this.daoPersonne;
	}
	
	
	// CONSTRUCTEUR ----------------
	
	@Autowired
	public ServicePersonneImpl (DaoPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}
	
	
	// METHODES ---------------------
	



}
