<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理表</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/view/style.css">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
</head>
<body>
	<h2>ログイン</h2>
	<form method="post" action="<%=request.getContextPath()%>/LoginServlet"
		class="contact-form">
		<table>
			<tr>
				<th>メールアドレス：</th>
				<td><input type="email" name="mail" required></td>
			</tr>
			<tr>
				<th>パスワード：</th>
				<td>
				<input type="password" id="password" name="password" required> 
				<span id="buttonEye" class="fa fa-eye" onclick="pushHideButton()"></span></td>
			</tr>
		</table>
		<br> <input type="submit" value="ログイン">
	</form>
	<p class="errorMsg">${requestScope.errorMsg }</p>
	<script>
	function pushHideButton() {
        var txtPass = document.getElementById("password");
        var btnEye = document.getElementById("buttonEye");
        if (txtPass.type === "text") {
          txtPass.type = "password";
          btnEye.className = "fa fa-eye";
        } else {
          txtPass.type = "text";
          btnEye.className = "fa fa-eye-slash";
        }
      }
	</script>
</body>
</html>