<%@ page pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<jsp:useBean id="loginInfo" scope="session" class="model.LoginInfo" />
<%
String employeeName = loginInfo.getName();
if (employeeName == null){
	request.setAttribute("errorMsg", "セッションが切れました。再ログインをしてください。");
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
}
%>
<hr>
<div class="parent">
	| <a href="<%=request.getContextPath()%>/view/mainMenu.jsp">メインメニュー</a> 
	| <a href="<%=request.getContextPath()%>/MypageServlet">マイページ</a>
	<%if (loginInfo.getPermissionLevel() > 3){ %>| <a href="<%=request.getContextPath()%>/view/administratorMenu.jsp">管理者メニュー</a><%} %>
	| <a href="<%=request.getContextPath()%>/LogoutServlet">ログアウト</a> |
	<div class="right">
		<%=employeeName%>さん
	</div>
</div>
<hr>
<br>

