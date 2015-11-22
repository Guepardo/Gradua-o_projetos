			var thread = null;
			var player = null;
			var content = null;
			var array = null;
			var checker = null;
			var correntQuestion = null;
			var videoControler = false;
			var isRunning = false;
			var acertos = 0;
			var erros = 0;
			var lock = false;
			
			window.onload = function (){
				array   = new Array();
				checker = new Array();
				content = document.getElementById("content");
				createVideo('aguardando', true );
				thread = setInterval(function(){theObserver()},100);
				beginPergunta();
				randomQuestion();
				countPoints('null');
			}
			
			function isEnded(){	
				return player.ended;
			}
			
			function theObserver(){
				if( isEnded() ){
					randomQuestion();
					unmarkAnswer();
					createVideo('aguardando', true );
				}
				congratulations();
			}
			
			function removeVideo(){
				document.getElementById('player').remove();
			}
			
			function createVideo( tipo , isLoop ){
				
				if( videoControler )removeVideo();
				
				videoControler = true;
				
				player = document.createElement('video');
				
				player.src = tipo + '.mp4';
				player.type = 'video/mp4';
				player.id = 'player';
				if( isLoop ){
					player.loop = true;
					isRunning = false;
				}else{
					isRunning = true;
				 }
				content.appendChild(player);
				
				player.play();
			}
			
			function pergunta( enunciado,a,b,c,d,resposta){
				this.enunciado = enunciado;
				this.a = a;
				this.b = b;
				this.c = c;
				this.d = d;
				this.resposta = resposta;
				
				this.getAnswer = function ( asnwer ){
					console.log( asnwer +'  '+ resposta );
					if( asnwer  === this.resposta ){
						return true;
					}else{
						return false;
					}
				}
			}
			
			function beginPergunta( ){
				array.push( new pergunta('Quem é o presidente do Brasil?','Dilma','Alguém','Fulano','Ciclano','A'));
				array.push( new pergunta('1+1=?','1','2323','2*4/4','Nenhuma resposta está correta','C'));
				//array.push( new pergunta('Complete: no céu tem___?','Nuvens','Jeová','Pão','Deus','C'));
				//array.push( new pergunta('A cidade de Goiás fica em qual estado?','Maranhão','Terra Do Pequi','U.S.A','Casa do Caralho!','B'));
				//array.push( new pergunta('O que é isso?', 'Um site', 'Alguma coisa', 'Lindo', 'Muito forte', 'D'));
				//array.push( new pergunta('Quem inventou o macarrão?','Franceses','Italianos','Chineses', 'Chico do buteco da esquina','C'));
				//array.push( new pergunta('Qual a profissão do Latino (cantor)?','Dono de papelaria','Dizem que é um cantor, mas só sabe copiar','Roda bolsinha na esquina','Vende drogas na esquina','B'));
			}
			
			function testAnswer( asnwer ){
				if( isRunning || lock ){
					return;
				}
				markAnswer( asnwer );
				
				if( correntQuestion.getAnswer( asnwer ) ){
					console.log("Acertou!");
					createVideo('acerto',false);
					countPoints('acerto');
				}
				else{
					console.log("Errou!");
					createVideo('erro',false);
					countPoints('errado');
				}
			}
			function markAnswer( asnwer){
				var correct   = document.getElementById( correntQuestion.resposta );
				var incorrect = document.getElementById( asnwer );
				
				if( correntQuestion.getAnswer( asnwer )){
					correct.className = 'acerto';
					return;
				 }
				correct.className   = 'acerto';
				incorrect.className = 'errado';
			}
			
			function unmarkAnswer(){
				var array = document.getElementsByTagName('input');
				for( var a = 0 ; a < array.length ; a++ ){
					array[a].className = 'normal';
				}
			}
			
			function randomQuestion(){
				var index = Math.floor((Math.random()*array.length));
				var check = true;
				var internalCheck = false;
				
				if( checker.length === array.length){
					lock = true;
					console.log('Já foram respondidas todas as questões');
					return;
				}
				
				while( check ){
					index = Math.floor((Math.random()*array.length));
					internalCheck = false;
					
					for( var a = 0 ; a < checker.length ; a++ ){
					    if( index === checker[a] ){
							internalCheck = true;
							break;
						}
					}
					
					if( !internalCheck ){
						checker.push(index);
						check = false;
					}
				}
				
				createQuestion(array[index]);
			}
			
			function createQuestion( question ){
				var enunciado = document.getElementById('enunciado');
				var a = document.getElementById('A');
				var b = document.getElementById('B');
				var c = document.getElementById('C');
				var d = document.getElementById('D');
				
				enunciado.innerHTML = question.enunciado;
				a.value = 'A) - ' + question.a;
				b.value = 'B) - ' + question.b;
				c.value = 'C) - ' + question.c;
				d.value = 'D) - ' + question.d;
				
				correntQuestion = question;
			}
			
			function countPoints( mode ){
				var points = document.getElementById('points');
				
				if( mode === 'null'){
					points.innerHTML = 'Acertos: '+ acertos +' Burrices: '+   erros +'';
				}else if( mode === 'acerto'){
					points.innerHTML = 'Acertos: '+ ++acertos +' Burrices: '+ erros +'';
				}else if( mode === 'errado'){
					points.innerHTML = 'Acertos: '+  acertos +' Burrices: '+ ++erros +'';
				}
			}
			
			function congratulations(){
				if( !lock ) return;
				lock = false;
				var phrase = '-----Fim de Jogo----- \n';
				
				if( acertos === erros ){
					phrase +='Sua burrice quase transcede os seus acertos.\nAperte OK para ver uma mensagem de consolo.';
				}else if( acertos > erros) {
					phrase +='Caetano acha você inteligente. Continue assim, filhão!\nPor esse motivo, Caetano disse que você pode se divertir conversando com seus amigos no Facebook.';
				}else if( acertos < erros){
					phrase +='Caetano está impressionado com a sua burrice. Até agora ele não entende o que você disse.\n Caetano lhe recomenda ler mais, comece a ler o Wikipedia, primeiramente pelo artigo que fala sobre o Caetano.';
				}
				
				alert(phrase);
				
				if( acertos === erros ){
					document.location = 'http://img3.wikia.nocookie.net/__cb20130917044500/glee/images/b/bc/You_tried_.png';
				}else if( acertos > erros) {
					document.location = 'https://www.facebook.com';
				}else if( acertos < erros){
					document.location = 'http://pt.wikipedia.org/wiki/Caetano_Veloso';
				}
			}