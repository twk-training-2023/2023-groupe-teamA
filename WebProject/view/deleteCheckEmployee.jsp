<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員削除確認画面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<p>・社員名の一覧</p>
	<%@include file="header-navi.jsp" %>

<br>
<p>以上の社員を削除しますか？</p>

<p>
<input type="button" value="キャンセル">
<input type="button" value="決定">
</p>
</body>
</html>