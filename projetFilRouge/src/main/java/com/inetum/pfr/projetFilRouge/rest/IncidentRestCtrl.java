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

import com.inetum.pfr.projetFilRouge.entity.Incident;
import com.inetum.pfr.projetFilRouge.services.ServiceIncident;

@RestController
@RequestMapping(value = "/api-bibliotheque/incident", headers="Accept=application/json")
public class IncidentRestCtrl {

	@Autowired
	ServiceIncident serviceIncident;
	
	@GetMapping("")
	public List<Incident> getAllIncidents() {
		return serviceIncident.searchAll();
	}
	
	@GetMapping("/{id}")
	public Incident getIncidentById(@PathVariable("id") Long id ) {
		return serviceIncident.searchById(id);
	}
	
	@PostMapping("")
	public Incident addIncident(@RequestBody Incident Incident) {
		return serviceIncident.saveOrUpdate(Incident);
	}
		
	@PutMapping("")
	public ResponseEntity<?> updateIncident(@RequestBody Incident incident) {
		Long idCompteAModifier = incident.getId();
		
		if(serviceIncident.searchById(idCompteAModifier) == null) {
			return new ResponseEntity<String>("Le compte à modifier n'a pas été trouvé", HttpStatus.NOT_FOUND);
		} else {
			serviceIncident.saveOrUpdate(incident);
			return new ResponseEntity<String>("Modification effectuée", HttpStatus.ACCEPTED);
		}
	}
}