package com.inetum.pfr.projetFilRouge.dao;

import com.inetum.pfr.projetFilRouge.entity.Domaine;

public interface IDaoDomaine extends IDaoGeneric<Domaine, Long>{
	
	public Domaine findDomaineWithLivresById(Long id);

}
