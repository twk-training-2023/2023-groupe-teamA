<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pdto" scope="request" class="model.ProfileDTO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員管理表</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<h2>自己情報更新</h2>
	<%@include file="header-navi.jsp"%>
	<%
	ProfileBean pb = pdto.get(0);
	%>
	<form method="post"
		action="<%=request.getContextPath()%>/MyInfoUpDateServlet" class="contact-form">
		<table>
			<tr>
				<th>名前</th>
				<td><%=pb.getName()%></td>
			</tr>
			<tr>
				<th>メールアドレス</th>
				<td><input type="email" name="mail" value="<%=pb.getMail()%>"
					required></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="password" name="pass"
					value="<%=pb.getPass()%>" required></td>
			</tr>
			<tr>
				<th>自己紹介文</th>
				<td><textarea name="appeal" cols="30" rows="10"><%=pb.getAppeal()%></textarea></td>
			</tr>
		</table>
		<br> <input type="submit" value="更新">
		<p class="errorMsg">${requestScope.errorMsg }</p>
	</form>
</body>
</html>