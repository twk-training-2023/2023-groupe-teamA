<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者向け連絡入力フォーム</title>
</head>
<body>
<p>管理者への連絡を入力してください</p>
 <form method="post" name="contactAdmin" action="/WebProject/ContactAdministratorsFromServlet">
<p>件名<input type="text" style="width: 400px"" name="title"></p>
<p>本文<input type="text" style="width: 400px; height: 150px;" name="content"></p>
<input type="submit" value="送信">

</form>

</body>
</html>