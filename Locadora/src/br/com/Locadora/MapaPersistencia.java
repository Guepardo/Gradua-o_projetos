package br.com.Locadora;

import java.util.ArrayList;

public abstract class MapaPersistencia 
{
	protected ArrayList<ItemPersistencia> arl;
	int indice;
	
	public MapaPersistencia ()
	{
		arl = new ArrayList<ItemPersistencia>();
	}
	
	public boolean persistido ( int id )
	{
		indice = 0 ;
		
		for( ItemPersistencia aux  : arl )
		{
			if( id == aux.getId())return true;
			indice++;
		}
		return false;
	}
	
	public abstract void inserirArmazem ( ItemPersistencia ob );
	public abstract void excluirArmazem ( int indice);
	
	public boolean inserir ( ItemPersistencia ob )
	{
		if( !persistido(ob.getId()) )
		{
			inserirArmazem(ob);
			return true;
		}
		return false;
	}
	
	public boolean excluir ( int id )
	{
		if (persistido(id))
		{
			excluirArmazem(indice);
			return true;
		}
		return false;
	}
	
	public Iterator obterIterator()
	{
		return new Iterator(arl);
	}
	
	public ItemPersistencia getElement ( int id )
	{
		if(persistido(id)) return arl.get(indice);
		return null;
	}
}
