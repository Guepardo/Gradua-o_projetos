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
			System.out.println("Já existe um servidor ativo nessa máquina.");
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
			System.out.println("Aguardando alguém se conectar.");
			token = server.accept();
			System.out.println("Alguém se conectou.");
			
			oos = new ObjectOutputStream( token.getOutputStream());
			
			new Thread( new Ouvir(new ObjectInputStream ( token.getInputStream() )),"Ouvindo cliente conectado").start();
		} 
		 catch (IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Já existe um servidor online nessa máquina.\n Método 'run'");
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
			JOptionPane.showInternalMessageDialog(null,"Conexão efetuada com sucesso");
		} 
		catch (IOException  e) 
		{
			JOptionPane.showMessageDialog(null,"Aconteceu algo de errado com a criação do socket\n Método 'modoCliente()' ");
			e.printStackTrace();
		}
	};
	
	public void enviarArquivos( String diretorio , int tamBuffer )
	{
		if( oos == null )
		{
			JOptionPane.showMessageDialog(null,"Erro no métido : enviarArquivos()");
			return;
		}
		arq.enviarArquivos(arq.buscarArquivos(diretorio), tamBuffer, oos);
	};
}
