package com.inetum.pfr.projetFilRouge.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Personne;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestDaoPersonne {
	
	@Autowired
	DaoPersonne daoPersonne;
	
	@Test
	public void testQueries() {
		Personne pers1 = daoPersonne.insert(new Personne(null, "Granier", "Simon", "simon.granier@sfr.fr", "Fontenay-aux-Roses"));
		Personne pers2 = daoPersonne.insert(new Personne(null, "Prosic", "Mathieu", "mathieu.prosic@orange.com", "Neuville-sur-Oise"));
		Personne pers3 = daoPersonne.insert(new Personne(null, "Clément", "Antoine", "antoine.clement@free.fr", "Stockholm"));
		
		assertEquals(daoPersonne.findById(pers1.getId()).getAdresse(), "Fontenay-aux-Roses");
		
		assertTrue(daoPersonne.findAll().size() == 3);
		
		pers2.setAdresse("Madrid");
		daoPersonne.update(pers2);
		assertEquals(daoPersonne.findById(pers2.getId()).getAdresse(), "Madrid");	
		
		daoPersonne.deleteById(pers3.getId());
		assertTrue(daoPersonne.findAll().size() == 2);
	}
}