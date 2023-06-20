package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EmployeeBean;
import model.EmployeeDAO;
import model.LoginInfo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		文字コードの設定
//		引数の文字コードをUTF-8に設定
		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
 		

//		Bean宣言
//		社員情報テーブルのBean「EmployeeBean」のコンストラクタを実行
 		EmployeeBean eb = new EmployeeBean();
 		
// 		パラメータの取得
// 		引数のrequestから"mail"をキーに、メールアドレスを取得しBeanにsetterメソッドで格納
 		String mail = request.getParameter("mail");
 		eb.setMailaddress(mail);
// 		引数のrequestから"password"をキーに、パスワードを取得しBeanにsetterメソッドで格納
 		String pass = request.getParameter("password");
 		eb.setPassword(pass);
 		
// 		DAO宣言
// 		EmployeeテーブルのDAO「EmployeeDAO」のコンストラクタを実行
 		EmployeeDAO edao = new EmployeeDAO();
 		
// 		社員情報の確認
// 		「EmployeeDAO.searchToLogin」メソッドによりEmployeeテーブルを検索
 		LoginInfo loginInfo = edao.selectCheckPass(eb);
 		
 		String url;
 		HttpSession session = request.getSession();
 		
// 		取得結果判定
// 		処理で取得した結果で条件分岐
 		
 		if (loginInfo != null) {
// 			ログイン認証完了
// 			sessionスコープにログイン情報クラス「LoginInfo」を保存
// 			メニュー画面のJSP＜mainMenu.jsp＞にフォワードする
 			if (loginInfo.getPermissionLevel() > 3) {
 				String adminMenuLink = "<a href=\"" + request.getContextPath() + "/view/administratorMenu.jsp\">管理者メニュー</a>";
 				request.setAttribute("adminMenuLink", adminMenuLink);
 			}
 			session.setAttribute("loginInfo", loginInfo);
 			url = "view/mainMenu.jsp";
 		}else {
// 			ログイン認証失敗
// 			requestスコープにエラーメッセージを保存
// 			ログイン画面のJSP＜login.jsp＞にフォワードログイン失敗
 			request.setAttribute("errorMsg", "サインイン失敗");
 			url = "view/login.jsp";
 		}
 		
        //JSPへのフォワード処理
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
