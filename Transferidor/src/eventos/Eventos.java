package eventos;

import java.io.ObjectOutputStream;
import java.util.ArrayList;

import arquivos.Arquivos;
import enumemacao.Registro;
import rede.Cliente;
import rede.Servidor;

public class Eventos 
{
	 private ObjectOutputStream oos;
	 private Thread servidor = null;
	 private Arquivos arq;
	
	public Eventos ( )
	{
		servidor = new Thread( new Servidor(28000), "Servidor Rodando.");
		servidor.start();
		arq = new Arquivos();
	};
	
	public void conectarServidor(String ip , int porta )
	{
		try
		{
			servidor.join();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		new Cliente(ip,porta);
	};
	
	private void enviarArquivos( ArrayList<Registro> colecao , int tamBuffer)// Envia uma coleção de arquivos.
	{
		arq.enviarArquivos(colecao, tamBuffer, oos);
	};
	
	public void mandarArquivos(String dir )
	{
		enviarArquivos(arq.buscarArquivos(dir),1024);
	}
}
