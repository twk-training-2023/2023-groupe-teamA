<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員追加</title>
</head>
<body>
<table>
<tr>

</tr>
	<div>
	<h1 style="text-align:center">社員追加</h1>
	
	<th>社員番号</th>
				<td><input type="number" name="nunber" align="center" required></td>
			</tr><br>
	<th>名前</th>
				<td><input type="name" name="name" required></td>
			</tr><br>
			<tr>
	<th>メールアドレス</th>
				<td><input type="email" name="mail" required></td>
			</tr><br>
			<tr>
	<th>パスワード</th>
				<td><input type="password" name="password" required></td>
			<tr><br>
	<th>権限レベル</th>
				<td><input type="level" name="level" required></td>
			</tr></div>
		
</table>
	<br>
	<button style="text-align:center>追加</button>
	
</body>
</html>