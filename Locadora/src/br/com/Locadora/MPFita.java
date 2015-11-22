package br.com.Locadora;

public class MPFita extends MapaPersistencia {

	public MPFita ()
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
