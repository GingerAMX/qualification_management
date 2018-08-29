<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Qualification/NewRegister" method="post">
		<p>ID<label><input type="text" name="ID"></label></p>
		<p>パスワード<label><input type="password" name="pass"></label></p>
		<p>名前<label><input type="text" name="Name"></label></p>
		<p>学生番号<label><input type="text" name="Sid"></label></p>
		<p>メールアドレス<label><input type="text" name="Mail"></label></p>
		<input type="submit" value="登録">
	</form>
</body>
</html>