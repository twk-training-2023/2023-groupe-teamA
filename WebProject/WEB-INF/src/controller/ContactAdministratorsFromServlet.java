package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentAdminBean;
import model.CommentAdminDAO;

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
		CommentAdminBean caBean = new CommentAdminBean();
		
		String title = request.getParameter("title");
	    caBean.setTitle(title);
		String content =request.getParameter("content");
		caBean.setContent(content);
		
		
		CommentAdminDAO caDAO = new CommentAdminDAO();
		caDAO.insertCommentAdmin(caBean);
		
		RequestDispatcher dis = request.getRequestDispatcher("/view/myPage.jsp");
		dis.forward(request,response);
			System.out.println("sev3 "+caBean.getTitle());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
