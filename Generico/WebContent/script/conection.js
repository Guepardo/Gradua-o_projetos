var socket = null;

$('document').ready( function(){
	initializeSock();
});

//Incializa o socket;
function initializeSock(){
	socket = new WebSocket('ws://'+ window.location.host+'/Generico/socket');
	
	if( socket == null ){
		console.log('Socket não conectado.');
		return;
	}
	
	socket.onopen = function(evt){ 
		onOpen(evt); 
	}; 
	socket.onclose = function(evt) { 
		onClose(evt); 
	};
	socket.onmessage = function(evt) { 
		onMessage(evt); 
	}; 
	socket.onerror = function(evt) {
		onError(evt); 
	};
};

function onMessage( evt ){
	innerChat(stringToJson(evt.data));
};

function onClose( evt ){
	innerChat(new Message('System','Conexao perdida.','MESSAGE','SYSTEM'));
};

function onError( evt ){
	
};

function onOpen ( evt ){
	innerChat(new Message('System','Conexao feita com sucesso.','MESSAGE','SYSTEM'));
	sendMessage( new Message(USER_NAME,'','HANDSHAKE','USER'));
};

//Sempre deve entrar um Json aqui.
function sendMessage( message ){
	socket.send(jsonToString(message));
};

function stringToJson( data ){
	try{
		return JSON.parse(data);
	}catch(e){
		console.error(e);
		return null;
	}
};

function jsonToString( data ){
	try{
		return JSON.stringify(data);
	}catch(e){
		console.error(e);
		return null;
	}
};