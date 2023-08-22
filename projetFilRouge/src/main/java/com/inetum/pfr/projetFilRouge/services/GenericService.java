package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

public interface GenericService<E, ID> {
	public E searchById(ID id);
	
	public E saveOrUpdate(E entity);
	
	public void removeById (ID id);
	
	public boolean existsById (ID id);
	
	public List<E>searchAll();
	
	

}