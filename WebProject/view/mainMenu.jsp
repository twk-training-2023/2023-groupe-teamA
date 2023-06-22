<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.*"%>
<jsp:useBean id="loginInfo" scope="session" class="model.LoginInfo" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>メインメニュー</h2>
	<div>
	 	<a href="<%=request.getContextPath()%>/LogoutServlet">ログアウト</a> |
		<%=loginInfo.getName()%>さん
	</div>
	<a href="<%=request.getContextPath()%>/MypageServlet">マイページ</a><br>
	${requestScope.adminMenuLink }<br>
</body>
</html>