<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者用メニュー</title>
</head>
<body>
	<h2>管理者用メニュー</h2>
	<div>
	<a href="<%=request.getContextPath()%>/EmployeesListServlet">社員一覧ページへ</a><br>
	<a href="<%=request.getContextPath()%>/ContactAdministratorsFromServlet">連絡一覧ページへ</a><br>
	<a href="<%=request.getContextPath()%>/SkillApprovalServlet">スキル承認ページへ</a>
	</div>
</body>
</html>