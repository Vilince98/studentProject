<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
Body {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: pink;
}

button {
	background-color: #4CAF50;
	width: 100%;
	color: orange;
	padding: 15px;
	margin: 10px 0px;
	border: none;
	cursor: pointer;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	margin: 8px 0;
	padding: 12px 20px;
	display: inline-block;
	border: 2px solid green;
	box-sizing: border-box;
}

button:hover {
	opacity: 0.7;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	margin: 10px 5px;
}

.container {
	padding: 25px;
	background-color: lightblue;
}
</style>
</head>
<body>

	<center>
		<h1>Login</h1>
	</center>
	<form action="AdminCont" method="post">


		<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>
		
		<%
		String msg1 = (String) request.getAttribute("msg1");
		if (msg1 != null) {
		%>
		<h4><%=msg1%></h4>
		<%
		}
		%>

		<div class="container">
			<label>Username : </label> <input type="text"
				placeholder="Enter Username" name="username" required> <label>Password
				: </label> <input type="password" placeholder="Enter Password"
				name="password" required>
			<button type="submit" name="action" value="adminSignIn">Login</button>

		</div>
	</form>
</body>
</html>