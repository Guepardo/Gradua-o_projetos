package Jamaica;
import java.util.Scanner;
import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class Principal {
	
	static ServerSocket   server = null;
	static Socket         socket = null;
	static BufferedReader entrada = null;
	static PrintStream ps = null; 
	
	
	  public static void main ( String [] args ){
		  String chat = "";
		  boolean flag = true;
		  
		  try{
			  server =  new ServerSocket(28000);
			  socket = server.accept();
			  entrada = new BufferedReader( new InputStreamReader(socket.getInputStream()));
			  ps = new PrintStream(socket.getOutputStream());
			  
		     }
		     catch(IOException erro)
		     {
		    	 JOptionPane.showMessageDialog(null,"Falha ao conectar.");
		     }
		  
		 
		      Runnable receber = new Receber();   new Thread(receber,"Receber").start();
		      Scanner input = new Scanner( System.in );
		      
		      while( flag )
		      {
		    	  chat = input.nextLine();
		    	  Enviar(chat);
		      }
			 	  
	  }
	  
	  
	  public static void Enviar ( String chat )
	  {
		  ps.println(chat);
	  }
}
