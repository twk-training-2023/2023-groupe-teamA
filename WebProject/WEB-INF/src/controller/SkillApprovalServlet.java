package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SkillAppealDAO;

public class SkillApplicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employeeNumber = request.getParameter("employeeNumber");
		String skill = request.getParameter("skill");
		// DAOを使用してデータベースにインサートする処理を実装する
		SkillAppealDAO.insertSkill(employeeNumber, skill);
		// 成功した場合はマイページにリダイレクトする
		response.sendRedirect("mypage.jsp");
	}
}
