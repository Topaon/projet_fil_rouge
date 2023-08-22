package com.inetum.pfr.projetFilRouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.services.ServiceEmprunt;


@RestController
@RequestMapping(value = "/api-bibliotheque/emprunt", headers = "Accept=application/json")
public class EmpruntRestCtrl {
	
	@Autowired
	ServiceEmprunt serviceEmprunt;
	
	
	// READ
	// URL: ./api-bibliotheque/emprunt
	
	@GetMapping("")
	public List<Emprunt> getAllEmprunts() {
		return serviceEmprunt.searchAll();
	}
	
	
	// exemple d'URL: ./api-bibliotheque/emprunt/1
	// permet de trouver un emprunt avec son ID
	
	@GetMapping("/{empruntId}")
	public ResponseEntity<Emprunt> getEmpruntById(@PathVariable("empruntId") Long id) {
		Emprunt emprunt = serviceEmprunt.searchById(id);

		if (emprunt != null) {
			return new ResponseEntity<Emprunt>(emprunt, HttpStatus.OK);
		} else {
			return new ResponseEntity<Emprunt>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// CREATE
	// exemple d'URL: ./api-bibliotheque/emprunt
	// appelée en POST:
	// {"id" : null ,"livre" : 1, "dateDebut": 01/07/2023 , "dateFin": 25/07/2023, "type" : "EFFECTIF"}
	
	@PostMapping
	public Emprunt postEmprunt(@RequestBody Emprunt nouvelEmprunt) {
		Emprunt EmpruntStocke = serviceEmprunt.saveOrUpdate(nouvelEmprunt);
		return EmpruntStocke;
	}
	
	
	// UPDATE
		// exemple d'URL: ./api-bibliotheque/emprunt
		// appelée en PUT:
		// {"id" : 1 ,"livre" : 1, "dateDebut": 01/07/2023 , "dateFin": 31/07/2023, "type" : "EFFECTIF"}
	
	@PutMapping
	public ResponseEntity<?> putEmprunt(@RequestBody Emprunt Emprunt) {
		Long idEmpruntRecherche = Emprunt.getId();
		Emprunt EmpruntRecherche = serviceEmprunt.searchById(idEmpruntRecherche);

		if (EmpruntRecherche == null) {
			return new ResponseEntity<String>("{\"err\" : \"Emprunt non trouvé\"}", HttpStatus.NOT_FOUND);
		} else {
			serviceEmprunt.saveOrUpdate(Emprunt);
			return new ResponseEntity<Emprunt>(Emprunt, HttpStatus.OK);
		}

	}
	
	// DELETE
	// exemple d'URL: ./api-bibliotheque/emprunt/1
	// appelée en DELETE
	
	@DeleteMapping("/{empruntId}")
	public ResponseEntity<?> deleteempruntById(@PathVariable("empruntId") Long id) {
		Emprunt empruntRecherche = serviceEmprunt.searchById(id);
		if (empruntRecherche != null) {
			serviceEmprunt.removeById(id);
			return new ResponseEntity<String>("{ \"done\" : \"emprunt supprimé\"}", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"err\" : \"emprunt non trouvé\"}", HttpStatus.NOT_FOUND);
		}
	}

}
