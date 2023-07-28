package com.inetum.pfr.projetFilRouge.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;

@Repository
public class DaoEmprunt extends DaoGeneric<Emprunt, Long> implements IDaoEmprunt {
	

	@PersistenceContext
	EntityManager entityManager;
	
	public DaoEmprunt() {
		super(Emprunt.class);
	}
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
