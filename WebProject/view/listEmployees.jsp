<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.*" %>
<jsp:useBean id="edto" scope="request" class="model.EmployeeDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
</head>
<body>
<h2>社員一覧</h2>
<%
    if (edto.size() > 0) {
    %>
<form method="get" action="<%=request.getContextPath()%>">
		<table border="1" align="center">
			<tr>
				<td width="150">社員番号：</td>
			
			
				<td width="300">メールアドレス：</td>
				
			
				<td width="250">名前：</td>
				
			
				<td width="150">権限レベル：</td>
				
			</tr>
			<%
			for (int i = 0; i < edto.size(); i++){
				EmployeeBean eb = edto.get(i);
			%>
			<tr>
				<td><%=eb.getEmployeeID() %></td>
				<td><%=eb.getMailaddress() %></td>				
				<td><%=eb.getName() %></td>
				<td><%=eb.getPermissionLevel() %></td>
			</tr>
			<%
			}
			%>
		</table>
	<%
	}else{
		%>
		<h3>ありません</h3>
	<% 
	}
	%>
</form>
	<button>追加</button>
	<button>更新</button>
	<button>削除</button>
</body>
</html>