<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理表</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<h2>ログイン</h2>
	<form method="post" action="<%=request.getContextPath()%>/LoginServlet">
		<table>
			<tr>
				<th>メールアドレス：</th>
				<td><input type="email" name="mail" required></td>
			</tr>
			<tr>
				<th>パスワード：</th>
				<td><input type="password" name="password" required></td>
			</tr>
		</table><br>
		<input type="submit" value="ログイン">
	</form>
	<p class="errorMsg">${requestScope.errorMsg }</p>
</body>
</html>