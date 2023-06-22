package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentAdminBean;
import model.CommentAdminDAO;
import model.LoginInfo;

/**
 * Servlet implementation class ContactAdministratorsFromServlet
 */
@WebServlet("/ContactAdministratorsFromServlet")
public class ContactAdministratorsFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L ;
	
    public ContactAdministratorsFromServlet() {
       super();
    }
    //未完成
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		
		CommentAdminBean caBean = new CommentAdminBean();
		
		String title = request.getParameter("title");
	    caBean.setTitle(title);
		String content =request.getParameter("content");
		caBean.setContent(content);
		
		
		CommentAdminDAO caDAO = new CommentAdminDAO();
		caDAO.insertCommentAdmin(caBean,loginInfo);
		
		RequestDispatcher dis = request.getRequestDispatcher("/view/myPage.jsp");
		dis.forward(request,response);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
