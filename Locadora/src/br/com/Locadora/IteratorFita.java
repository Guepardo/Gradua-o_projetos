package br.com.Locadora;

import java.util.ArrayList;

public class IteratorFita extends Iterator
{

	public IteratorFita(ArrayList<ItemPersistencia> arl) 
	{
		super(arl);
	}

	public Fita obter ()
	{
		return (Fita) super.obter();
	}
}
