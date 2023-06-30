package junitTest.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.EmployeesListServlet;
import model.EmployeeBean;
import model.EmployeeDTO;
import model.LoginInfo;

public class EmployeesListServletTest {

	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();
	
	@Test
	public void test1()throws ServletException, IOException {
		//インスタンス化
		EmployeesListServlet ae = new EmployeesListServlet();
		//Login Infoの値　ログイン想定して値入れる
		int employeeID = 52;//	社員番号
		String name = "いぬ";//	名前
		int permissionLevel = 5;//権限レベル
		//info内に格納
		LoginInfo info = new LoginInfo();
		info.setEmployeeID(employeeID);
		info.setName(name);
		info.setPermissionLevel(permissionLevel);
		
		HttpSession session = req.getSession();
		session.setAttribute("loginInfo",info );
		//メソッド読んで実行
		ae.doGet(req, resp);
		//edtoを受け取る（リスト型で受け取る必要があるため）
		EmployeeDTO dto = (EmployeeDTO) req.getAttribute("edto");
		//リスト内の０番受け取ってBeanに保存
		EmployeeBean eb = dto.get(0);
		//正解データを受け取れているか確認
		assertEquals("石井佑樹", eb.getName());
		assertEquals("/view/listEmployees.jsp", resp.getForwardedUrl());
	}
}
