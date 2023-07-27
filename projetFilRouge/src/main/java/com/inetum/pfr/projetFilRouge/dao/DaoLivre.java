package com.inetum.pfr.projetFilRouge.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.inetum.pfr.projetFilRouge.entity.Livre;

@Repository
public class DaoLivre extends DaoGeneric<Livre, Long> implements IDaoLivre {
	
	@PersistenceContext
	EntityManager entityManager;
	
	
	public DaoLivre() {
		super(Livre.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
