<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>スキル申請フォーム</title>
</head>
<body>
	<h1>スキル申請フォーム</h1>
	<form action="skillApprovalServlet" method="post">
		<input type="hidden" name="employeeNumber"
			value="<%=session.getAttribute("employeeNumber")%>"> <label
			for="skill">スキル:</label> <input type="text" id="skill" name="skill"
			required> <br>
		<br> <input type="submit" value="申請">
	</form>
</body>
</html>