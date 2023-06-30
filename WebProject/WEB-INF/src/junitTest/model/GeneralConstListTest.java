package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.GeneralConstList;

class GeneralConstListTest {
	private final String GENERAL_URL = "jdbc:postgresql://localhost:5432/teambdb";
	private final String GENERAL_USER = "general";
	private final String GENERAL_PASS = "twkgeneral";
		
	GeneralConstList generalConPara;

	@BeforeEach
	void setup() {
		generalConPara = new GeneralConstList();
	}
	
	@Test
	void testGetUrl() {
		assertEquals(GENERAL_URL, generalConPara.getUrl());
	}

	@Test
	void testGetUser() {
		assertEquals(GENERAL_USER, generalConPara.getUser());
	}

	@Test
	void testGetPass() {
		assertEquals(GENERAL_PASS, generalConPara.getPass());
	}

}
