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
import model.EmployeeDTO;
import model.LoginInfo;

/**
 * Servlet implementation class EmployeesListServlet
 */
@WebServlet("/EmployeesListServlet")
public class EmployeesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    //protected void doGet(HttpServletRequest request, HttpServletResponse response)
			//throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	//}

    

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
//		引数の文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
 		
 		//HttpSessionリクエストを出し、ログインインフォの情報を取得
 		HttpSession session = request.getSession();
 		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
 		
 		
 		
// 		DAO宣言
// 		EmployeeテーブルのDAO「EmployeeDAO」のコンストラクタを実行
 		EmployeeDAO edao = new EmployeeDAO();
 		
// 		社員取得一覧情報をDTO(edto)にEmployeeDAOのselectAllメソッドの値を格納
 		EmployeeDTO edto = edao.selectAll(loginInfo);
 		
 		//リクエストスコープに結果格納
 		 request.setAttribute("edto",edto);
 		 
// 		JSPへのフォワード処理
        RequestDispatcher rd = request.getRequestDispatcher("/view/listEmployees.jsp");
        rd.forward(request, response);
	}
	

}
