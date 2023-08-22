package com.inetum.pfr.projetFilRouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Personne;

public interface DaoPersonne extends JpaRepository<Personne, Long> {

}
