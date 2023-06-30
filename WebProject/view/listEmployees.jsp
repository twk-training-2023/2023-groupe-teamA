<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<jsp:useBean id="edto" scope="request" class="model.EmployeeDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
<div align="center">
<h1>社員一覧</h1>
<%@include file="header-navi.jsp" %>
</div>
<table>
<form method="post" action="/WebProject/view/addEmployee.jsp">
<div align="center">
	<input type = "submit" value = "追加">
</form>
	<button  class="unfinished">更新</button>
	<button  class="unfinished">削除</button>
</div><br>
</table>

<table border="1"align="center">

			<tr>
				<th><b>社員番号</b></th>				
				<th><b>名前</b></th>	
				<th><b>メールアドレス</b></th>
				<th><b>パスワード</b></th>		
				<th><b>権限レベル</b></th>
			</tr>

			<%
			for (int i = 0; i < edto.size(); i++){
				EmployeeBean eb = edto.get(i);
			%>
			

			<tr>
				<td><%=eb.getEmployeeID() %></td>				
				<td><%=eb.getName() %></td>
				<td><%=eb.getMailaddress() %></td>
				<td><%=eb.getPassword() %></td>
				<td><%=eb.getPermissionLevel() %></td>
			</tr>
			<%
			}
			%>
</table>
</body>
</html>