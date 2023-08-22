package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Personne;

public interface DaoPersonne extends JpaRepository<Personne, Long> {
	
	List<Emprunt> countLoansById (long personneId);

}
