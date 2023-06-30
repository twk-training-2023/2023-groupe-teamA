<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<p class="errorMsg">${requestScope.successMsg }</p>
	<p class="errorMsg">${requestScope.errorMsg }</p>
	<div>
		<h2>社員追加</h2>
		<%@include file="header-navi.jsp"%>
		<form method="post"
			action="<%=request.getContextPath()%>/AddEmployeeServlet">
			<table align="center">
				<tr>
					<th>名前:</th>
					<td><input type="name" name="name" required></td>
					<br>
				</tr>
				<tr>
					<th>メールアドレス:</th>
					<td><input type="email" name="mail" required></td>
					<br>
				</tr>
				<tr>
					<th>パスワード:</th>
					<td><input type="password" name="password" required></td>
					<br>
				</tr>
				<tr>
					<th>権限レベル:</th>
					<td><input type="level" name="level" required></td>
					<br>
				</tr>
			</table>
			<input type="submit" value="登録" align="center">
		</form>
		<br> <br>
		<form action="<%=request.getContextPath()%>/AddCsvEmployeeServlet"
			method="post" enctype="multipart/form-data">
			<label>ファイル：</label> <input type="file" name="csvFile" multiple
				required /> <br /> <input type="submit" value="まとめて追加" />
		</form>
</body>
</html>