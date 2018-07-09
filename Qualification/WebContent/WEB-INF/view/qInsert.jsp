<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Qualification/QInsert" method="post">
		<p>資格ID<label><input type="text" name="qId"></label></p>
		<p>資格名<label><input type="text" name="qName"></label></p>
		<input type="submit" value="登録">
	</form>
</body>
</html>