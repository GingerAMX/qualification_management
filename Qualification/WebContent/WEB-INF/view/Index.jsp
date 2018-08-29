<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dto.Manage"%>
<%@page import="dto.Qualification"%>
<%@page import="dto.Students"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");

	ArrayList<Manage> resultList = (ArrayList<Manage>)request.getAttribute("resultList");

	%>
	<form action="/Qualification/Index" method="post">
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
		<input type="submit" value="更新">
	</form>
	<table border="1" align="center" id="delete">
				<tr>
					<th>資格ID</th><th>資格名</th><th>生徒番号</th><th>学生名</th><th>学年</th><th>クラス</th>
					<th>日時</th><th>合否</th>
				</tr>
				<%
				int i = 0;
				while(i < resultList.size()) {
					Manage result = (Manage)resultList.get(i);
					out.println("<tr>");
					out.println("<td>" + result.getGrade() + "</td>" + "<td>" + result.getClass0() + "</td>"
					+ "<td>"+ result.getqId() + "</td>" + "<td>" + result.getqName() + "</td>"
					+ "<td>" + result.getId() + "</td>" + "<td>" + result.getName() + "</td>"
					+ "<td>" + result.getDay() + "</td>" + "<td>" + result.getResult() + "</td>");
					out.println("<tr>");
					i = i + 1;
				}
				%>
	</table>
	<a href="/Qualification/Top">トップへ戻る</a>
</body>
</html>