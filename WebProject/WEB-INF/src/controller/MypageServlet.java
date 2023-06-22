package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginInfo;

@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MypageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");

		if (loginInfo != null) {
			// ログイン情報がセッションに保存されている場合はマイページにフォワード
			RequestDispatcher rd = request.getRequestDispatcher("/view/myPage.jsp");
			rd.forward(request, response);
		} else {
			// ログインされていない場合はログイン画面にリダイレクト
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}
