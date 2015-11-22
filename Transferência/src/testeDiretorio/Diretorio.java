package testeDiretorio;

import java.io.IOException;

import nada.Arquivo;
import principal.Tipo;

public class Diretorio {

	public static void main(String[] args) throws IOException
	{
		Arquivo arq = new Arquivo();
		
		arq.criaDiretorio("\\Pasta\\Pasta1",Tipo.ARQUIVO);

	}

}
