package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inetum.pfr.projetFilRouge.dto.GenericConverter;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public abstract class AbstractGenericService<E, ID, DTO> implements GenericService<E, ID, DTO> {

	public abstract CrudRepository<E, ID> getDao();
	public abstract Class<DTO> getDtoClass();
	
	@Override
	public E searchById(ID id) throws NotFoundException {
		E e = getDao().findById(id).orElse(null);
		if(e != null) {
			return e;
		} else {
			throw new NotFoundException("Aucune correspondance trouvé pour l'id : " + id);
		}
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

