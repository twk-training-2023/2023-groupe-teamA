package junitTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.AddCsvEmployeeServlet;

class AddCsvEmployeeServletTest {

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	AddCsvEmployeeServlet servlet;


	@BeforeEach
	void setup() throws IOException {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet = new AddCsvEmployeeServlet();
	}
	
//	@Test
//	@DisplayName("CSVファイルでの社員追加処理のテスト")
//	void test1() throws ServletException, IOException {
//		String url = "view/login.jsp";
//		HttpSession session = request.getSession();
//		LoginInfo loginInfo = setLoginInfo(1, "桃﨑", 5);
//		session.setAttribute("loginInfo", loginInfo);
//		System.out.println("--------");
//		System.out.println(mockFile.isEmpty());
//		servlet.doPost(request, response);
//	}

	@Test
	@DisplayName("sessionスコープのloginInfoがnullの場合")
	void test2() throws ServletException, IOException {
		String url = "view/login.jsp";
		servlet.doPost(request, response);
		assertEquals(url, response.getForwardedUrl());
	}
}
