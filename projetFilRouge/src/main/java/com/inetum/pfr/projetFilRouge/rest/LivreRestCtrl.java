package com.inetum.pfr.projetFilRouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inetum.pfr.projetFilRouge.dao.DaoLivre;
import com.inetum.pfr.projetFilRouge.entity.Livre;

@RestController
@RequestMapping(value = "/api-pfr/pfr", headers="Accept=application/json")
public class LivreRestCtrl {
	
	@Autowired
	DaoLivre daoLivre;
	
	@GetMapping("")
	public List<Livre> getAllLivres() {
		return daoLivre.findAll();
	}
	
}
