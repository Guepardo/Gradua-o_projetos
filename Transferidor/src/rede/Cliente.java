package rede;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import enumemacao.Tipo;
import eventos.Eventos;
import arquivos.Arquivos;

public class Cliente  implements Runnable
{
	private Socket cliente = null;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public Cliente ( String ip , int porta )//Caso uma conexão com outro servidor.
	{
		try 
		{
			cliente = new Socket(ip, porta);
			if( cliente != null) System.out.println("Conexão estabelecida");
			inicarComunicacao();
		} 
		catch ( IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public Cliente ( Socket cliente )//Caso alguém se conectar a essa máquina.
	{
		this.cliente = cliente;
	}

	public void inicarComunicacao( )
	{
		try 
		{
			ois = new ObjectInputStream( cliente.getInputStream());
			oos = new ObjectOutputStream( cliente.getOutputStream());
			new Thread(this,"Cliente rodando").start();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao iniciar a comunicação\n Erro dentro da Classe Cliente.");
		}
	}
	
	public void run() 
	{
		Arquivos arq = new Arquivos();
		String controle = null;
		OutputStream out = null;
		
		while( true )
		{
			try 
			{
				Protocolo p = ( Protocolo )  ois.readObject();
				
				if( !p.getRelativo().equals(controle) )
				{
					if( out != null) out.close();
					controle = p.getRelativo();
					arq.criaDiretorio(p.getRelativo(),p.getTipo());
					out = new FileOutputStream(p.getRelativo());
				}
				
				if( Tipo.ARQUIVO == p.getTipo() ) out.write(p.getBuffer(),0,p.getCont());
						
				
			} 
			catch (IOException | ClassNotFoundException e ) 
			{
				
			}
		}
	};
}
