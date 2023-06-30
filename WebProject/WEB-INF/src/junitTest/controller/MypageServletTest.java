package junitTest.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.MypageServlet;
import model.LoginInfo;

class MypageServletTest {

	MockHttpServletRequest req;
	MockHttpServletResponse resp;
	MypageServlet target;

	@BeforeEach
	public void setUp() throws Exception {
		req = new MockHttpServletRequest();
		resp = new MockHttpServletResponse();
		target = new MypageServlet();
	}

	@Test
	@DisplayName("コンストラクタテスト")
	public void SkillApprovalServlet() {
		MypageServletTest testTarget = new MypageServletTest();
		assertNotNull(testTarget);
	}

	@Test
	@DisplayName("Postメソッド_パターン01　loginInfo情報あり")
	public void testDoGet_001() throws ServletException, IOException {
		String url = "/view/myPage.jsp";
		HttpSession session = req.getSession();
		LoginInfo loginInfo = setLoginInfo(3, "唐澤崇仁", 5);
		session.setAttribute("loginInfo", loginInfo);
		target.doGet(req,resp);
		assertEquals(url, resp.getForwardedUrl());
	}

	@Test
	@DisplayName("Postメソッド_パターン02　loginInfo情報なし")
	public void testDoGet_002() throws ServletException, IOException {
		String url = "view/login.jsp";
		target.doGet(req,resp);
		assertEquals(url, resp.getForwardedUrl());
	}

	public LoginInfo setLoginInfo(int id, String name, int level) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setEmployeeID(id);
		loginInfo.setName(name);
		loginInfo.setPermissionLevel(level);
		return loginInfo;
	}
	
//	@Test
//	public void testDoPost_001() {
//		fail("まだ実装されていません"); // TODO
//	}

}