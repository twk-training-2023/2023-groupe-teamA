package junitTest.controller;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.AddEmployeeServlet;
import model.LoginInfo;

public class AddEmployeeServletTest {

	MockHttpServletRequest req = new MockHttpServletRequest();
	MockHttpServletResponse resp = new MockHttpServletResponse();

	@Test
	public void test1()throws ServletException, IOException {
		//インスタンス化
		AddEmployeeServlet ae = new AddEmployeeServlet();
		//LoginInfoの値　ログイン想定して値入れる
		int employeeID = 52;//	社員番号
		String name = "いぬ";//	名前
		int permissionLevel = 5;//権限レベル
		//infoに格納
		LoginInfo info = new LoginInfo();
		info.setEmployeeID(employeeID);
		info.setName(name);
		info.setPermissionLevel(permissionLevel);
		//サーブレットで受け取る値入力
		HttpSession session = req.getSession();
		session.setAttribute("loginInfo",info );
		req.setParameter("name", "倉持翠");
		req.setParameter("mail","twk@twk.co.jp" );
		req.setParameter("password", "abc123");
		req.setParameter("level","5" );
		//メソッド読んで実行
		ae.doPost(req, resp);

		assertEquals("/view/administratorMenu.jsp", resp.getForwardedUrl());
	}

}

