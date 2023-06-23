<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="caDTOlist" scope="request" class="model.CommentAdminDTO" />
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
	<p>管理者向け連絡一覧</p>
	<br>
番号 |　名前　|　件名　|　変更日時　
<br>
ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
<br>
	<%
		int i = 0 ;
			for(i=0;i<caDTOlist.size();i++) {
		%>
		<%
			
		CommentAdminBean db = caDTOlist.get(i);
		%>
		
		<tr>
		<%=db.getCommentNumber()%>　
		|
		<%=db.getName()%>
		|
	<%=db.getTitle()%>
		|
		<%=db.getChangeDay()%>
		|
		<br>
		本文：<%=db.getContent()%>
		<br>
		<br>
		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		<br>
	</tr>
		<%
			}
		%>

	
</body>
</html>