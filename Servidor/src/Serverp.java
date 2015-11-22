import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Serverp {

	public static void main(String[] args) throws IOException 
	{
		    ServerSocket serverSocket = new ServerSocket(4343, 10);
	        Socket socket = serverSocket.accept();
	        InputStream is = socket.getInputStream();
	        OutputStream os = socket.getOutputStream();
	        int tamBuffer = 2000;
	        
	        // Receiving
	        byte[] buffer = new byte[tamBuffer];
	        is.read(buffer);
	        String received = new String(buffer);

	        System.out.println("Server received: " + received);

	        // Sending
	        String [] texto = {"adfasdfasdfasdfasdf","asdfasdfaakkkkkkkkkkkkkkkkkkkkkkkk","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadfdaf"};
	        
	        for( String a : texto )
	        {
	        	
	        	String toSend = a;
	        	buffer = toSend.getBytes();
	        	os.write(buffer);
	        }
	        socket.close();
	        serverSocket.close();

	}

}
