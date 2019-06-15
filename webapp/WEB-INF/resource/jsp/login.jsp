<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First Web app</title>
</head>
<body style="align-content: center">
<form action="showLogin" method="post"> 
	<div style="font-size: 20px;">	
		<b style="color: red;">	${errorMessage}</b> <br/>
			   <b> Login </b> <br/><br/>
		User Name : <input type="text" name="userName"> <br/><br/>
		Password  :	<input type="password" name="password"> <br/><br/>
		<button>Login</button>
 	</div>
 </form>
	<b style="width:30px; font-size: 30px;"> <a href="home"> Home </a> </b> &nbsp;&nbsp;
	<b style="width:30px; font-size: 30px;"> <a href="/firstwebapp">Index </a> </b> &nbsp;&nbsp;  
</body>
</html>