package testes1;

import eventos.Eventos;
import arquivos.Arquivos;

public class Tcliente {

	public static void main(String[] args) 
	{
		Eventos evento = new Eventos();
		
		evento.conectarServidor("192.168.0.18",28000);
		Arquivos ar = new Arquivos();
		
		evento.mandarArquivos("C:\\Users\\Allysom\\Desktop\\Nova Pasta");
	}

}
