package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

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
	
	@Override
	public List<Livre> findLivresOfDomain(Long id) {
		return entityManager
				.createNamedQuery("Livre.findLivresOfDomain", Livre.class )
				.setParameter(1, id)
				.getResultList();
	}
	
	public Livre findWithDomainById(Long id) {
		return entityManager
				.createNamedQuery("Livre.findWithDomainById", Livre.class )
				.setParameter(1, id)
				.getSingleResult();
	}
	
	
	
}
