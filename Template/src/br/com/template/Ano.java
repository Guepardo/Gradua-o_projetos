package br.com.template;

import java.util.ArrayList;

public class Ano extends Ordenador
{
	
	public Ano(ArrayList<Musicas> musicas) 
	{
		super(musicas);
	}

	public boolean fatorDeTroca(Musicas m1, Musicas m2) 
	{
		return( m1.getAno() < m2.getAno());
	}

}
