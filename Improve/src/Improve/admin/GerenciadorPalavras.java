package Improve.admin;

import java.util.ArrayList;

import adm.Arquivo;
import Improve.tipos.Palavras;
import Improve.tipos.Persistir;

public class GerenciadorPalavras extends Gerenciador
{
	
	
	public GerenciadorPalavras ()
	{
		super();
		super.arq     = new Arquivo("Palavras.bin");
		super.colecao = arq.recuperar();
	}
	
	
	public boolean inserir( Persistir ob )
	{
		if( !super.haNaColecao( ob.getConteudo() ) )
		{
			super.colecao.add(ob);
			arq.gravar(colecao);
			return true;
		}
		return false;
	}


	public boolean retirar( Persistir ob )
	{
		if( super.haNaColecao( ob.getConteudo() ) )
		{
			super.colecao.remove(indice);
			arq.gravar(colecao);
			return true;
		}
		return false;
	}
	
	
	public ArrayList<Palavras> gerarContexto( ArrayList<Persistir> ap )
	{
		ArrayList<Palavras> temp = new ArrayList<>();
		
		for( int i = 0 ; i < super.colecao.size(); i++ )
		{
			Palavras p = (Palavras) colecao.get(i);
			p.arlNull();
			temp.add( p );
			
			for(int x = 0 ; x < ap.size() ; x++ )
			{
				if( ap.get(x).getConteudo().toLowerCase().contains(colecao.get(i).getConteudo().toLowerCase()) )
				{
					temp.get(i).setArl(x);
				}
			}
		}
		
		return temp;
	}


	public boolean atualizar(Persistir ob)
	{
		Palavras temp = ( Palavras ) ob;
		retirar(temp);
		return inserir(temp);
	}
}
