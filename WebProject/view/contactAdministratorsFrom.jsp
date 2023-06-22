<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*"%>
    <jsp:useBean id="loginInfo" scope="session" class="model.LoginInfo" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者向け連絡入力フォーム</title>
</head>
<body>
<p>管理者への連絡を入力してください |<%=loginInfo.getName()%>さん</p>
 <form method="post" name="contactAdmin" action="/WebProject/ContactAdministratorsFromServlet" >
<p>件名<input type="text" maxlength="40" style="width: 400px"" name="title" required></p>
<p>本文<textarea cols="100" rows="5" name="content" required></textarea></p>

<input type="submit" value="送信">

</form>

</body>
</html>