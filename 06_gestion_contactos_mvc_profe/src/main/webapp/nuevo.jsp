<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<h1>Grabar producto</h1>
	<form action="doAlta" method="post">
		<div class="form-group">
			<label>Nombre:</label><input type="text" name="nombre" class="form-control" style="width:30%" placeholder="Nombre" autocomplete="name"/>
		</div>
		<div class="form-group">
			<label>Email:</label><input type="text" name="email" class="form-control" style="width:30%" placeholder="Email"/>
		</div>
		<div class="form-group">
			<label>Edad:</label><input type="text" name="edad" class="form-control" style="width:30%" placeholder="Edad"/>
		</div>
		<button type="submit" class="btn btn-default">Guardar</button>
		
	</form>
	<br/><br/>
</div>
</html>