
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>スキル申請フォーム</title>
</head>
<body>
	<h1>スキル申請フォーム</h1>
	<form method="post" action="<%=request.getContextPath()%>/SkillApprovalServlet">
		<table>
			<tr>

			    <th>スキル名：</th>
				<td><input type="text" name="skill_name" required></td>
				<th>アピール：</th>

				<td><input type="text" name="skill_detail" required></td>
			</tr>
		</table><br>
		<input type="submit" value="申請">
	</form>
</body>
</html>
