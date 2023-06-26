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
import model.ProfileBean;
import model.ProfileDAO;
import model.ProfileDTO;

@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MypageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfileBean pb = new ProfileBean();
		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String url = "";
		if (loginInfo == null) {
 			request.setAttribute("errorMsg", "セッションが切れました。再ログインをしてください。");
 			url = "view/login.jsp";
		}else {
			int employeeID = loginInfo.getEmployeeID();
	 		pb.setEmployeeID(employeeID);
			
			ProfileDAO pdao = new ProfileDAO();
			
			ProfileDTO profiledto = pdao.selectInfo(pb);
			
			request.setAttribute("pdto", profiledto);
			
			url = "/view/myPage.jsp";
		}
		
		// ログイン情報がセッションに保存されている場合はマイページにフォワード
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
