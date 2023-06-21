<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="model.*"%>
<jsp:useBean id="loginInfo" scope="session" class="model.LoginInfo" />
<!DOCTYPE html>
<html>
<head>
<title>マイページ</title>
</head>
<body>
	<h1>マイページ</h1>
	 <p>ようこそ、${requestScope.loginInfo.name}さん！</p>
	 <div>
	 	ようこそ
		<%=loginInfo.getName()%>さん
	</div>
	 
	<p>	
	    	
		社員番号:<%=loginInfo.getEmployeeID()%>
		<br>
		${requestScope.loginInfo.employeeID}
		<%=session.getAttribute("employeeNumber")%></p>
	<a href="<%=request.getContextPath()%>/view/addSkillApply.jsp">スキル申請ページへ</a>
	<a href="<%=request.getContextPath()%>/view/contactAdministratorsFrom.jsp">管理者向け連絡入力フォームへ</a>
	<a href="<%=request.getContextPath()%>/MyInfoUpDateMoveServlet">自己情報を更新</a>
</body>
</html>