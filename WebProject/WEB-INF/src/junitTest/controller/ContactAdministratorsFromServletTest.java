package junitTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ContactAdministratorsFromServlet;
import controller.ContactAdministratorsListServlet;
import model.LoginInfo;

class ContactAdministratorsFromServletTest {
	
	MockHttpServletRequest req ;
	MockHttpServletResponse resp ;
	ContactAdministratorsFromServlet target;
	
	@BeforeEach
	public void setUp() throws Exception {
		req = new MockHttpServletRequest();
		resp = new MockHttpServletResponse();
		target = new ContactAdministratorsFromServlet();
	}
	
	@Test
	@DisplayName("コンストラクタテスト")
	public void testCalc() {
		ContactAdministratorsListServlet testTarget = new ContactAdministratorsListServlet();
		assertNotNull(testTarget);
	}
	

	@Test
	@DisplayName("Postメソッド_パターン01_logininfoなし")
	public void testDoPost_001() throws ServletException, IOException {
		target.doPost(req, resp);
		HttpSession session = req.getSession();
		assertEquals("view/login.jsp", resp.getForwardedUrl());//遷移先
		assertEquals("セッションが切れました。再ログインをしてください。", session.getAttribute("errorMsg"));
	}

	
	@Test
	@DisplayName("Postメソッド_パターン02_logininfoあり")
	public void testDoPost_002() throws ServletException, IOException {
		LoginInfo li = new LoginInfo();
		HttpSession session = req.getSession();
		li.setName("渡辺颯汰");
		li.setEmployeeID(5);
		li.setPermissionLevel(5);
		session.setAttribute("logininfo", li);
		assertEquals("/view/myPage.jsp", resp.getForwardedUrl());//遷移先
		
	}
}
