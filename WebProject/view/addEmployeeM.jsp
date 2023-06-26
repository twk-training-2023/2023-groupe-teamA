<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<from action="<%=request.getContextPath()%>/AddEmployeeServlet">
		<table>
			<tr>
				<th>メールアドレス：</th>
				<td><input type="email" name="mail" required></td>
			</tr>
			<tr>
				<th>パスワード：</th>
				<td><input type="password" name="pass" required></td>
			</tr>
			<tr>
				<th>名前：</th>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<th>権限レベル：</th>
				<td><input type="number" name="level" required></td>
			</tr>
		</table><br>
		<input type="submit" value="追加">
	</from><br><br>
	<form action="<%=request.getContextPath()%>/AddCsvEmployeeServlet"
		method="post" enctype="multipart/form-data">
		<label>ファイル：</label> <input type="file" name="csv.file" multiple required/>
		<br />
		<!-- 追加するのはここまで -->
		<input type="submit" value="まとめて追加"/>
	</form>
	</form>
</body>
</html>