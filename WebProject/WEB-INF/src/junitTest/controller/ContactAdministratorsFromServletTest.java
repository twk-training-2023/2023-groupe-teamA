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
import model.CommentAdminBean;
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
	public void testConstructor() {
		ContactAdministratorsFromServlet testTarget = new ContactAdministratorsFromServlet();
		assertNotNull(testTarget);
	}
	

	@Test
	@DisplayName("Postメソッド_パターン01_logininfoなし")
	public void testDoPost_001() throws ServletException, IOException {
		target.doPost(req, resp);
		assertEquals("view/login.jsp", resp.getForwardedUrl());//遷移先
		assertEquals("セッションが切れました。再ログインをしてください。", req.getAttribute("errorMsg"));
	}

	
	@Test
	@DisplayName("Postメソッド_パターン02_logininfoあり")
	public void testDoPost_002() throws ServletException, IOException {
		//logininfo処理
		LoginInfo loginInfo = new LoginInfo();
		HttpSession session = req.getSession();
		loginInfo.setName("なまえ");
		loginInfo.setEmployeeID(1);
		loginInfo.setPermissionLevel(5);
		
		CommentAdminBean caBean = new CommentAdminBean();
		
		caBean.setTitle("タイトル");
		caBean.setContent("本文");
		session.setAttribute("loginInfo", loginInfo);
		
		target.doPost(req, resp);
		
		//遷移先テスト
		assertEquals("/view/myPage.jsp", resp.getForwardedUrl());
		
		
	}
	

}
	
	

