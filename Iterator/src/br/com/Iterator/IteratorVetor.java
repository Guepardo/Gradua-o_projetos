package br.com.Iterator;

public class IteratorVetor implements Iterator
{
	private int [] vetor  ;
	private int indice = 0; 
	
	public IteratorVetor(int [] vetor )
	{
		this.vetor = vetor;
	}
	
	public int next() 
	{
		return vetor[indice++];
	}


	public boolean hasNext() 
	{
		return (indice <= vetor.length-1 );
	}

}
