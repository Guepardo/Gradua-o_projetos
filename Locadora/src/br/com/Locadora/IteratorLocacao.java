package br.com.Locadora;

import java.util.ArrayList;

public class IteratorLocacao extends Iterator
{

	public IteratorLocacao(ArrayList<ItemPersistencia> arl)
	{
		super(arl);
	}

	public Locacao obter ()
	{
		return (Locacao) super.obter();
	}
}
