<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スキル承認ページ</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<p>スキルアピール一覧</p>
	<%@include file="header-navi.jsp" %>
	<table border="1" width="1000" height="500" align="center">
		<tr>
			<th>名前</th>
			<th>スキル名</th>
			<th>申請日</th>
			<th>スキルアピール</th>
			<th>否認</th>
			<th>承認</th>
		</tr>
		<tr>
			<th>名前</th>
			<th>スキル名</th>
			<th>申請日</th>
			<th>スキルアピール</th>
			<th><input type="button" value="否認"></th>
			<th><input type="button" value="承認"></th>
		</tr>
	</table>
</body>

</html>