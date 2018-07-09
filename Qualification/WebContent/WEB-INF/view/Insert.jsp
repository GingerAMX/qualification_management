<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Qualification/DataInsert" method="post">
		<p>資格ID<label><input type="text" name="qId"></label></p>
		<p>受験日<label><input type="text" name="day"></label></p>
		<p>学生ID<label><input type="text" name="id"></label></p>
		<p>合否<label>
					<select name="result">
						<option value="0" selected>-----------</option>
						<option value="合格">合格</option>
						<option value="不合格">不合格</option>
					</select>
		</label></p>
		<input type="submit" value="登録">
	</form>
</body>
</html>