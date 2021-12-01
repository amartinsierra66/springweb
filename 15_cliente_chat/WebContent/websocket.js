var cajadatos, socket, usuario;
function conectar(){
	usuario = document.getElementById("usuario").value;
	cajadatos= document.getElementById("cajadatos");
	conectados=document.getElementById("conectados")
	socket = new WebSocket("ws://localhost:8080/14_servidor_chat/chat");
	
	socket.onopen=function(evento){
		var jsonChat=new Object();
		jsonChat.usuario=usuario.toUpperCase();
		jsonChat.mensaje="Se ha conectado";
		socket.send(JSON.stringify(jsonChat));
	}
	socket.onmessage=function(evento){
		//recogemos el objeto JSON y extraemos sus propiedades
		//para mostrarlas
		var objJSON=JSON.parse(evento.data);
		cajadatos.innerHTML +="<b>"+objJSON.usuario+": </b>"+objJSON.mensaje+"<br/>";
		conectados.innerHTML="<b>Usuario conectados "+objJSON.conectados+"</b>";
	}
	socket.onclose=function(evento){		
		cajadatos.innerHTML = "Desconectado del Servidor";
	}
	
}
/*function conectado(){
	socket.send(usuario.toUpperCase()+" SE HA CONECTADO<br/>");
}

function recibido(evento){
	cajadatos.innerHTML +=evento.data+"<br/>";

}*/


function desconectar(){
	var jsonChat=new Object();
	jsonChat.usuario=usuario.toUpperCase();
	jsonChat.mensaje="SE HA DESCONECTADO";
	socket.send(JSON.stringify(jsonChat));
	socket.close();
}

function enviar(){
	mensaje = document.getElementById("mensaje").value;
	//var chat=usuario+": "+mensaje;
	//construimos un objeto JSON con los datos del mensaje
	//y lo enviamos como texto
	var jsonChat=new Object();
	jsonChat.usuario=usuario;
	jsonChat.mensaje=mensaje;
	socket.send(JSON.stringify(jsonChat));
}

