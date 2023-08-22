package com.inetum.pfr.projetFilRouge.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.inetum.pfr.projetFilRouge.dao.DaoDomaine;
import com.inetum.pfr.projetFilRouge.entity.Domaine;

@Service
@Transactional
public class ServiceDomaineImpl extends AbstractGenericService<Domaine, Long> implements ServiceDomaine {

	@Autowired
	DaoDomaine daoDomaine;
	
	@Override
	public CrudRepository<Domaine, Long> getDao() {
		return this.daoDomaine;
	}
}
