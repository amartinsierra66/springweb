<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Candidato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Candidato dato=(Candidato)request.getAttribute("candidato");
	if(dato!=null){%>
	
		<h3>Nombre:<%=dato.getNombre() %></h3>
		<h3>Email:<%=dato.getEmail() %></h3>
	<%}else{ %>
	
		<H1>El candidato no existe</H1>
		
	<%} %>
	<br>
	<a href="toMenu">Volver</a>
</body>
</html>