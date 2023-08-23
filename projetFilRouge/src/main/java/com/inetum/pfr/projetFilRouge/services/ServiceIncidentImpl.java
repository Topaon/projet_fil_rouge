package com.inetum.pfr.projetFilRouge.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.inetum.pfr.projetFilRouge.dao.DaoIncident;
import com.inetum.pfr.projetFilRouge.entity.Domaine;
import com.inetum.pfr.projetFilRouge.entity.Incident;

@Service
@Transactional
public class ServiceIncidentImpl extends AbstractGenericService<Incident, Long> implements ServiceIncident {

	@Autowired
	DaoIncident daoIncident;
	
	@Override
	public CrudRepository<Incident, Long> getDao() {
		return this.daoIncident;
	}
}
