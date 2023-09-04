package com.inetum.pfr.projetFilRouge.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.inetum.pfr.projetFilRouge.converter.GenericConverter;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dto.LivreDto;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;

@Service
@Transactional
public class ServiceLivreImpl extends AbstractGenericService<Livre, Long, LivreDto> implements ServiceLivre {
	
	// ATTRIBUTS -------------------
	
		private DaoLivre daoLivre;
		
			// attributs remonté à la classe mère
		public CrudRepository<Livre, Long> getDao() {
			return this.daoLivre;
		}
		
		@Override
		public Class<LivreDto> getDtoClass() {
			return LivreDto.class;
		}
		
	// CONSTRUCTEUR ----------------
		
		public ServiceLivreImpl (DaoLivre daoLivre) {
			this.daoLivre = daoLivre;
		}
		
	
	// METHODES ---------------------
		
		// Méthodes SpringData & NamedQueries

	@Override
	public List <LivreDto> searchByTitre(String titreLivre) throws NotFoundException {
		List <Livre> ll = daoLivre.findByTitreIgnoreCase(titreLivre);
		if (ll.size() > 0) {
			return GenericConverter.map(ll, LivreDto.class);
		} else {
			 throw new NotFoundException("Livre inexistant: " + titreLivre);
		 }
		
	}
	
	
	
}
