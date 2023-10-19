<%@page import="Dao.AdminDao"%>
<%@page import="Model.student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
table, th, td {
  border: 1px solid black;
  
}

th, td {
 padding: 10px;
} 

</style>
<title>Student List</title>
</head>
<body>

<%List<student> list = AdminDao.getStudentList(); %>
<table>
<tr>
	<th>Fname</th>
	<th>Lname</th>
	<th>Standard</th>
	<th>Date Of Birth</th>
	<th>image</th>
	<th>Create Date</th>
	<th>Status</th>
</tr>
<%for(student s: list) { %>
<tr>
	<td><%=s.getFname() %></td>
	<td><%=s.getLname() %></td>
	<td><%=s.getStandard() %></td>
	<td><%=s.getDob() %></td>
	<td><%=s.getImg() %></td>
	<td><%=s.getCd() %></td>
	<td><%=s.getStatus() %></td>
</tr>


<%} %>
</table>
</body>
</html>