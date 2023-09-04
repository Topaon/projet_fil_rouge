package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

// Hérite toutes ses méthodes de IDaoGeneric
public interface DaoLivre extends JpaRepository<Livre, Long>{
	
	List <Livre> findByTitreIgnoreCase(String titreLivre) throws NotFoundException;

}
