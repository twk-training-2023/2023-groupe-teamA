<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="model.*"%>
<<<<<<< HEAD
	<%@page import="java.util.List" %>
=======
>>>>>>> 8ba77b9a7a47e6640ed965a9f1450d7329332494
<jsp:useBean id="loginInfo" scope="session" class="model.LoginInfo" />
<!DOCTYPE html>
<html>
<head>
<title>マイページ</title>
</head>
<body>
	<h1>マイページ</h1>
	 <p>ようこそ、${requestScope.loginInfo.name}さん！</p>
	 <div>
	 	ようこそ
		<%=loginInfo.getName()%>さん
	</div>
	 
	<p>	
	 <!--   <%//List<string> list = (List<string>)request.getAttribute("profiledto"); %>
	    <%// for(string str: list) { %>
	    <%//=str %><br>
	    <%//} %>	
	 --> 
		社員番号:<%=loginInfo.getEmployeeID()%>
		<br>
		<!-- 動作せず　${requestScope.loginInfo.employeeID} -->
		<%=session.getAttribute("employeeNumber")%></p>
	<a href="<%=request.getContextPath()%>/view/addSkillApply.jsp">スキル申請ページへ</a>
	<a href="<%=request.getContextPath()%>/view/contactAdministratorsFrom.jsp">管理者向け連絡入力フォームへ</a>
	<a href="<%=request.getContextPath()%>/MyInfoUpDateMoveServlet">自己情報更新へ</a>
</body>
</html>