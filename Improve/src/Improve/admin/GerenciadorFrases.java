package Improve.admin;

import adm.Arquivo;
import Improve.tipos.Palavras;
import Improve.tipos.Persistir;

public class GerenciadorFrases extends Gerenciador
{
	public GerenciadorFrases()
	{
		super();
		arq = new Arquivo("Frases.bin");
		colecao = arq.recuperar();
	}

	
	public boolean inserir(Persistir ob)
	{
		if(!super.haNaColecao(ob.getConteudo()))
		{
			super.colecao.add(ob);
			arq.gravar(colecao);
			return true;
		}
		return false;
	}


	public boolean retirar(Persistir ob)
	{
		if(super.haNaColecao(ob.getConteudo()))
		{
			super.colecao.remove(indice);
			arq.gravar(colecao);
			return true;
		}
		return false;
	}


	public boolean atualizar(Persistir ob) 
	{
		retirar(ob);
		return inserir(ob);
	}
}
