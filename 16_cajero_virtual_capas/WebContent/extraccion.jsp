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
<title>Ingresar</title>
</head>
<body>
	<h1>Banca</h1>
	<fieldset>
		<legend>Extraer</legend><br>
		<form action="doExtraer" method="post">
			<label for="ftema">Cantidad</label>
			<input type="number" name="cantidad">
			<input type="submit" value="Extraer">
			<br><br>
		</form>
	</fieldset>
	<p align="right"><a href="toMenu">Regresar</a></p>
</body>
</html>