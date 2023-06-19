package controller;

 

import java.io.IOException;

 

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

 

public class MypageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");

        // DAOを使用してデータベースから該当の社員情報を取得する

        Employee employee = EmployeeDAO.getEmployeeByUsername(username);

        // マイページのJSPに社員情報を渡して表示する

        request.setAttribute("employee", employee);

        request.getRequestDispatcher("myPage.jsp").forward(request, response);

    }

}

 