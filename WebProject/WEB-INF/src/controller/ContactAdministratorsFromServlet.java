package controller;

import java.io.IOException;

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
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CommentAdminBean caBean = new CommentAdminBean();
		//String employeeID
		String title = request.getParameter("title");
		caBean.setTitle(title);
		String content =request.getParameter("content");
		caBean.setContent(content);
		int ID = request.getParameter("employeeID");
		caBean.setEmployeeID(ID);
		
		CommentAdminDAO caDAO = new CommentAdminDAO();
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
	}

}
