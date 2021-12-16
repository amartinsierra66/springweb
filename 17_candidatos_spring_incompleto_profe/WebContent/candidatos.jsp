<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Candidato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table,tr,th,td {
		border:1px solid pink;
	}
</style>
</head>
<body>
	<table>
	<tr>
		<th>Nombre</th>
		<th>Edad</th>
		<th>Puesto</th>
		<th>Email</th>
		<th></th>
	</tr>
		
			<%
						
						  List<Candidato> candidatos= (List<Candidato>)request.getAttribute("candidatos");
						  if(candidatos.size()>0){
							for(int i=0;i<candidatos.size();i++){
					%>
					<tr><td>
						<%=candidatos.get(i).getNombre()%>
					</td>
					<td>
						<%=candidatos.get(i).getEdad()%>
					</td>	
					<td>
						<%=candidatos.get(i).getPuesto()%>
					</td>	
					<td>
						<%=candidatos.get(i).getEmail()%>
					</td>				
					<td><a href="eliminar?idCandidato=<%=candidatos.get(i).getIdcandidato()%>">Eliminar</a></td>
					</tr>
				<%}
				}else{%>
					<h1>No hay candidatos registrados</h1>
				<%}%>
	
	</table>
	<a href="volver">Volver al menu</a>
</body>
</html>
