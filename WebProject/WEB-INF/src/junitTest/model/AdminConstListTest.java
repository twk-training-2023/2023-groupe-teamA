package junitTest.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.AdminConstList;

class AdminConstListTest {
	private final String ANSWER_URL = "jdbc:postgresql://localhost:5432/teambdb";
	private final String ANSWER_USER = "administrator";
	private final String ANSWER_PASS = "twkadmin";
	
	AdminConstList adminConPara;

	@BeforeEach
	void setup() {
		adminConPara = new AdminConstList();
	}
	
	
	@Test
	void testGetUrl() {
		assertEquals(ANSWER_URL, adminConPara.getUrl());
	}

	@Test
	void testGetUser() {
		assertEquals(ANSWER_USER, adminConPara.getUser());
	}

	@Test
	void testGetPass() {
		assertEquals(ANSWER_PASS, adminConPara.getPass());
	}

}
