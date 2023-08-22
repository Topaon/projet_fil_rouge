package com.inetum.pfr.projetFilRouge.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Personne;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServicePersonne {
	
	@Autowired
	ServicePersonne servicePersonne;
	
	@Test
	public void testQueries() {
		Personne pers1 = servicePersonne.saveOrUpdate(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne pers2 = servicePersonne.saveOrUpdate(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne pers3 = servicePersonne.saveOrUpdate(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
		assertEquals(servicePersonne.searchById(pers1.getId()).getAdresse(), "Fontenay-aux-Roses");
		
		assertTrue(servicePersonne.searchAll().size() == 3);
		
		pers2.setAdresse("Madrid");
		servicePersonne.saveOrUpdate(pers2);
		assertEquals(servicePersonne.searchById(pers2.getId()).getAdresse(), "Madrid");	
		
		servicePersonne.removeById(pers3.getId());
		assertTrue(servicePersonne.searchAll().size() == 2);
	}
}