<%@page import="Model.standard"%>
<%@page import="Dao.AdminDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: pink;
}

.container {
	padding: 50px;
	background-color: lightblue;
}

input[type=text], input[type=password], textarea {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: orange;
	outline: none;
}

div {
	padding: 10px 0;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}
</style>
<title>Insert title here</title>
</head>
<body>


	<form action="AdminCont" method="post" enctype="multipart/form-data">
	<%List<standard> list = AdminDao.getStandardList(); %>
		<div class="container">
			<center>
				<h1>Student Registeration Form</h1>
			</center>
			<hr>
			<label> Firstname </label> <input type="text" name="fname"
				placeholder="Firstname" required /> 
			<label> Lastname: </label> <input type="text" name="lname" placeholder="Lastname"
				required />
			<div>
				<label> Standard : </label> 
				<select name="standard" >
				
					<%for(standard s: list) { %>
					<option value="<%=s.getId() %>"><%=s.getName() %></option>
					
					<%} %>
					
				</select>
				
			<div>
				<label>Date of Birth: <input type="date" name="dob" /></label>
			</div>
			
			<div>
				<label>Student Image: <input type="file" name="img" /></label>
			</div>
			</div>
						<button type="submit" class="registerbtn" value="register" name="action">Register</button>
	</form>

</body>
</html>