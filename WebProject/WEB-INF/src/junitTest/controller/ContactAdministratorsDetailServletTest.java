package junitTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import controller.ContactAdministratorsDetailServlet;

class ContactAdministratorsDetailServletTest {

	@Test
	@DisplayName("コンストラクタテスト")
	public void testConstructor() {
		ContactAdministratorsDetailServlet testTarget = new ContactAdministratorsDetailServlet();
		assertNotNull(testTarget);
	}
}
