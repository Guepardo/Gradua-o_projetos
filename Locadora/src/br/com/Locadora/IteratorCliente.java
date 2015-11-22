package br.com.Locadora;

import java.util.ArrayList;

public class IteratorCliente extends Iterator
{
	public IteratorCliente(ArrayList<ItemPersistencia> arl) 
	{
		super(arl);
	}
	
	public Cliente obter ()
	{
		return (Cliente) super.obter();
	}

}
