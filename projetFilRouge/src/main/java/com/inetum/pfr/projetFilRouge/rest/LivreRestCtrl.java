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

import com.inetum.pfr.projetFilRouge.dto.LivreDto;
import com.inetum.pfr.projetFilRouge.entity.Livre;
import com.inetum.pfr.projetFilRouge.services.ServiceLivre;

@RestController
@RequestMapping(value = "/api-bibliotheque/livre", headers = "Accept=application/json")
public class LivreRestCtrl {

	@Autowired
	ServiceLivre serviceLivre;

	// READ
	// URL: ./api-bibliotheque/livre

	@GetMapping("")
	public List<LivreDto> getAllLivres() {
		return serviceLivre.searchAllDto();
	}

	// exemple d'URL: ./api-bibliotheque/livre/1
	// permet de trouver un livre avec son ID

	@GetMapping("/{livreId}")
	public LivreDto getLivreById(@PathVariable("livreId") Long id) {
		return serviceLivre.searchDtoById(id);
//		return GenericConverter.map(livre, LivreDto.class);
	}

	// CREATE
	// exemple d'URL: ./api-bibliotheque/livre
	// appelée en POST:
	// {"id" : null , "titre: "Les roses" , "auteur": "Didier", "editeur":
	// "Flamamrion", "dispo": true; "etat": "BON_ETAT"}

	@PostMapping
	public Livre postLivre(@RequestBody Livre nouveauLivre) {
		Livre livreStocke = serviceLivre.saveOrUpdate(nouveauLivre);
		return livreStocke;
	}

	// UPDATE
	// exemple d'URL: ./api-bibliotheque/livre
	// appelée en PUT:
	// {"id" : 1 , "titre: "Les bleuets" , "auteur": "Didier", "editeur":
	// "Flamamrion", "dispo": true; "etat": "MAUVAIS_ETAT"}

	@PutMapping
	public ResponseEntity<?> putLivre(@RequestBody Livre livre) {
		Long idLivreRecherche = livre.getId();
		Livre livreRecherche = serviceLivre.searchById(idLivreRecherche);

		if (livreRecherche == null) {
			return new ResponseEntity<String>("{\"err\" : \"livre non trouvé\"}", HttpStatus.NOT_FOUND);
		} else {
			serviceLivre.saveOrUpdate(livre);
			return new ResponseEntity<Livre>(livre, HttpStatus.OK);
		}

	}

	// remove
	// exemple d'URL: ./api-bibliotheque/livre/1
	// appelée en remove

	@DeleteMapping("/{livreId}")
	public ResponseEntity<?> removeCompteById(@PathVariable("livreId") Long id) {
		Livre livreRecherche = serviceLivre.searchById(id);
		if (livreRecherche != null) {
			serviceLivre.removeById(id);
			return new ResponseEntity<String>("{ \"done\" : \"livre supprimé\"}", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("{ \"err\" : \"livre non trouvé\"}", HttpStatus.NOT_FOUND);
		}
	}

}
