package source;


public class Transport {
	String namePeer;//Name of the peer.
	String message; //Content of the message
	String type; 		//Type of the message
	String userType;  //Type of the user.
	
	Transport(){
		message      = null;
		type         = null;
		userType     = null;
		namePeer     = null;
	};
	
	Transport(String namePeer, String message , String type , String userType ){
		this.message = message;
		this.type = type;
		this.namePeer = namePeer;
		this.userType = userType;
	};

	public String getNamePeer() {
		return namePeer;
	};

	public void setNamePeer(String namePeer) {
		this.namePeer = namePeer;
	};

	public String getUserType() {
		return userType;
	};

	public void setUserType(String userType) {
		this.userType = userType;
	};

	public String getMessage() {
		return message;
	};

	public void setMessage(String message) {
		this.message = message;
	};

	public String getType() {
		return type;
	};

	public void setType(String type) {
		this.type = type;
	};	
}
