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

import controller.SkillApprovalServlet;
import model.LoginInfo;

class SkillApprovalServletTest {
	
	MockHttpServletRequest req;
	MockHttpServletResponse resp;
	SkillApprovalServlet target;
    
	@BeforeEach
	public void setUp() throws Exception {
		req = new MockHttpServletRequest();
		resp = new MockHttpServletResponse();
		target = new SkillApprovalServlet();
	}
	
	//@Mock
	//private SkillAppealDAO mockSADAO = new SkillAppealDAO(); 
		
	@Test
	@DisplayName("コンストラクタテスト")
	public void SkillApprovalServlet() {
		SkillApprovalServlet testTarget = new SkillApprovalServlet();
		assertNotNull(testTarget);
	}
	
	@Test
	@DisplayName("Getメソッド")
	public void testDoGet() throws ServletException, IOException {
    }
	
	@Test
	@DisplayName("Getメソッド_パターン01　loginInfo情報あり success")
	public void testDoGet_001() throws ServletException, IOException {
		String url = "view/myPage.jsp";
		String skill_detail = "すごい";
		String skill_name = "Java";
		
		HttpSession session = req.getSession();
		LoginInfo loginInfo = setLoginInfo(3, "唐澤崇仁", 5);
		session.setAttribute("loginInfo", loginInfo);
		req.setParameter("skill_detail", skill_detail);
		req.setParameter("skill_name", skill_name);
		target.doPost(req,resp);		
		//when(skillAppealDAO.insertSkillRequest(employeeBean, name, skill_name, skill_detail, status)).thenReturn(success));
		assertEquals(skill_detail, req.getParameter("skill_detail"));
		assertEquals(skill_name, req.getParameter("skill_name"));
		assertEquals(url, resp.getForwardedUrl());
	}
	
	
	
	@Test
	@DisplayName("Getメソッド_パターン02　loginInfo情報あり false")
	public void testDoGet_004() throws ServletException, IOException {
		String url = "view/addSkillApply.jsp";
		String skill_detail = null;
		String skill_name = "Java";
		
		HttpSession session = req.getSession();
		LoginInfo loginInfo = setLoginInfo(3, "唐澤崇仁", 5);
		session.setAttribute("loginInfo", loginInfo);
		req.setParameter("skill_detail", skill_detail);
		req.setParameter("skill_name", skill_name);
		target.doPost(req,resp);
		//when(skillAppealDAO.insertSkillRequest(employeeBean, name, skill_name, skill_detail, status)).thenReturn(success));
		assertEquals(null, req.getParameter("skill_detail"));
		assertEquals(skill_name, req.getParameter("skill_name"));
		assertEquals(url, resp.getForwardedUrl());
	}
	
	@Test
	@DisplayName("Postメソッド_パターン02 loginInfo情報なし")
	public void testDoGet_003() throws ServletException, IOException {
		String url = "view/login.jsp";
		target.doPost(req,resp);
		assertEquals(url, resp.getForwardedUrl());
	}

	public LoginInfo setLoginInfo(int id, String name, int level) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setEmployeeID(id);
		loginInfo.setName(name);
		loginInfo.setPermissionLevel(level);
		return loginInfo;
	}
	
}

