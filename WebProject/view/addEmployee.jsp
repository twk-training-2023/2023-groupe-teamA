<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員追加</title>
</head>
<body>

<tr>

</tr>
	<div>
	<h1 style="text-align:center">社員追加</h1>
	
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