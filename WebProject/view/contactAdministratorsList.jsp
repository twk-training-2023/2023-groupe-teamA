<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="caDTO" scope="request" class="model.CommentAdminDTO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者向け連絡一覧画面</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
<p>管理者向け連絡一覧</p>
<%@include file="header-navi.jsp" %>


</body>
</html>