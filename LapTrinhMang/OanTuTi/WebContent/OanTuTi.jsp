<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Game Oan Tu Ti - Using Cookie</title>
</head>
<body>
	<div>
		<button id="Keo" onclick="setCookie('Keo')" >Keo</button>
		<button id="Bua" onclick="setCookie('Bua')" >Bua</button>
		<button id="Bao" onclick="setCookie('Bao')" >Bao</button>
		<br/>
		<%
			Random rand = new Random();
			int id = rand.nextInt(3);
			String str = "";
			if(id==0) {
				str = "Keo";
			} else if (id==1) {
				str = "Bua";
			} else {
				str = "Bao";
			}
		%>
		<input id="ketqua" style="display:none" type="text" readonly="readonly" disabled="disabled" value="<%= str %>">

	</div>
	<script>
		function setCookie(choose) {
			document.cookie="choose=" + choose;
			document.getElementById("ketqua").style="display:block;";
			setTimeout(function () {
				location.href="sendCookies?id=" + choose;
			}, 3000);
		}
	</script>
</body>
</html>