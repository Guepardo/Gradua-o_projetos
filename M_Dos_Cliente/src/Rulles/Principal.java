package Rulles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;



public class Principal {
	static PrintStream ps = null; 
	static Socket  socket = null;
	static BufferedReader entrada=null; 
	
	public static void main(String[] args) {
		  String chat = "";
		  boolean flag = true;
		  
		  try{
			  socket = new Socket("127.0.0.1",28000);
			  ps = new PrintStream(socket.getOutputStream());
			  entrada = new BufferedReader(new InputStreamReader( socket.getInputStream()));
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
