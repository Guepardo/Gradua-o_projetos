package br.com.Locadora;

public class Locacao extends ItemPersistencia
{
	int idf,idc;
	
	public Locacao ( int id , int idf , int idc )
	{
		super(id);
		this.idf = idf;
		this.idc = idc;
		classe = Classe.LOCACAO;
		
	}

	public int getIdf() {
		return idf;
	}

	public int getIdc() {
		return idc;
	}
}
