package source;


import java.io.IOException;

import javax.websocket.Session;

public class Usuario {
	private String namePeer;
	private Type   userType;
	private Session session;
	
	Usuario( Session session ){
		this.session = session;
	};
	
	//Usa um objeto 'Json' para encondar um objeto de 'Transport' para Json.
	public void sendMessage(Transport message ) throws IOException{
		//new Transport(namePeer,message,Type.MENSSAGE,userType) deixa aqui.

		Json json = new Json();
		session.getBasicRemote().sendText(json.Encoder(message));
	};
	
	public String getNamePeer() {
		return namePeer;
	}

	public void setNamePeer(String namePeer) {
		this.namePeer = namePeer;
	}

	public Type getUserType() {
		return userType;
	}

	public void setUserType(Type userType) {
		this.userType = userType;
	}

	//Função chamada após a conexão de um Peer na aplicação.
	//Ela termina de configurar as informações do Peer dentro da aplicação.
	public void handShake( String namePeer, Type userType ){
		this.namePeer = namePeer;
		this.userType = userType;
	}
	
	public String getName() {
		return namePeer;
	};

	public void setName(String namePeer ) {
		this.namePeer = namePeer;
	};
	
	public Session getSession(){
		return this.session;
	};
	
}
