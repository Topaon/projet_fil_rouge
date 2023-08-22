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

import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.entity.Livre;

@RestController
@RequestMapping(value = "/api-bibliotheque/livre", headers = "Accept=application/json")
public class LivreRestCtrl {

	@Autowired
	DaoLivre daoLivre;

	// READ
	// URL: ./api-bibliotheque/livre

	@GetMapping("")
	public List<Livre> getAllLivres() {
		return daoLivre.findAll();
	}

	// exemple d'URL: ./api-bibliotheque/livre/1
	// permet de trouver un livre avec son ID

	@GetMapping("/{livreId}")
	public ResponseEntity<Livre> getLivreById(@PathVariable("livreId") Long id) {
		Livre livre = daoLivre.findById(id).orElse(null);

		if (livre != null) {
			return new ResponseEntity<Livre>(livre, HttpStatus.OK);
		} else {
			return new ResponseEntity<Livre>(HttpStatus.NOT_FOUND);
		}
	}

	// CREATE
	// exemple d'URL: ./api-bibliotheque/livre
	// appelée en POST:
	// {"id" : null , "titre: "Les roses" , "auteur": "Didier", "editeur":
	// "Flamamrion", "dispo": true; "etat": "BON_ETAT"}

	@PostMapping
	public Livre postLivre(@RequestBody Livre nouveauLivre) {
		Livre livreStocke = daoLivre.save(nouveauLivre);
		return livreStocke;
	}

	// UPDATE
	// exemple d'URL: ./api-bibliotheque/livre
	// appelée en PUT:
	// {"id" : 1 , "titre: "Les bleuets" , "auteur": "Didier", "editeur":
	// "Flamamrion", "dispo": true; "etat": "MAUVAIS_ETAT"}

	@PutMapping
	public ResponseEntity<?> putCompte(@RequestBody Livre livre) {
		Long idLivreRecherche = livre.getId();
		Livre livreRecherche = daoLivre.findById(idLivreRecherche).orElse(null);

		if (livreRecherche == null) {
			return new ResponseEntity<String>("{\"err\" : \"livre non trouvé\"}", HttpStatus.NOT_FOUND);
		} else {
			daoLivre.save(livre);
			return new ResponseEntity<Livre>(livre, HttpStatus.OK);
		}

	}

	// DELETE
	// exemple d'URL: ./api-bibliotheque/livre/1
	// appelée en DELETE

	@DeleteMapping("/{livreId}")
	public ResponseEntity<?> deleteCompteById(@PathVariable("livreId") Long id) {
		Livre livreRecherche = daoLivre.findById(id).orElse(null);
		if (livreRecherche != null) {
			daoLivre.deleteById(id);
			return new ResponseEntity<String>("{ \"done\" : \"livre supprimé\"}", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"err\" : \"livre non trouvé\"}", HttpStatus.NOT_FOUND);
		}
	}

}
