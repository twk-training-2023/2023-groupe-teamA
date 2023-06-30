package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentAdminDAO;
import model.CommentAdminDTO;

/**
 * Servlet implementation class ContactAdministratorsListServlet
 */
@WebServlet("/ContactAdministratorsListServlet")
public class ContactAdministratorsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContactAdministratorsListServlet() {
      super();
    }

	//doGetに処理を移行済み
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html; charset=UTF-8");
//		
//		//CommentAdminBean caBean = new CommentAdminBean();
//		CommentAdminDAO caDAO = new CommentAdminDAO();
//		//CommentAdminDTO caDTO = ↓
//		CommentAdminDTO caDTO =caDAO.selectAllCommentAdmin();
//		//request.setAttribute("commentAdmin",caDTO);
//		
//		//int i =4;
//		//caBean = caDTO.get(i);
//		//System.out.println(caBean.getName());
//		//System.out.println(caBean.getTitle());
//		request.setAttribute("caDTOlist", caDTO);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/view/contactAdministratorsList.jsp");
//	    rd.forward(request, response);
//	    
//	    System.out.println(caDTO.size());
//	    CommentAdminBean caBean = caDTO.get(3);
//	     //caBean = caDTO.get(4);
//	     System.out.println(caBean.getTitle());
//	     System.out.println(caBean.getCommentNumber());
//	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		CommentAdminDAO caDAO = new CommentAdminDAO();
		CommentAdminDTO caDTO =caDAO.selectAllCommentAdmin();
		request.setAttribute("caDTOlist", caDTO);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/contactAdministratorsList.jsp");
	    rd.forward(request, response);
	}

}
