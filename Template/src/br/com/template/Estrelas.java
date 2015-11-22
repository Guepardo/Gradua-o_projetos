package br.com.template;

import java.util.ArrayList;

public class Estrelas extends Ordenador
{
	
	public Estrelas ( ArrayList<Musicas> musicas)
	{
		super(musicas);
	}
	
	public boolean fatorDeTroca(Musicas m1, Musicas m2) 
	{
		return ( m1.getEstrelas() < m2.getEstrelas() );
	}

}
