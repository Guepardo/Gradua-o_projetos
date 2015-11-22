package br.com.template;

import java.util.ArrayList;

public abstract class Ordenador 
{
	private ArrayList<Musicas> colecao; 
	
	public Ordenador ( ArrayList<Musicas> musicas)
	{
		colecao = musicas;
	}
	
	public abstract boolean fatorDeTroca( Musicas m1 , Musicas m2);
	
	
	public ArrayList<Musicas> ordenar()
	{
		boolean flag = true;
		
		while( flag )
		{
			flag = false;
			
			for( int i = 0 ; i < colecao.size()-1 ; i++)
			{
					if( fatorDeTroca( colecao.get(i) , colecao.get(i+1) ) )
					{
						Musicas tem = colecao.get(i);
	                    colecao.set(i, colecao.get(i+1));
	                    colecao.set(i+1, tem);
	                    flag = true;
					}	
			}
		}
		return colecao;
	}
	
}
