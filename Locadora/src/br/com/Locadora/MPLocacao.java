package br.com.Locadora;

public  class MPLocacao extends MapaPersistencia
{
	public MPLocacao ()
	{
		super();
	}
	
	public void inserirArmazem(ItemPersistencia ob) 
	{
		super.arl.add(ob);
	}

	public void excluirArmazem(int indice) 
	{
		super.arl.remove(indice);
	}

}
