<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
table, td {
	font-family: serif;
	border: 1px solid #dddddd;
	border-collapse: collapse;
	text-align: left;
}

th {
	font-family: serif;
	border: 1px solid #dddddd;
	border-collapse: collapse;
	background-color: #dddddd;
	text-align: center;
}

a {
	color:LIGHTSLATEGRAY;
}

h1 {
	color:DARKSALMON;
}

legend {
	color:INDIANRED;
}
</style>
<meta charset="ISO-8859-1">
<title>Movimientos</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	function consultaMovimientos(){		
		
		$.get("doMovimientos",{"f1":$("#f1").val(),"f2":$("#f2").val()},function(data,status){
			procesarRespuesta(data);
		});
		
	}
	
	function procesarRespuesta(data){
			var tabla="<table border='1'><tr><th>Numero Cuenta</th><th>Cantidad</th><th>Tipo</th><th>Fecha</th></tr>";
			
			for(var mv of data){
				tabla+="<tr><td>"+mv.cuenta+"</td><td>"+mv.cantidad+"</td><td>"+mv.operacion+"</td><td>"+mv.fecha+"</td></tr>";
			}
			tabla+="</table>";
			$("#movimientos").html(tabla);
		
	}


</script>
</head>
<body>
	<h1>Banca</h1>
	Fecha inicial: <input type="date" id="f1"> Fecha fin: <input type="date" id="f2">
	<br><br>
	<input type="button" value="Ver movimientos" onclick="consultaMovimientos();">
	<br>
	Saldo de la cuenta: ${requestScope.saldo}
	<fieldset>
		<legend>Movimientos</legend>
		<div id="movimientos">
		
		</div>
		
	</fieldset>
	
<p align="right"><a href="toMenu">Volver</a></p>
</body>
</html>