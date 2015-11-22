package principal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import nada.Arquivo;

public class Evento implements Runnable
{
	private ObjectOutputStream oos;
	private ServerSocket server;
	private static  Socket token;
	private Thread servidorThread;
	private Arquivo arq;
	
	public Evento ( int porta ) 
	{
		try 
		{
			server = new ServerSocket( porta );
		}
		catch (IOException e) 
		{
			System.out.println("J� existe um servidor ativo nessa m�quina.");
			e.printStackTrace();
		}
		arq = new Arquivo();
		servidorThread = new Thread(this,"Servidor rodando");
		servidorThread.start();
	};
	
	public void run()
	{
		 try
		{
			System.out.println("Aguardando algu�m se conectar.");
			token = server.accept();
			System.out.println("Algu�m se conectou.");
			
			oos = new ObjectOutputStream( token.getOutputStream());
			
			new Thread( new Ouvir(new ObjectInputStream ( token.getInputStream() )),"Ouvindo cliente conectado").start();
		} 
		 catch (IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"J� existe um servidor online nessa m�quina.\n M�todo 'run'");
		}
	};
	
	public void modoCliente( String ip , int porta )
	{
		
		try 
		{
			//if( servidorThread != null )servidorThread.join();
			token = new Socket(ip,porta);
			oos = new ObjectOutputStream( token.getOutputStream());
			new Thread( new Ouvir(new ObjectInputStream ( token.getInputStream() )),"Ouvindo cliente conectado").start();
			JOptionPane.showInternalMessageDialog(null,"Conex�o efetuada com sucesso");
		} 
		catch (IOException  e) 
		{
			JOptionPane.showMessageDialog(null,"Aconteceu algo de errado com a cria��o do socket\n M�todo 'modoCliente()' ");
			e.printStackTrace();
		}
	};
	
	public void enviarArquivos( String diretorio , int tamBuffer )
	{
		if( oos == null )
		{
			JOptionPane.showMessageDialog(null,"Erro no m�tido : enviarArquivos()");
			return;
		}
		arq.enviarArquivos(arq.buscarArquivos(diretorio), tamBuffer, oos);
	};
}
