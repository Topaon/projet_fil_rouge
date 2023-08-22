package com.inetum.pfr.projetFilRouge.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;

public interface DaoEmprunt extends JpaRepository<Emprunt, Long>{
	

}
