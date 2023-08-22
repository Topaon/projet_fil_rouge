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

import com.inetum.pfr.projetFilRouge.dao.DaoPersonne;
import com.inetum.pfr.projetFilRouge.entity.Personne;

@RestController
@RequestMapping(value = "/api-bibliotheque/personne", headers = "Accept=application/json")
public class PersonneRestCtrl {

	@Autowired
	DaoPersonne daoPersonne;

	// READ
	// URL: ./api-bibliotheque/Personne

	@GetMapping("")
	public List<Personne> getAllPersonnes() {
		return daoPersonne.findAll();
	}

	// exemple d'URL: ./api-bibliotheque/personne/1
	// permet de trouver une personne avec son ID

	@GetMapping("/{PersonneId}")
	public ResponseEntity<?> getPersonneById(@PathVariable("PersonneId") Long id) {
		Personne Personne = daoPersonne.findById(id).orElse(null);

		if (Personne != null) {
			return new ResponseEntity<Personne>(Personne, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Personne nom trouvée", HttpStatus.NOT_FOUND);
		}
	}

	// CREATE
	// exemple d'URL: ./api-bibliotheque/personne
	// appelée en POST:
	// {"id" : null , "nom: "Dupont" , "prenom": "Michel", "email":
	// "michel.dupont@sfr.fr", "adresse": "Paris"}

	@PostMapping("")
	public Personne postPersonne(@RequestBody Personne nouveauPersonne) {
		Personne PersonneStocke = daoPersonne.save(nouveauPersonne);
		return PersonneStocke;
	}

	// UPDATE
	// exemple d'URL: ./api-bibliotheque/personne
	// appelée en PUT:
	// {"id" : 1 , "nom: "Dupont" , "prenom": "Michel", "email":
	// "michel.dupont@sfr.fr", "adresse": "Lyon"}

	@PutMapping
	public ResponseEntity<?> putCompte(@RequestBody Personne Personne) {
		Long idPersonneRecherche = Personne.getId();
		Personne PersonneRecherche = daoPersonne.findById(idPersonneRecherche).orElse(null);

		if (PersonneRecherche == null) {
			return new ResponseEntity<String>("{\"err\" : \"Personne non trouvé\"}", HttpStatus.NOT_FOUND);
		} else {
			daoPersonne.save(Personne);
			return new ResponseEntity<Personne>(Personne, HttpStatus.OK);
		}

	}

	// DELETE
	// exemple d'URL: ./api-bibliotheque/personne/1
	// appelée en DELETE

	@DeleteMapping("/{PersonneId}")
	public ResponseEntity<?> deleteCompteById(@PathVariable("PersonneId") Long id) {
		Personne PersonneRecherche = daoPersonne.findById(id).orElse(null);
		if (PersonneRecherche != null) {
			daoPersonne.deleteById(id);
			return new ResponseEntity<String>("{ \"done\" : \"Personne supprimé\"}", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"err\" : \"Personne non trouvé\"}", HttpStatus.NOT_FOUND);
		}
	}
}
