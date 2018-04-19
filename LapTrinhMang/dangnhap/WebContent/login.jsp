<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<style>
	.container {
		width: 200px;
		height: 200px;
		margin: 200px auto;
		padding: 20px;
	}
	.container form {
		margin: 20px auto;
	}
	label {
		display: block;
		width: 500px;
	}
	input {
		margin: 2px;
	}
	input[type="submit"] {
		margin-left: 50px;
	}
	input[type="submit"]:hover {
		color:red;
	}
 </style>
</head>
<body>
 <div class="container">
	 <form action="CheckLoginServerlet" method="post">
	 	<label>Username</label>
	 	<input type="text" name="username">
	 	<br/>
	 	<label>Password</label>
	 	<input type="password" name="password">
	 	<br/>
	 	<input type="submit" value="Login"> 
	 </form>
 </div>
</body>
</html>