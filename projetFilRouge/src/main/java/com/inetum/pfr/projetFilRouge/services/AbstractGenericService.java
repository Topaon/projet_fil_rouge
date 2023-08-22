package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public abstract class AbstractGenericService<E, ID> implements GenericService<E, ID> {

	public abstract CrudRepository<E, ID> getDao();
	
	@Override
	public E searchById(ID id) {
		return getDao().findById(id).orElse(null);
	}

	@Override
	public E saveOrUpdate(E entity) {
		return getDao().save(entity);
	}

	@Override
	public void removeById(ID id) {
		getDao().deleteById(id);
	}

	@Override
	public boolean existsById(ID id) {
		return getDao().existsById(id);
	}

	@Override
	public List<E> searchAll() {
		return (List<E>) getDao().findAll();
	}


	}

