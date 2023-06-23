<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員更新画面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
</head>
<body>
	<p>社員情報更新</p>
	<%@include file="header-navi.jsp" %>
	<p>
		<label>名前：<input type="text" name="name" size="20"></label>
	</p>
	<p>
		<label>メールアドレス：<input type="email" name="email" size="30"
			maxlength="40"></label>
	</p>
	パスワード：
	<input type="password" name="pass" size="10" maxlength="8">
	<br>
	<br>
	<p>
		<label>名前：<input type="text" name="name" size="20"></label>
	</p>
	<p>
		<label>メールアドレス：<input type="email" name="email" size="30"
			maxlength="40"></label>
	</p>
	パスワード：
	<input type="password" name="pass" size="10" maxlength="8">
	<br>
	<p>
		<input type="button" value="変更確定">
	</p>

</body>
</html>