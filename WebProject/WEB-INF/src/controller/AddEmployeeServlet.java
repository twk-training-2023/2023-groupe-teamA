package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeeBean;
import model.EmployeeDAO;
import model.EmployeeDTO;
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
		
		String url = "";
		if (loginInfo == null) {
			request.setAttribute("errorMsg", "セッションが切れました。再ログインをしてください。");
			url = "view/login.jsp";
		} else {
 		
			
			EmployeeBean eb = new EmployeeBean();
			// フォームの値を受け取る
			eb.setName(request.getParameter("name"));
			eb.setMailaddress(request.getParameter("mail"));
			eb.setPassword(request.getParameter("password"));
			eb.setPermissionLevel(Integer.parseInt(request.getParameter("level")));
			
			EmployeeDTO edto = new EmployeeDTO();
			
			edto.add(eb);
	
			// インスタンス（edao）生成
			EmployeeDAO edao = new EmployeeDAO();
			
			boolean result = false;
			
			try {
				result = edao.insertEmployee(edto, loginInfo);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	//
	//		//インスタンスメソッドにアクセス
	//		edao.addEmployee(name,mail,password,level,loginInfo);
	//		
	//		//結果表示
	//		int result = edao.addEmployee(name,mail,password,level,loginInfo);
			if(result) {
				request.setAttribute("successMsg", "社員情報を登録しました。");
				url = "view/addEmployee.jsp";
			}else {
				request.setAttribute("errorMsg", "登録に失敗しました。");
				url = "view/addEmployee.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
