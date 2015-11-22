package br.com.Locadora;

public class MPCliente extends MapaPersistencia
{
	public MPCliente ()
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
