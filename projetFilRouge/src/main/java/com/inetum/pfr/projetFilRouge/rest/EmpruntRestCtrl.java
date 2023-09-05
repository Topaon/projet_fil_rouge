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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.pfr.projetFilRouge.dto.EmpruntDtoIds;
import com.inetum.pfr.projetFilRouge.dto.EmpruntDto;
import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.services.ServiceEmprunt;


@RestController
@RequestMapping(value = "/api-bibliotheque/emprunt", headers = "Accept=application/json")
public class EmpruntRestCtrl {
	
	@Autowired
	ServiceEmprunt serviceEmprunt;
	
	
	// READ ALL
	// URL: ./api-bibliotheque/emprunt
	
	@GetMapping("")
	public List<EmpruntDto> getAllEmprunts() {
		return serviceEmprunt.searchAllDto();
	}
	
	// READ BY EMPRUNT ID
	// URL: ./api-bibliotheque/emprunt/1
	
	@GetMapping("/{empruntId}")
	public Emprunt getEmpruntById(@PathVariable("empruntId") Long id) {
		return serviceEmprunt.searchById(id);

	}
	
	// READ BY PERSONNE ID
	// URL: ./api-bibliotheque/emprunt/personne?personneId=2
	
	@GetMapping("/personne")
	public List<EmpruntDto> getEmpruntByPersonneId(@RequestParam(value = "personneId", required = false) Long id) {
		return serviceEmprunt.searchByPersonneId(id);
	}
	
	
	// CREATE
	// exemple d'URL: ./api-bibliotheque/emprunt/emprunter?personneId=1&livreId=4
	// appelée en GET:
	
//	@GetMapping("/emprunter")
//	public ResponseEntity <?> emprunter (@RequestParam(value = "personneId", required = false) Long personneId ,
//											@RequestParam(value ="livreId", required = false) Long livreId) {
//
//			if (personneId != null && livreId != null) {
//				Emprunt emprunter =  serviceEmprunt.emprunter(personneId, livreId);
//				return new ResponseEntity<Emprunt>(emprunter, HttpStatus.OK);
//			} else {
//				return new ResponseEntity<String>("{\"err\" : \"ID Personne ou ID livre non renseigné\"}", HttpStatus.NOT_FOUND);
//			}
//	}
	
	
	// CREATE
			// exemple d'URL: ./api-bibliotheque/emprunt/emprunter
			// appelée en POST:
			// {"livreId" : 1 ,"personneId" : 1}
	
		
	@PostMapping("/emprunter")
	public EmpruntDtoIds postEmprunt (@RequestBody EmpruntDtoIds nouvelEmprunt) {
		return serviceEmprunt.emprunter(nouvelEmprunt);
		
	}
	
	
	// PROLONGER
	// exemple d'URL: ./api-bibliotheque/emprunt/prolonger?empruntId=1
	// appelée en GET:
	
	@GetMapping("/prolonger")
	public  ResponseEntity <?> prolonger (@RequestParam(value = "empruntId", required = false) Long empruntId) {
		
		if (empruntId != null) {
			serviceEmprunt.prolonger(empruntId);	
			return new ResponseEntity<Emprunt>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{\"err\" : \"ID Emprunt non renseigné\"}", HttpStatus.NOT_FOUND);
		}
	}
	
	// RETOURNER
	// exemple d'URL: ./api-bibliotheque/emprunt/retourner?empruntId=1
	// appelée en GET:
	
	@GetMapping("/retourner")
	public  ResponseEntity <?> retourner (@RequestParam(value = "empruntId", required = false) Long empruntId) {
		
		if (empruntId != null) {
			serviceEmprunt.retourner(empruntId);	
			return new ResponseEntity<Emprunt>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{\"err\" : \"ID Emprunt non renseigné\"}", HttpStatus.NOT_FOUND);
		}
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
