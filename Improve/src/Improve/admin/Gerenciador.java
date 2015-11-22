package Improve.admin;


import java.util.ArrayList;

import adm.Arquivo;
import Improve.tipos.Frases;
import Improve.tipos.Persistir;

public abstract class Gerenciador 
{
	protected ArrayList<Persistir> colecao;
	protected Arquivo arq;
	protected int indice;
	
	
	public Gerenciador()
	{
		colecao = null;
		indice = 0 ;
	}
	
	
	public boolean haNaColecao (String conteudo )
	{
		for( indice = 0 ; indice < colecao.size(); indice++ )
		{
			if( colecao.get(indice).getConteudo().toLowerCase().equals(conteudo.toLowerCase()) ) return true;
		}
		
		return false;
	}
	
	
	public abstract boolean inserir  ( Persistir ob );
	public abstract boolean retirar  ( Persistir ob );
	public abstract boolean atualizar( Persistir ob);
	
	
    public ArrayList<Persistir> obterColecao()
    {
    	return colecao;
    }
}
