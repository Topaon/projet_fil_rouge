package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface DaoPersonne extends JpaRepository<Personne, Long> {
	
	List<Emprunt> countLoansById (long personneId);
	List <Personne> findByNomIgnoreCase(String nomPersonne) throws NotFoundException;

}
