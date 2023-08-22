package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Livre;

// Hérite toutes ses méthodes de IDaoGeneric
public interface DaoLivre extends JpaRepository<Livre, Long>{
	
	public List<Livre> findLivresOfDomain(Long id);
	public Livre findWithDomainById(Long id);
	
}
