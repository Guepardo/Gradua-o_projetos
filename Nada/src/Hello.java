import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.catalina.Session;




@ServerEndpoint("/Hello")
public class Hello {
	
		private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());
	
	 @OnMessage
	 public String  onMassege ( String message ){
		 return null;
	 }
	 
	 @OnOpen
	 public void onOpen( Session peer ){
		 peers.add( peer );
	 }
	 
	 @OnClose
	 public void onClose( Session peer ){
		 peers.remove( peer );
	 }
}
