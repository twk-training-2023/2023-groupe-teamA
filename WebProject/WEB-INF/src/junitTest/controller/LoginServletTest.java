package junitTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.LoginServlet;
import model.LoginInfo;

class LoginServletTest {
	
	MockHttpServletRequest request;
	MockHttpServletResponse response;
	LoginServlet servlet;

	@BeforeEach
	void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet = new LoginServlet();
	}
	
	@Test
	@DisplayName("認証成功時のテスト")
	void test1() throws ServletException, IOException {
		String url = "view/mainMenu.jsp";
		String mail = "kanato-momozaki@twk.co.jp";
		String pass = "a";
		LoginInfo loginInfo = setLoginInfo(4, "桃﨑奏斗", 5);
		request.setParameter("mail", mail);
		request.setParameter("password", pass);
		servlet.doPost(request,response);
		assertEquals(mail, request.getParameter("mail"));
		assertEquals(pass, request.getParameter("password"));
		checkLoginInfo(loginInfo, (LoginInfo)request.getSession().getAttribute("loginInfo"));
		assertEquals(url, response.getForwardedUrl());
	}

	@Test
	@DisplayName("認証失敗時のテスト")
	void test2() throws ServletException, IOException {
		String url = "view/login.jsp";
		String mail = "kanato-momozaki@twk.co.jp";
		String pass = "asd";
		String errorMsg = "サインイン失敗";
		request.setParameter("mail", mail);
		request.setParameter("password", pass);
		servlet.doPost(request,response);
		assertEquals(mail, request.getParameter("mail"));
		assertEquals(pass, request.getParameter("password"));
		assertEquals(errorMsg, request.getAttribute("errorMsg"));
		assertEquals(url, response.getForwardedUrl());
	}
	
	public LoginInfo setLoginInfo(int id, String name, int level) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setEmployeeID(id);
		loginInfo.setName(name);
		loginInfo.setPermissionLevel(level);
		return loginInfo;
	}
	
	public void checkLoginInfo(LoginInfo ans,LoginInfo loginInfo) {
		assertEquals(ans.getEmployeeID(), loginInfo.getEmployeeID());
		assertEquals(ans.getName(), loginInfo.getName());
		assertEquals(ans.getPermissionLevel(), loginInfo.getPermissionLevel());
	}
}
