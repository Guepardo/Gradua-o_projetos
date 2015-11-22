package Improve.tipos;

import java.util.ArrayList;

import Improve.admin.Tipos;

public class Palavras extends Persistir
{
	private static final long serialVersionUID = -1473213296427822348L;
	ArrayList<Integer> arl;
	
	public Palavras(boolean facil, boolean medio , boolean dificil , String conteudo , String descricao  ) 
	{
		super(facil, medio, dificil , conteudo , descricao);
		super.tipo = Tipos.PALAVRA;
		arl = new ArrayList<>();
	}

	public ArrayList<Integer> getArl() {
		return arl;
	}

	public void setArl(int indice ) {
		if( arl == null ) arl = new ArrayList<>();
		arl.add(indice);
	}
	
	public void arlNull()
	{
		arl = null;
	}
}
