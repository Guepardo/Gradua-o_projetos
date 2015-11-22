package br.com.Locadora;

import java.util.Hashtable;

public class Persistencia 
{
	private static Persistencia p = null;
	private Hashtable<Classe, MapaPersistencia> mapa;
	
	public Persistencia ( )
	{
		mapa = new Hashtable<Classe, MapaPersistencia>();
		mapa.put(Classe.CLIENTE, new MPCliente() );
		mapa.put(Classe.FITA, new MPFita());
		mapa.put(Classe.LOCACAO, new MPLocacao());
	}
	
	public boolean inserir ( ItemPersistencia ob )
	{
		return mapa.get(ob.getClasse()).inserir(ob);
	}
	
	public boolean excluir ( Classe classe , int id )
	{
		return mapa.get(classe).excluir(id);
	}
	
	public ItemPersistencia obterItem (Classe classe, int id )
	{
		return mapa.get(classe).getElement(id);
	}
	
	public IteratorCliente obterIteratorCliente ()
	{
		return new IteratorCliente(mapa.get( Classe.CLIENTE).obterIterator().arl );
	}
}
