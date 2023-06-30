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
import model.CommentAdminDAO;
import model.CommentAdminDTO;


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
	@DisplayName("Getメソッド")
	public void testDoGet_001() throws ServletException, IOException {
		target.doGet(req,resp);
		CommentAdminDAO caDAO = new CommentAdminDAO();
		CommentAdminDTO caDTO =caDAO.selectAllCommentAdmin();
		req.setAttribute("caDTOlist", caDTO);
		assertEquals(caDTO,req.getAttribute("caDTOlist"));
		
		assertEquals("/view/contactAdministratorsList.jsp", resp.getForwardedUrl());
	}
	
	
}