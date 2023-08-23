package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface GenericService<E, ID, DTO> {
	
	// Méthodes renvoyant des <Entity>
	
	public E searchById(ID id) throws NotFoundException;
	
	public E saveOrUpdate(E entity);
	
	public void removeById (ID id) throws NotFoundException;
	
	public boolean existsById (ID id);
	
	public List<E>searchAll();
	
	// Méthodes renvoyant des <DTO>
	
	public DTO searchDtoById(ID id) throws NotFoundException;
	
	public List<DTO>searchAllDto();
	
}