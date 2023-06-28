package junitTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ContactAdministratorsListServlet;


class ContactAdministratorsListServletTest {

	MockHttpServletRequest req ;
	MockHttpServletResponse resp ;
	ContactAdministratorsListServlet target;
	
	@BeforeEach
	public void setUp() throws Exception {
		req = new MockHttpServletRequest();
		resp = new MockHttpServletResponse();
		target = new ContactAdministratorsListServlet();
	}
	
	@Test
	@DisplayName("コンストラクタテスト")
	public void testCalc() {
		ContactAdministratorsListServlet testTarget = new ContactAdministratorsListServlet();
		assertNotNull(testTarget);
	}

	@Test
	@DisplayName("Postメソッド_パターン01_入力なし")
	public void testDoPost_001() throws ServletException, IOException {
		//target.doPost();
//		CommentAdminDAO caDAO = new CommentAdminDAO();
//		CommentAdminDTO caDTO =caDAO.selectAllCommentAdmin();
//		assertEquals("リクエスト：テスト",caDTO,req.getAttribute("caDTOlist"));
		
		assertEquals("/view/contactAdministratorsList.jsp", resp.getForwardedUrl());
	}
	
	
}