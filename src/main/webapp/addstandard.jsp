<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
button {
	width:100px;
	margin-top: 50px;
}
</style>
</head>
<body>
<form action="AdminCont" method="post">
	<label>Name: <input type="text" name="name"  /></label>
	
	<div >
	<label>Status: </label>
	<input type="radio" value="active" name="status"/>Active
	<input type="radio" value="inactive" name="status"/>Inactive
	
	</div>
	
	<div >
	
	
	<button type ="submit" name="action" value="addstandard" >Add Standard</button>
	</div>
</form>
</body>
</html>