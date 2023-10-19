<%@page import="Model.standard"%>
<%@page import="java.util.List"%>
<%@page import="Dao.AdminDao"%>
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
<title>Standard List</title>
</head>
<body>
<h1>Standard List</h1>

<%List<standard> list = AdminDao.getStandardList(); %>
<table>
<tr>
	<th>S_ID</th>
	<th>S_Name</th>
	<th>Status</th>
</tr>



<%for(standard s: list){ %>

<tr>
	<td><%=s.getId() %></td>
	<td><%=s.getName() %></td>
	<td><%=s.getStatus() %></td>

<%} %>
</table>

</body>
</html>