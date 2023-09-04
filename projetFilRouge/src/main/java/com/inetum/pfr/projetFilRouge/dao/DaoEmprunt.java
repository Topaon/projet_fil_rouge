package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

public interface DaoEmprunt extends JpaRepository<Emprunt, Long>{
	List <Emprunt> findByPersonneId(Long personneId) throws NotFoundException;
	Emprunt findByPersonneIdAndLivreIdAndEnCoursTrue(Long personneId, Long livreId) throws NotFoundException;
	Emprunt findByPersonneIdAndLivreId(Long personneId, Long livreId) throws NotFoundException;	
	public List<Emprunt> getLateReturn();
}
