package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

public interface IDaoGeneric<E,PK> {
	E findById(PK id);
	List<E> findAll();
	E insert(E e);
	void update(E e);
	void deleteById(PK id);
}
