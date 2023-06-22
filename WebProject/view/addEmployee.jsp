<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員追加</title>
</head>
<body>
<table border="5">
<tr>
<td colspan="5"></td>
</tr>
	<div>
	<h1 style="text-align:center">社員追加</h1>
	
	<th style="text-align:center">社員番号：</th>
				<td><input type="text" name="nunber" required></td>
			</tr><br>
	<th style="text-align:center">名前：</th>
				<td><input type="name" name="name" required></td>
			</tr><br>
			<tr>
	<th style="text-align:center">メールアドレス：</th>
				<td><input type="email" name="mail" required></td>
			</tr><br>
			<tr>
	<th style="text-align:center">パスワード：</th>
				<td><input type="password" name="password" required></td>
			<tr><br>
	<th style="text-align:center">権限レベル：</th>
				<td><input type="level" name="level" required></td>
			</tr></div>
		
</table>
	<br>
	<button style="text-align:center>追加</button>
	
</body>
</html>