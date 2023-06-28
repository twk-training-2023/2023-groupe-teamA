package junitTest.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.MyInfoUpDateMoveServlet;
import junitTest.model.ComparisonModel;
import junitTest.model.SetModel;
import model.LoginInfo;
import model.ProfileDTO;

class MyInfoUpDateMoveServletTest {

	
	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MyInfoUpDateMoveServlet servlet;

	@BeforeEach
	void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet = new MyInfoUpDateMoveServlet();
	}
	
	@Test
	@DisplayName("自己情報更新処理ページに遷移する時のテスト")
	void test1() throws ServletException, IOException {
		String url = "view/myInfoUpdate.jsp";
		List<List<String>> parameter = Arrays.asList(
				Arrays.asList("4","kanato-momozaki@twk.co.jp","a","桃﨑奏斗","入力がありません。"));
		HttpSession session = request.getSession();
		SetModel setmodel = new SetModel();
		ProfileDTO pdto = setmodel.setProfileDTO(parameter);
		int id = 4;
		String name = "桃﨑奏斗";
		int level = 5;
		LoginInfo loginInfo = setmodel.setLoginInfo(id, name, level);
		session.setAttribute("loginInfo", loginInfo);
		servlet.doGet(request,response);
		assertEquals(loginInfo, (LoginInfo)session.getAttribute("loginInfo"));
		ComparisonModel compar = new ComparisonModel();
		compar.ComparisonProfileDTO(pdto, (ProfileDTO)request.getAttribute("pdto"));
		assertEquals(url, response.getForwardedUrl());
	}
	
	@Test
	@DisplayName("sessionスコープのloginInfoがnullの場合")
	void test2() throws ServletException, IOException {
		String url = "view/login.jsp";
		servlet.doGet(request, response);
		assertEquals(url, response.getForwardedUrl());
	}
}
