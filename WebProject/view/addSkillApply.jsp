
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<h1>スキル申請フォーム</h1>
	<%@include file="header-navi.jsp" %>
	<form method="post" action="<%=request.getContextPath()%>/SkillApprovalServlet" >
		<table align="center">
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
<%
if(request.getAttribute("fail")!=null){
	String fail = (String)request.getAttribute("fail");
%>
<script type="text/javascript">
    var msg = "<%=fail%>";
    alert(msg);
    </script>
<%}%>
</html>
