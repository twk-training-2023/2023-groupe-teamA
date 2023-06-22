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
import model.ProfileDAO;
import model.ProfileDTO;

/**
 * Servlet implementation class MyInfoUpDateMoveServlet
 */
@WebServlet("/MyInfoUpDateMoveServlet")
public class MyInfoUpDateMoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoUpDateMoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		文字コードの設定
//		引数の文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
 		
 		HttpSession session = request.getSession();
 		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");

 		ProfileDAO pdao = new ProfileDAO();
 		
 		ProfileDTO pdto = pdao.selectInfo(loginInfo);
 		pdto = pdao.selectAppeal(pdto, loginInfo);
 		
 		request.setAttribute("pdto", pdto);
 		
        RequestDispatcher rd = request.getRequestDispatcher("view/myInfoUpdate.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
