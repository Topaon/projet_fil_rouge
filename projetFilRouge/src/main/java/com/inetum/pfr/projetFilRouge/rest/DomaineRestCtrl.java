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

import com.inetum.pfr.projetFilRouge.dao.DaoDomaine;
import com.inetum.pfr.projetFilRouge.entity.Domaine;

@RestController
@RequestMapping(value = "/api-bibliotheque/domaine", headers="Accept=application/json")
public class DomaineRestCtrl {

	@Autowired
	DaoDomaine daoDomaine;
	
	@GetMapping("")
	public List<Domaine> getAllDomaines() {
		return daoDomaine.findAll();
	}
	
	@GetMapping("/{id}")
	public Domaine getDomaineById(@PathVariable("id") Long id ) {
		return daoDomaine.findById(id).orElse(null);
	}
	
	@PostMapping("")
	public Domaine addDomaine(@RequestBody Domaine domaine) {
		return daoDomaine.save(domaine);
	}
		
	@PutMapping("")
	public ResponseEntity<?> updateDomaine(@RequestBody Domaine domaine) {
		Long idCompteAModifier = domaine.getId();
		
		if(daoDomaine.findById(idCompteAModifier) == null) {
			return new ResponseEntity<String>("Le compte à modifier n'a pas été trouvé", HttpStatus.NOT_FOUND);
		} else {
			daoDomaine.save(domaine);
			return new ResponseEntity<String>("Modification effectuée", HttpStatus.ACCEPTED);
		}
	}
}