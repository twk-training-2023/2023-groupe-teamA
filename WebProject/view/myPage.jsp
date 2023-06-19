<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>マイページ</title>
</head>
<body>
	<h1>マイページ</h1>
	<p>
		名前：
		
		社員番号:
		<%=session.getAttribute("employeeNumber")%></p>
	<a href="SkillApplication.jsp">スキル申請ページへ</a>
	<a href="contactAdministratorsFrom.jsp">管理者向け連絡入力フォームへ</a>
</body>
</html>