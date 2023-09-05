package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.pfr.projetFilRouge.converter.GenericConverter;
import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.dto.PersonneDto;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

@Service
@Transactional
public class ServicePersonneImpl extends AbstractGenericService<Personne, Long, PersonneDto> implements ServicePersonne{
	
	@Override
	public Class<PersonneDto> getDtoClass() {
		return PersonneDto.class;
	}
	
	Logger logger = LoggerFactory.getLogger(ServicePersonne.class);
	
	
	// ATTRIBUTS -------------------
	
	private DaoPersonne daoPersonne;
	
	
		// attributs remonté à la classe mère
	public CrudRepository<Personne, Long> getDao() {
		return this.daoPersonne;
	}
	
	
	// CONSTRUCTEUR ----------------
	
	@Autowired
	public ServicePersonneImpl (DaoPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	
	
	// METHODES ---------------------
	
	
	@Override
	public List <PersonneDto> searchByNom(String nomPersonne) throws NotFoundException {
		 List <Personne> lp = daoPersonne.findByNomIgnoreCase(nomPersonne);
		 if (lp.size() > 0) {
			 return GenericConverter.map(lp, PersonneDto.class);			 
		 } else {
			 throw new NotFoundException("Personne inexistante: " + nomPersonne);
		 }
	}



}
