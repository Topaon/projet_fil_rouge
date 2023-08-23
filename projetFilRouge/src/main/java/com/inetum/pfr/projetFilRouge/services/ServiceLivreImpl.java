package com.inetum.pfr.projetFilRouge.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dto.LivreDto;
import com.inetum.pfr.projetFilRouge.entity.Livre;

@Service
@Transactional
public class ServiceLivreImpl extends AbstractGenericService<Livre, Long, LivreDto> implements ServiceLivre {
	
	@Override
	public Class<LivreDto> getDtoClass() {
		return LivreDto.class;
	}
	
	@Autowired
	DaoLivre daoLivre;
	
	@Override
	public CrudRepository<Livre, Long> getDao() {
		return this.daoLivre;
	}
}
