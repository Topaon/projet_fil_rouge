package com.inetum.pfr.projetFilRouge.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.inetum.pfr.projetFilRouge.entity.Personne;

@Repository
public class DaoPersonne extends DaoGeneric<Personne, Long> implements IDaoPersonne {
	@PersistenceContext
	EntityManager entityManager;
	
	public DaoPersonne() {
		super(Personne.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
}