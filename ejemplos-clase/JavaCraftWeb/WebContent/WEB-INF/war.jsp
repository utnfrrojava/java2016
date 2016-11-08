<%@page import="entidades.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>War!!</title>
</head>
<body>
	<h1>War!!</h1>
	<% 
		Persona p1= ((Persona)session.getAttribute("P1"));
		Persona p2= ((Persona)session.getAttribute("P2"));
	%>
	<%=p1.getNombre()+" "+p1.getApellido() %>
	<%=p2.getNombre()+" "+p2.getApellido() %>
</body>
</html>