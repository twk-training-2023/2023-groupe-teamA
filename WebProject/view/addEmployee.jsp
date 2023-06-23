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
<<<<<<< HEAD

<tr>

</tr>
	<div>
	<h1 style="text-align:center">社員追加</h1>
=======
	<h1>社員追加</h1>
	<%@include file="header-navi.jsp" %>
	<th>名前：</th>
				<td><input type="email" name="mail" required></td>
			</tr><br>
			<tr>
	<th>メールアドレス：</th>
				<td><input type="email" name="mail" required></td>
			</tr><br>
			<tr>
	<th>パスワード：</th>
				<td><input type="password" name="password" required></td>
			</tr><br><br>
>>>>>>> 82c8817698c1c9322f9fb78c56783037f7a2dfbe
	
	 <form method="post" action="<%=request.getContextPath()%>/AddEmployeeServlet">
        <label>社員番号</label><input type="number" name="number"><br>
        <label>名前</label><input type="name" name="name"><br>
        <label>メールアドレス</label><input type="email" name="mail"><br>
        <label>パスワード</label><input type="password" name="password"><br>
        <label>権限レベル</label><input type="level" name="level"><br>
        
        <input type="submit" value="登録" align="center">
    </form>
    	
</body>
</html>