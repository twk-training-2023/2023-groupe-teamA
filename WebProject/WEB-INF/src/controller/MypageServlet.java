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

		//ProfileBean pb = new ProfileBean();
		HttpSession session = request.getSession();
		//LoginInfo logininfo = (LoginInfo) session.getAttribute("logininfo");
		//int employeeID = logininfo.getEmployeeID();
 		//pb.setEmployeeID(employeeID);
		
		//ProfileDAO pdao = new ProfileDAO();
		
		//ProfileDTO profiledto = pdao.selectAppeal(pb);
		
		//request.setAttribute("profiledto", profiledto);
		
		//桃崎くんがProfileBeanに修正を入れてくれるまでは放置。
		
						
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
