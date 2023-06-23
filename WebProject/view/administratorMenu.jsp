<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用メニュー</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<h2>管理者用メニュー</h2>
<<<<<<< HEAD
	<div>
	<a href="<%=request.getContextPath()%>/EmployeesListServlet">社員一覧ページへ</a><br>
	<a href="<%=request.getContextPath()%>/ContactAdministratorsFromServlet">連絡一覧ページへ</a><br>
	<a href="<%=request.getContextPath()%>/SkillApprovalServlet">スキル承認ページへ</a>
	</div>
=======
	<%@include file="header-navi.jsp" %>
	<a href="listEmployees.jsp">・社員一覧ページへ</a><br><br>
	<a href="ContactAdministratorsList.jsp">・連絡一覧ページへ</a><br><br>
	<a href="skillApproval.jsp">・スキル承認ページへ</a>
>>>>>>> 82c8817698c1c9322f9fb78c56783037f7a2dfbe
</body>
</html>