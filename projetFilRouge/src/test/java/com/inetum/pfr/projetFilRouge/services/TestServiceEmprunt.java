package com.inetum.pfr.projetFilRouge.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.inetum.pfr.projetFilRouge.entity.Emprunt;
import com.inetum.pfr.projetFilRouge.entity.Emprunt.TypeEmprunt;

@SpringBootTest
@ActiveProfiles({"oracle"})
public class TestServiceEmprunt {
	
	Logger logger = LoggerFactory.getLogger(TestServiceEmprunt.class);
	
	@Autowired
	ServiceEmprunt serviceEmprunt;
	
	@Test
	public void testQueries() {

	
	Emprunt emprunt1 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF));
	Emprunt emprunt2 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.RESERVATION));
	Emprunt emprunt3 = serviceEmprunt.saveOrUpdate(new Emprunt(null, TypeEmprunt.EFFECTIF));
	
	assertTrue(serviceEmprunt.searchAll().size()== 3);

	}

}