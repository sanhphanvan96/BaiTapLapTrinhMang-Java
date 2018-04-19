<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form action="<%= request.getContextPath() + "/signup" %>" method="post" accept-charset="utf-8">
		Họ <input type="text" name="LastName">
		<br>
		Tên <input type="text" name="FirstName">
		<input type="submit" value="submit">
	</form>
</body>
</html>