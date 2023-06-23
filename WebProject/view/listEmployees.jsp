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
<div align="center">
<h1>社員一覧</h1>
</div>
<table>
<form method="post" action="/WebProject/view/addEmployee.jsp">
<div align="center">
	<input type = "submit" value = "追加">
</form>
	<button>更新</button>

	<button>削除</button>
</div><br>
</table>
	
<%
    if (edto.size() > 0) {
    %>
<table border="1"align="center">

			<tr>
				<th>
				<td width="65" align="center"><b>社員番号</b></td>				
				<td width="100" align="center"><b>名前</b></td>	
				<td width="300" align="center"><b>メールアドレス</b></td>
				<td width="200" align="center"><b>パスワード</b></td>		
				<td width="80" align="center"><b>権限レベル</b></td>
				</th>
			</tr>

			<%
			for (int i = 0; i < edto.size(); i++){
				EmployeeBean eb = edto.get(i);
			%>
			<table border="1"align="center">
				<td width="65" align="center"><%=eb.getEmployeeID() %></td>				
				<td width="100" align="center"><%=eb.getName() %></td>
				<td width="300" align="center"><%=eb.getMailaddress() %></td>
				<td width="200" align="center"><%=eb.getPassword() %></td>
				<td width="80" align="center"><%=eb.getPermissionLevel() %></td>
			</table>
			<%
			}
			%>
	<%
	}else{
		%>
		<h3>ありません</h3>
	<% 
	}
	%>
</table>
</body>
</html>