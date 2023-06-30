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

import controller.LogoutServlet;
import model.LoginInfo;

class LogoutServletTest {
	
	MockHttpServletRequest request;
	MockHttpServletResponse response;
	LogoutServlet servlet;

	@BeforeEach
	void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet = new LogoutServlet();
	}
	
	@Test
	@DisplayName("ログアウト処理のテスト(sessionがnullじゃない時)")
	void test1() throws ServletException, IOException {
		String url = "view/login.jsp";
		HttpSession session = request.getSession();
		LoginInfo loginInfo = setLoginInfo(1, "桃﨑", 5);
		session.setAttribute("loginInfo", loginInfo);
		servlet.doGet(request,response);
		assertEquals(url, response.getForwardedUrl());
	}
	
	@Test
	@DisplayName("ログアウト処理のテスト(sessionがnullの時)")
	void test2() throws ServletException, IOException {
		String url = "view/login.jsp";
		servlet.doGet(request,response);
		assertEquals(url, response.getForwardedUrl());
	}
	

	public LoginInfo setLoginInfo(int id, String name, int level) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setEmployeeID(id);
		loginInfo.setName(name);
		loginInfo.setPermissionLevel(level);
		return loginInfo;
	}
	
	
}
