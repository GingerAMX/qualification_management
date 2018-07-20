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
	<table border="1" align="center" id="delete">
				<tr>
					<th>ID</th><th>名前</th><th>著者名</th><th>貸し出し状況</th>
				</tr>
				<%
				int i = 0;
				while(i < resultList.size()) {
					Manage result = (Manage)resultList.get(i);
					out.println("<tr>");
					out.println("<td>" + result.getqId() + "</td>" + "<td>" + result.getqName() + "</td>"
					+ "<td>" + result.getId() + "</td>" + "<td>" + result.getName() + "</td>"
					+ "<td>" + result.getDay() + "</td>" + "<td>" + result.getResult() + "</td>");
					out.println("<tr>");
					i = i + 1;
				}
				%>
	</table>
</body>
</html>