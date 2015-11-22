/*M√©todos e vari·veis globais.*/
var checkStrong = false; // Checa a altern‚ncia entre opaco e a cor normal no chat.
var USER_NAME   = prompt('Entre com o seu nome: ');

//Arquivos de ·udio para o chat
var SOUND_ON_MESSAGE     = 1;
var SOUND_CLOSE          = 2;
var SOUND_ON_OPEN        = 3;
var SOUND_ON_MENTION     = 4;

//Objeto mensagem
function Message( namePeer, message, type, userType ){
	this.namePeer = namePeer;
	this.message  = message;
	this.type     = type;
	this.userType = userType;
};

/*Executa quando o documento est· pronto*/
$('document').ready(function(){
	//incializando sons
	$('#sound').attr('src',SOUND_ON_MESSAGE + '.mp3');
	
	
	$('#enter-message').keypress( function(event){
		if( event.which == 13 ){
			var messageEnter = $('#enter-message');
			
			if( messageEnter.val() != ''){
				var temp = new Message(USER_NAME,messageEnter.val(),'MESSAGE','USER');
				innerChat(temp);
				sendMessage(temp);
				messageEnter.val('');
			}else{
				console.log('conteudo em branco');
			}
		}
	});
	
	chatBoxResize();
});


//Insere um texto no chat
function innerChat( message ){
	var now = new Date();
	var temp = '<i class="fa fa-spinner fa-spin"></i><li> <table><tr><td id="innerChat"><span class="user-name">'+message.namePeer+'</span>: '+message.message+'</td><td id="time">'+now.getHours()+':'+now.getMinutes()+'</td><tr></table></li>'
	$('#log').append(temp);
	scrollDown();
	if( checkStrong ){
		$('table').last().addClass('strong');
		checkStrong = false;
		}else{
			checkStrong = true;
		}
	mentionUpdate();
	playSound(SOUND_ON_MESSAGE);
}


//Colocar o scroll no fim da conversa.
function scrollDown(){
	var box = $('#chat-log');
	box.scrollTop($('#log').height());
}


//Redimensiona os elementos do chate de acordo com a dimens√£o do monitor do usu√°rio.
function chatBoxResize(){
	var tamInput = 20;
	var tamBars  = 50;
	var altura   = window.innerHeight;
	$('#window-chat').css('height', (altura - 2 * tamBars ) - tamInput + 'px' );
}


//Mens√£o a outras pessoas no chat.
function mentionUpdate(){
	var last = $('.user-name').last();
	last.click(function() {
		if( $(this).text() == USER_NAME  ) return;
		var value = $('#enter-message').val();
		value  += ' '+'<span class="mention">'+$(this).text()+'</span>';
		$('#enter-message').val(value);
	});
}


//fun√ß√£o que toca um som na janela principal
function playSound( soundId ){
	$('#sound').trigger("play");
}