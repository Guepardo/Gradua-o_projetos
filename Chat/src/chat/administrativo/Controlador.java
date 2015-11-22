/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */
package chat.administrativo;

import java.util.ArrayList;

import chat.rede.Rede;
import chat.tipos.Msg;
import chat.tipos.Pessoas;

public abstract class Controlador extends Rede
{
	protected ArrayList<Pessoas> colecao;
	protected int indice;
	
	
	public Controlador()
	{
		indice = 0;
	}
	
	
	public boolean jaExiste (int id)
	{
		for(indice = 0 ; indice < colecao.size(); indice++ )
		{
			if(colecao.get(indice).getId() == id )return true;
		}
		return false;
	}
	
	
	public boolean inserir (Pessoas p)
	{
		if(!jaExiste(p.getId())) return inserirPessoas(p);
		return false;
	}
	
	
	public boolean excluir(int id)
	{
		if(jaExiste(id)) return excluirPessoas(id);
		return false;
	}
	
	
	public abstract boolean inserirPessoas(Pessoas p);
	public abstract boolean excluirPessoas(int id);
	
	
	public Pessoas obter(int id)
	{
		if(jaExiste(id))return colecao.get(indice);
		return null;
	}
	
	
	public ArrayList<Pessoas> obterColecao(String usuario , String hash)
	{
		colecao =  super.listarContatos(usuario, hash);
		return colecao;
	}
	
	
	public ArrayList<Msg> haNovasMsgs()
	{
		return null;
	}
}
