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

<div align="center">
	<button>追加</button>

	<button>更新</button>

	<button>削除</button>
</div><br>
</table>
	
<%
    if (edto.size() > 0) {
    %>
<form method="get" action="<%=request.getContextPath()%>">
<table border="1"align="center">

			<tr>
				<th></th>
				<td width="65" align="center"><b>社員番号</b></td>		
				<td width="300" align="center"><b>メールアドレス</b></td>		
				<td width="100" align="center"><b>名前</b></td>		
				<td width="80" align="center"><b>権限レベル</b></td>
			</div>
			</tr>

			<%
			for (int i = 0; i < edto.size(); i++){
				EmployeeBean eb = edto.get(i);
			%>
			<tr>
				<td><input type = "checkbox"></td>
				<td align="center"><%=eb.getEmployeeID() %></td>
				<td align="center"><%=eb.getMailaddress() %></td>				
				<td align="center"><%=eb.getName() %></td>
				<td align="center"><%=eb.getPermissionLevel() %></td>
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
</table></form>
</body>
</html>