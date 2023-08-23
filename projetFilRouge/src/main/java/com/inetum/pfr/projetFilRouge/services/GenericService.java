package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface GenericService<E, ID, DTO> {
	public E searchById(ID id) throws NotFoundException;
	
	public E saveOrUpdate(E entity);
	
	public void removeById (ID id);
	
	public boolean existsById (ID id);
	
	public List<E>searchAll();
}