<%@page import="model.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thông tin cá nhân</h1>
	<% 
		Account a = (Account) request.getAttribute("account");
		
	%>
	Tên: <%= a.getUsername() %>
	Thông tin: <%= a.getInfo() %>
</body>
</html>