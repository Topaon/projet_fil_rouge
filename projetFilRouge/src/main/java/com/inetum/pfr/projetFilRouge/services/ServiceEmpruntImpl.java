package com.inetum.pfr.projetFilRouge.services;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inetum.pfr.projetFilRouge.converter.DtoConverter;
import com.inetum.pfr.projetFilRouge.converter.GenericConverter;
import com.inetum.pfr.projetFilRouge.dao.DaoEmprunt;
import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.dto.EmpruntDtoIds;
import com.inetum.pfr.projetFilRouge.dto.EmpruntDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.entity.Personne;
import com.inetum.pfr.projetFilRouge.exception.EmpruntException;
import com.inetum.pfr.projetFilRouge.exception.NotFoundException;
import com.inetum.pfr.projetFilRouge.util.AppUtil;

@Service
@Transactional
public class ServiceEmpruntImpl extends AbstractGenericService<Emprunt, Long, EmpruntDto> implements ServiceEmprunt {
	
	
	// ATTRIBUTS -------------------
	
	private DaoEmprunt daoEmprunt;
	private DaoLivre daoLivre;
	private DaoPersonne daoPersonne;
	private DtoConverter dtoConverter = new DtoConverter();
	
		// attributs remonté à la classe mère
	public CrudRepository<Emprunt, Long> getDao() {
		return this.daoEmprunt;
	}
	
	@Override
	public Class<EmpruntDto> getDtoClass() {
		return EmpruntDto.class;
	}
	
	// CONSTRUCTEUR ----------------
	
	public ServiceEmpruntImpl (DaoEmprunt daoEmprunt, DaoPersonne daoPersonne, DaoLivre daoLivre, ServicePersonne servicePersonne) {
		this.daoEmprunt = daoEmprunt;
		this.daoLivre = daoLivre;
		this.daoPersonne = daoPersonne;
	}
	
	
	// METHODES ---------------------
	
		// méthodes métiers
	
	@Override
	public Emprunt emprunter(Long personneId, Long livreId) {
		
		Livre livreAEmprunter = daoLivre.findById(livreId).orElse(null);
		Personne emprunteur = daoPersonne.findById(personneId).orElse(null);
		
		boolean dispoLivre = livreAEmprunter.getDispo();
		boolean maxEmprunts = daoPersonne.countLoansById(personneId).size() >= Personne.maxEmprunts;
			
		if (livreAEmprunter!=null && emprunteur!=null) {
			
			if (dispoLivre == true && maxEmprunts == false) {
				Emprunt livreEmprunte = new Emprunt (null, TypeEmprunt.EFFECTIF, livreAEmprunter, emprunteur);
				livreAEmprunter.setDispo(false);
				daoEmprunt.save(livreEmprunte);
				return livreEmprunte;
			} else {
				throw new EmpruntException("Emprunt non autorisé // Disponibilité du livre = " 
						+ dispoLivre + ", Nombre d'emprunts maximum du lecteur atteint = " + maxEmprunts);
			}
		} else {
			throw new NotFoundException("Livre ou emprunteur inexistant, id livre = " + livreId + " id personne = " + personneId);
		}
	}
	
	
	@Override
	public EmpruntDtoIds emprunter(EmpruntDtoIds empruntDtoIds) {
		
		if(empruntDtoIds.getLivreId() != null && empruntDtoIds.getPersonneId() != null) {
			
			Livre livreAEmprunter = daoLivre.findById(empruntDtoIds.getLivreId()).orElse(null);
			Personne emprunteur = daoPersonne.findById(empruntDtoIds.getPersonneId()).orElse(null);
			
			boolean dispoLivre = livreAEmprunter.getDispo();
			boolean maxEmprunts = daoPersonne.countLoansById(empruntDtoIds.getPersonneId()).size() >= Personne.maxEmprunts;
			
			if (livreAEmprunter!=null && emprunteur!=null) {
				
				if (dispoLivre == true && maxEmprunts == false) {
					Emprunt livreEmprunte = new Emprunt (null, TypeEmprunt.EFFECTIF, livreAEmprunter, emprunteur);
					livreAEmprunter.setDispo(false);
					daoEmprunt.save(livreEmprunte);
					empruntDtoIds.setId(livreEmprunte.getId());
					return empruntDtoIds;
				} else {
					throw new EmpruntException("Emprunt non autorisé // Disponibilité du livre = " 
							+ dispoLivre + ", Nombre d'emprunts maximum du lecteur atteint = " + maxEmprunts);
				}
			} else {
				throw new NotFoundException("Livre ou emprunteur inexistant, id livre = " + empruntDtoIds.getLivreId() + " id personne = " + empruntDtoIds.getPersonneId());
			}
		} else {
			throw new NotFoundException("ID Personne ou ID livre non renseigné, ID livre = " + empruntDtoIds.getLivreId() + " ID Personne = " + empruntDtoIds.getPersonneId());
		}
		
	}
	
	
	
