package rede;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import eventos.Eventos;

public class Servidor implements Runnable
{
	ServerSocket server = null;
	Socket cliente = null;
	
	public Servidor ( int porta )
	{
		try 
		{
			server = new ServerSocket(porta);
		}
		catch (IOException e)
		{
			//e.printStackTrace();
			System.out.println("Já existe um servidor ativo nessa máquina.");
		}
	}

	public void run()
	{
		if( server == null ) return;
		
		try 
		{
			System.out.println("Aguardando alguma conexão");
			Eventos.setOut( new ObjectOutputStream(server.accept().getOutputStream()));
			System.out.println("Servidor true live");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
