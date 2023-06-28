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

import controller.MyInfoUpDateServlet;
import junitTest.model.ComparisonModel;
import junitTest.model.SetModel;
import model.LoginInfo;
import model.ProfileDTO;

class MyInfoUpDateServletTest {

	MockHttpServletRequest request;
	MockHttpServletResponse response;
	MyInfoUpDateServlet servlet;

	@BeforeEach
	void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		servlet = new MyInfoUpDateServlet();
	}
	
	@Test
	@DisplayName("自己情報更新処理のテスト(更新成功時)")
	void test1() throws ServletException, IOException {
		String url = "view/myPage.jsp";
		String successMsg = "自己情報を更新しました";
		int id = 4;
		String mail = "kanato-momozaki@twk.co.jp";
		String pass = "a";
		String name = "桃﨑奏斗";
		String appeal = "入力がありません。";
		int level = 5;
		List<List<String>> parameter = Arrays.asList(
				Arrays.asList(String.valueOf(id), mail, pass, name, appeal));
		SetModel setmodel = new SetModel();
		ProfileDTO pdto = setmodel.setProfileDTO(parameter);
		LoginInfo loginInfo = setmodel.setLoginInfo(id, name, level);
		HttpSession session = request.getSession();
		request.setParameter("mail", mail);
		request.setParameter("pass", pass);
		request.setParameter("appeal", appeal);
		session.setAttribute("loginInfo", loginInfo);
		servlet.doPost(request,response);
		assertEquals(mail, request.getParameter("mail"));
		assertEquals(pass, request.getParameter("pass"));
		assertEquals(appeal, request.getParameter("appeal"));
		assertEquals(loginInfo, (LoginInfo)session.getAttribute("loginInfo"));
		ComparisonModel compar = new ComparisonModel();
		compar.ComparisonProfileDTO(pdto, (ProfileDTO)request.getAttribute("pdto"));
		assertEquals(successMsg, (String)request.getAttribute("successMsg"));
		assertEquals(url, response.getForwardedUrl());
	}
	
	@Test
	@DisplayName("自己情報更新処理のテスト(変更メールアドレスがすでにテーブルにあった場合)")
	void test2() throws ServletException, IOException {
		String url = "view/myInfoUpdate.jsp";
		String errorMsg = "更新に失敗しました";
		int id = 4;
		String inputmail = "yuki-ishii@twk.co.jp";
		String ansmail = "kanato-momozaki@twk.co.jp";
		String pass = "a";
		String name = "桃﨑奏斗";
		String appeal = "入力がありません。";
		int level = 5;
		List<List<String>> parameter = Arrays.asList(
				Arrays.asList(String.valueOf(id), ansmail, pass, name, appeal));
		SetModel setmodel = new SetModel();
		ProfileDTO pdto = setmodel.setProfileDTO(parameter);
		LoginInfo loginInfo = setmodel.setLoginInfo(id, name, level);
		HttpSession session = request.getSession();
		request.setParameter("mail", inputmail);
		request.setParameter("pass", pass);
		request.setParameter("appeal", appeal);
		session.setAttribute("loginInfo", loginInfo);
		servlet.doPost(request,response);
		assertEquals(inputmail, request.getParameter("mail"));
		assertEquals(pass, request.getParameter("pass"));
		assertEquals(appeal, request.getParameter("appeal"));
		assertEquals(loginInfo, (LoginInfo)session.getAttribute("loginInfo"));
		ComparisonModel compar = new ComparisonModel();
		compar.ComparisonProfileDTO(pdto, (ProfileDTO)request.getAttribute("pdto"));
		assertEquals(errorMsg, (String)request.getAttribute("errorMsg"));
		assertEquals(url, response.getForwardedUrl());
	}
	
	@Test
	@DisplayName("自己情報更新処理のテスト(アピールの入力がない場合)")
	void test3() throws ServletException, IOException {
		String url = "view/myInfoUpdate.jsp";
		String errorMsg = "更新に失敗しました";
		int id = 4;
		String mail = "kanato-momozaki@twk.co.jp";
		String pass = "a";
		String name = "桃﨑奏斗";
		String inputappeal = null;
		String ansappeal = "入力がありません。";
		int level = 5;
		List<List<String>> parameter = Arrays.asList(
				Arrays.asList(String.valueOf(id), mail, pass, name, ansappeal));
		SetModel setmodel = new SetModel();
		ProfileDTO pdto = setmodel.setProfileDTO(parameter);
		LoginInfo loginInfo = setmodel.setLoginInfo(id, name, level);
		HttpSession session = request.getSession();
		request.setParameter("mail", mail);
		request.setParameter("pass", pass);
		request.setParameter("appeal", inputappeal);
		session.setAttribute("loginInfo", loginInfo);
		servlet.doPost(request,response);
		assertEquals(mail, request.getParameter("mail"));
		assertEquals(pass, request.getParameter("pass"));
		assertEquals(inputappeal, request.getParameter("appeal"));
		assertEquals(loginInfo, (LoginInfo)session.getAttribute("loginInfo"));
		ComparisonModel compar = new ComparisonModel();
		compar.ComparisonProfileDTO(pdto, (ProfileDTO)request.getAttribute("pdto"));
		assertEquals(errorMsg, (String)request.getAttribute("errorMsg"));
		assertEquals(url, response.getForwardedUrl());
	}
	
	@Test
	@DisplayName("sessionスコープのloginInfoがnullの場合")
	void test4() throws ServletException, IOException {
		String url = "view/login.jsp";
		servlet.doPost(request, response);
		assertEquals(url, response.getForwardedUrl());
	}
}
