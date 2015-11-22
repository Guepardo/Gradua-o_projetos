package source;


import java.io.IOException;
import java.util.Collection;
import java.util.Hashtable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value ="/socket")
public class Server {

	//Armazenar Clientes conectados no server.
	private static Hashtable<Session,Usuario> userList = new Hashtable<>();
	private static Json json = null;
	private static short count = 0;
	
	@OnMessage
	public void onMessage( String jsonMessage , Session session ){
		if(json == null){
			json = new Json();
		}
		
		Transport transport = json.Decoder(jsonMessage);
		
		if( !isHandShake(transport) ){
			if(transport.getMessage().contains("ShowLog")){
				prepareLog(session);
			}else{
				sendToAll(transport,session);
			}
		}else{
			userList.get(session).setName(transport.getNamePeer());
		}
	};
	
	//Adiciona un novo cliente na lista oficial de usuários.
	@OnOpen
	public void onOpen( Session session ) {
		count++;
		userList.put(session,new Usuario( session ));
		sendToAll(new Transport("@Server","Uma pessoa entrou no chat.","",""),session);
	};
	
	@OnClose
	public void onClose( Session session) {
		count--;
		sendToAll(new Transport("@Server","["+userList.get(session).getName() + "] Saiu do chat.","",""),session);
		userList.remove(session);
	};
	
	private boolean isHandShake( Transport transport ){
		return ( transport.getType().equals(Type.HANDSHAKE.toString()) );
	}
	
//	@OnError
//	public void onError( Session session ) throws ServletException{
//		listUser.remove(session);
//	};
	
	//Envia uma mensagem enviado por um usuário para o restanto do 
	//grupo (Broadcast). Não é enviado a mensagem para a pessoa que 
	//a enviou, o código do que rodará no navegador do cliente é 
	//encarregado de replicar o que ele escreveu no chat.
	private void sendToAll( Transport TransMessage, Session session ){
		Collection<Usuario> temp = userList.values();
		for( Usuario user : temp ){
			try {
				if( user.getSession() == session ) continue;
				user.sendMessage(TransMessage);
			} catch (IOException e) {
				userList.remove(user.getSession());
			}
		}
	};
	
	//Cria um texto de log e o envia para a session que a requisitou.
	private void prepareLog( Session session ){
		Collection<Usuario> temp = userList.values();
		String log = "Há "+ count +" conexões ativas no servidor neste momento. Nome dos conectados: ";
		for( Usuario user : temp ){
			log += user.getName()+", ";
		}
		try {
			userList.get(session).sendMessage(new Transport("@Server",log,"",""));
		} catch (IOException e) {
			e.printStackTrace();
		}
	};
}
