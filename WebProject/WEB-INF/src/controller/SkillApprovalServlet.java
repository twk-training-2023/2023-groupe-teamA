package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeeBean;
import model.LoginInfo;
import model.SkillAppealDAO;

@WebServlet("/SkillApprovalServlet")
public class SkillApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SkillApprovalServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");

		if (loginInfo != null) {
			int employeeID = loginInfo.getEmployeeID();
			String name = loginInfo.getName();
			String skill_detail = request.getParameter("skill_detail");
			String skill_name = request.getParameter("skill_name");
			int status = 1;

			EmployeeBean employeeBean = new EmployeeBean();
			employeeBean.setEmployeeID(employeeID);
			employeeBean.setName(name);

			SkillAppealDAO skillAppealDAO = new SkillAppealDAO();
			boolean success = skillAppealDAO.insertSkillRequest(employeeBean, skill_detail, name, skill_name, status);

			if (success) {
				// スキル申請成功時の処理
				response.getWriter().println("スキル申請が成功しました。");
			} else {
				// スキル申請失敗時の処理
				response.getWriter().println("スキル申請に失敗しました。");
			}
		} else {
			response.getWriter().println("ログインしていません。");
		}
	}
}
