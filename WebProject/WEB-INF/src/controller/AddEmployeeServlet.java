package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeeDAO;
import model.LoginInfo;


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


	// @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)


	// @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Jspのフォーム画面から検索対象ユーザID取得
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");

		// フォームの値を受け取る
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");	
		String password = request.getParameter("password");
		int level = Integer.parseInt(request.getParameter("level"));

		// インスタンス（edao）生成
		EmployeeDAO edao = new EmployeeDAO();


		//インスタンスメソッドにアクセス
		edao.addEmployee(name,mail,password,level,loginInfo);
		
		//結果表示
			RequestDispatcher rd = request.getRequestDispatcher("/view/administratorMenu.jsp");

			rd.forward(request, response);


		}

	}
