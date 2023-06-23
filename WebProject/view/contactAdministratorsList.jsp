<%@page contentType="text/html;charset=utf-8"%>
<%@page import="model.*"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="caDTOlist" scope="request" class="model.CommentAdminDTO" />
<jsp:useBean id="loginInfo" scope="session" class="model.LoginInfo" />


<html>
<head>
<meta charset="UTF-8">
<title>管理者向け連絡一覧画面</title>
</head>
<body>


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