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
import model.ProfileBean;
import model.ProfileDAO;
import model.ProfileDTO;

/**
 * Servlet implementation class MyInfoUpDateServlet
 */
@WebServlet("/MyInfoUpDateServlet")
public class MyInfoUpDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoUpDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
 		
 		HttpSession session = request.getSession();
 		LoginInfo loginInfo = (LoginInfo)session.getAttribute("loginInfo");
 		
 		EmployeeBean eb = new EmployeeBean();
 		eb.setEmployeeID(loginInfo.getEmployeeID());
 		eb.setMailaddress(request.getParameter("mail"));
 		eb.setPassword(request.getParameter("pass"));
 		
 		ProfileBean pb = new ProfileBean();
 		pb.setEmployeeID(loginInfo.getEmployeeID());
 		pb.setAppeal(request.getParameter("appeal"));
 		
 		
 		EmployeeDAO edao = new EmployeeDAO();
 		int updateEmployeeflg = edao.selfUpdateInfo(eb, loginInfo);
 		
 		ProfileDAO pdao = new ProfileDAO();
 		int updateAppealflg = pdao.selfUpdateAppeal(pb, loginInfo);
 		
 		
 		ProfileDTO pdto = pdao.selectInfo(loginInfo);
		pdto = pdao.selectAppeal(pdto, loginInfo);
		
		request.setAttribute("pdto", pdto);

		String url;
 		if (updateEmployeeflg == 1 && updateAppealflg == 1) {
 			request.setAttribute("successMsg", "自己情報を更新しました");
 			url = "view/myPage.jsp";
 		}else {
 			request.setAttribute("errorMsg", "更新に失敗しました");
 			url = "view/myInfoUpdate.jsp";
 		}
 		
 		
 		
        //JSPへのフォワード処理
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
	}

}
