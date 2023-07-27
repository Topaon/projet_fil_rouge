package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
public abstract class DaoGeneric<E, PK> implements IDaoGeneric<E, PK> {

	private Class<E> entityClass; // à renseigner avec Entite.class dans le constructeur
	
	public DaoGeneric(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public abstract EntityManager getEntityManager();
	
	
	// CRUD
	@Override
	public E findById(PK id) {
		return getEntityManager().find(entityClass, id);
	}

	@Override
	public List<E> findAll() {
		return getEntityManager().createQuery("FROM " + entityClass.getSimpleName(),
				entityClass).getResultList();
	}

	@Override
	public E insert(E e) {
		getEntityManager().persist(e);
		return e;
	}

	@Override
	public void update(E e) {
		getEntityManager().merge(e);
	}

	@Override
	public void deleteById(PK id) {
		getEntityManager().remove(getEntityManager().find(entityClass, id));
	}

}
