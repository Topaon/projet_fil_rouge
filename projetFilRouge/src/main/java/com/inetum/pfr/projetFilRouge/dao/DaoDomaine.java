package com.inetum.pfr.projetFilRouge.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.inetum.pfr.projetFilRouge.entity.Domaine;

@Repository
public class DaoDomaine extends DaoGeneric<Domaine, Long> implements IDaoDomaine {
	

	@PersistenceContext
	EntityManager entityManager;
	
	
	public DaoDomaine() {
		super(Domaine.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public Domaine findDomaineWithLivresById(Long id) {
		return entityManager
				.createNamedQuery("Domaine.findDomaineWithLivresById", Domaine.class )
				.setParameter(1, id)
				.getSingleResult();
	}
	
	
}
