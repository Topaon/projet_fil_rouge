package com.inetum.pfr.projetFilRouge.dao;

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
public class TestDaoEmprunt {
	
	Logger logger = LoggerFactory.getLogger(TestDaoEmprunt.class);
	
	@Autowired
	DaoEmprunt daoEmprunt;
	
	@Test
	public void testQueries() {

	
	Emprunt emprunt1 = daoEmprunt.insert(new Emprunt(null, TypeEmprunt.EFFECTIF));
	Emprunt emprunt2 = daoEmprunt.insert(new Emprunt(null, TypeEmprunt.RESERVATION));
	Emprunt emprunt3 = daoEmprunt.insert(new Emprunt(null, TypeEmprunt.EFFECTIF));
	
	assertTrue(daoEmprunt.findAll().size()== 3);
	


	}

}
