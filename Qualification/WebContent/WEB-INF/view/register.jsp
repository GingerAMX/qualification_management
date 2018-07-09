<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Qualification/Register" method="post">
		<p>学生ID<label><input type="text" name="id"></label></p>
		<p>名前<label><input type="text" name="name"></label></p>
		<p>学年<label>
					<select name="grade">
						<option value="0" selected>-----------</option>
						<option value="1">１</option>
						<option value="2">２</option>
						<option value="3">３</option>
					</select>
		</label></p>
		<p>クラス<label>
					<select name="class0">
						<option value="0" selected>-----------</option>
						<option value="A">Ａ</option>
						<option value="B">Ｂ</option>
						<option value="C">Ｃ</option>
						<option value="D">Ｄ</option>
					</select>
		</label></p>
		<input type="submit" value="登録">
	</form>
</body>
</html>