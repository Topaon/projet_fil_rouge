package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import com.inetum.pfr.projetFilRouge.entity.Livre;

// Hérite toutes ses méthodes de IDaoGeneric
public interface IDaoLivre extends IDaoGeneric<Livre, Long>{
	
	public List<Livre> findLivresOfDomain(Long id);
	public Livre findWithDomainById(Long id);
	
}
