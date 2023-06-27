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
	<h1>社員追加</h1>
	<%@include file="header-navi.jsp" %>
	<th>名前：</th>
				<td><input type="email" name="mail" required></td>
			</tr><br>
			<tr>
	<th>メールアドレス：</th>
				<td><input type="email" name="mail" required></td>
			</tr><br>
			<tr>
	<th>パスワード：</th>
				<td><input type="password" name="password" required></td>
			</tr><br><br>
	
	<button>追加</button>
</body>
</html>