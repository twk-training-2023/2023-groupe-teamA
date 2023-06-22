<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<h2>メインメニュー</h2>
	<%@include file="header-navi-general.jsp" %>
	<a href="<%=request.getContextPath()%>/MypageServlet">マイページ</a><br>
	<%
	if (loginInfo.getPermissionLevel() > 3){
	%>
	<a href="<%=request.getContextPath()%>/view/administratorMenu.jsp">管理者メニュー</a>
	<%
	}
	%>
</body>
</html>