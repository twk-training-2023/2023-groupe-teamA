<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<jsp:useBean id="pdto" scope="request" class="model.ProfileDTO" />
<!DOCTYPE html>
<html>
<head>
<title>マイページ</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/view/style.css">
</head>
<body>
	<h1>マイページ</h1>
	<%@include file="header-navi.jsp" %>
	<p>ようこそ、<%=loginInfo.getName()%>さん！</p>
	
	<p><%ProfileBean pb = pdto.get(0); %>
	   <%=pb.getName() %>
	   <br>
	   <%=pb.getMail() %>		    
	   <br>
		社員番号:<%=loginInfo.getEmployeeID()%>
		<br>
		<!-- 動作せず　${requestScope.loginInfo.employeeID} -->
		
	<a href="<%=request.getContextPath()%>/view/addSkillApply.jsp">スキル申請ページへ</a>
	<a
		href="<%=request.getContextPath()%>/view/contactAdministratorsFrom.jsp">管理者向け連絡入力フォームへ</a>
	<a href="<%=request.getContextPath()%>/MyInfoUpDateMoveServlet">自己情報更新へ</a>
	
	
</body>
</html>