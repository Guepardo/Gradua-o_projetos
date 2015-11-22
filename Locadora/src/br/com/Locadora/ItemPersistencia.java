package br.com.Locadora;

public class ItemPersistencia 
{
	private int id;
	Classe classe;
	
	public ItemPersistencia(int id )
	{
		this.id = id;
	}

	public Classe getClasse() {
		return classe;
	}

	public int getId() {
		return id;
	}
	
}