	@Override
	public void prolonger(Long empruntId) {
		
		Emprunt empruntAProlonger = daoEmprunt.findById(empruntId).orElse(null);
		
		if (empruntAProlonger !=null) {
			Date dateFinEmprunt = empruntAProlonger.getDateFin();
			Date dateDuJour = new Date();
			Long joursDeRetard = ChronoUnit.DAYS.between(AppUtil.asLocalDate(dateFinEmprunt), AppUtil.asLocalDate(dateDuJour));
			Long dureEmprunt = ChronoUnit.DAYS.between(AppUtil.asLocalDate(empruntAProlonger.getDateDebut()), AppUtil.asLocalDate(empruntAProlonger.getDateFin()));
			
			if (joursDeRetard <= 7 && dureEmprunt == 21) {
				empruntAProlonger.setDateFin(AppUtil.ajouterJours(dateFinEmprunt, 7));	
			} else {
				throw new EmpruntException("Prolongement de l'emprunt non autorisé car retard de retour au delà de 7 jours ou emprunt déjà prolongé. Nombre de jours de retard = " + joursDeRetard);
			};		
		} else {
			throw new NotFoundException("Emprunt inexistant pour l'id = " + empruntId);
		}
	}
	
	
	@Override
	public void retourner(Long empruntId) {
		
		Emprunt empruntARetourner = daoEmprunt.findById(empruntId).orElse(null);
		
		if (empruntARetourner !=null) {
			Livre livreARetourner = empruntARetourner.getLivre();
			daoEmprunt.deleteById(empruntARetourner.getId());
			livreARetourner.setDispo(true);			
		} else {
			throw new NotFoundException("Emprunt inexistant pour l'id = " + empruntId);
		}
	}
	
	
		// Méthodes SpringData & NamedQueries

	@Override
	public List<EmpruntDto> searchByPersonneId(Long personneId) throws NotFoundException {
		Personne personne = daoPersonne.findById(personneId).orElse(null);
		
		if(personne != null) { 
			List <Emprunt> le =  daoEmprunt.findByPersonneId(personneId);
			return dtoConverter.empruntToEmpruntDto(le);
			
		} else {
			throw new NotFoundException("Aucune correspondance trouvé pour l'id : " + personneId);
		}
		
		
	}
	
	@Override
	public Emprunt searchByPersonneIdAndLivreIdAndEnCoursTrue(Long personneId, Long livreId) {
		return daoEmprunt.findByPersonneIdAndLivreIdAndEnCoursTrue(personneId, livreId);
		
	}

	@Override
	public Emprunt searchByPersonneIdAndLivreId(Long personneId, Long livreId) {
		return daoEmprunt.findByPersonneIdAndLivreId(personneId, livreId);
	}
	
	@Override
	public List<Emprunt> tousLesRetards() {
		return daoEmprunt.getLateReturn();
	}
	
	
		// Surcharge AbstractGenericService
	
	public List<EmpruntDto> searchAllDto() {
		List<Emprunt> le = daoEmprunt.findAll();
		return dtoConverter.empruntToEmpruntDto(le);
	}
	
	
//	public EmpruntDtoIds saveOrUpdateEmpruntDtoIds(EmpruntDtoIds emprunDtoIds) {
//		// en entree : EmpruntDtoIds avec .livreId et .personneId
//		// a transformer en empruntEntity relié à livreEntity si .livreId pas null et  à personneEntity si .personneId pas null
//		Emprunt empruntEntity = GenericConverter.map(emprunDtoIds, Emprunt.class);
//		if(emprunDtoIds.getLivreId() !=null && emprunDtoIds.getPersonneId() !=null) {
//			Livre livreEntity = daoLivre.findById(emprunDtoIds.getLivreId()).get();
//			Personne personneEntity = daoPersonne.findById(emprunDtoIds.getPersonneId()).get();
//			empruntEntity.setLivre(livreEntity);
//			empruntEntity.setPersonne(personneEntity);
//			
//		}
//		daoEmprunt.save(empruntEntity); 
//		emprunDtoIds.setId(empruntEntity.getId());
//		return emprunDtoIds; //on retourne le DtoIds sauvegardé
//		                    //avec la clef primaire autoincrémenté
//	}

		
}
