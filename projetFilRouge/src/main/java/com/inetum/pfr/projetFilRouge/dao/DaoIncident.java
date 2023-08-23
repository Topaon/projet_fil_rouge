package com.inetum.pfr.projetFilRouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inetum.pfr.projetFilRouge.entity.Incident;

public interface DaoIncident extends JpaRepository<Incident, Long>{

}