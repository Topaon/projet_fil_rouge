package com.inetum.pfr.projetFilRouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Domaine;

public interface DaoDomaine extends JpaRepository<Domaine, Long>{
	
	public Domaine findDomaineWithLivresById(Long id);

}
