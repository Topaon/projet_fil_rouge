package com.inetum.pfr.projetFilRouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.pfr.projetFilRouge.dto.DomaineDto;
import com.inetum.pfr.projetFilRouge.entity.Domaine;
import com.inetum.pfr.projetFilRouge.services.ServiceDomaine;

@RestController
@RequestMapping(value = "/api-bibliotheque/domaine", headers="Accept=application/json")
public class DomaineRestCtrl {

	@Autowired
	ServiceDomaine serviceDomaine;
	
	@GetMapping("")
	public List<DomaineDto> getAllDomaines() {
		return serviceDomaine.searchAllDto();
	}
	
	@GetMapping("/{id}")
	public DomaineDto getDomaineById(@PathVariable("id") Long id ) {
		return serviceDomaine.searchDtoById(id);
	}
	
	@PostMapping("")
	public Domaine addDomaine(@RequestBody Domaine domaine) {
		return serviceDomaine.saveOrUpdate(domaine);
	}
		
	@PutMapping("")
	public ResponseEntity<?> updateDomaine(@RequestBody Domaine domaine) {
		Long idCompteAModifier = domaine.getId();
		
		if(serviceDomaine.searchById(idCompteAModifier) == null) {
			return new ResponseEntity<String>("Le compte à modifier n'a pas été trouvé", HttpStatus.NOT_FOUND);
		} else {
			serviceDomaine.saveOrUpdate(domaine);
			return new ResponseEntity<String>("Modification effectuée", HttpStatus.ACCEPTED);
		}
	}
}