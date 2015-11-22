package br.com.Iterator;

import java.util.ArrayList;

public class IteratorArrayList implements Iterator
{
	private ArrayList<Integer> colecao ;
	int indice=0;
	
	public IteratorArrayList (ArrayList<Integer> colecao)
	{
		this.colecao = colecao;
	}
	
	public int next() 
	{
		return colecao.get(indice++);
	}


	public boolean hasNext() 
	{
		return ( indice <= colecao.size()-1);
	}

}
