package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeDAO;


/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Jspのフォーム画面から検索対象ユーザID取得
		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
		
		// フォームの値を受け取る
        int number = Integer.parseInt(request.getParameter("number"));
        String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        int level = Integer.parseInt(request.getParameter("level"));
		
        // データベースに登録する
        EmployeeDAO edao = new EmployeeDAO();
       
        int result = edao.addEmployee(number,name,mail,password,level);
        	if(result == 5) {
        		
        		RequestDispatcher rd = request.getRequestDispatcher("/view/addEmployee.jsp");
                rd.forward(request, response);
        	}
    }
}


