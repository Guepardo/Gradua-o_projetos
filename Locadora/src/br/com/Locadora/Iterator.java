package br.com.Locadora;

import java.util.ArrayList;

public class Iterator 
{
	ArrayList<ItemPersistencia> arl;
	int indice;
	
	public Iterator ( ArrayList<ItemPersistencia> arl )
	{
		this.arl = arl;
		indice = 0 ;
	}
	
	public Iterator ( Iterator it)
	{
		arl = it.arl;
	}
	
	public boolean proximo ()
	{
		if( indice < arl.size()-1){ indice++; return true;};
		return false;
	}
	
	public boolean anterior ()
	{
		if( indice > 0 ) {indice--; return true;}
		return false;
	}
	
	public ItemPersistencia obter ()
	{
		return (arl.get(indice));
	}
	
	public void fim ()
	{
		indice = arl.size()-1;
	}
	
	public void inicio ()
	{
		indice = 0;
	}
	
}
