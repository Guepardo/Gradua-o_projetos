/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */
package chat.administrativo;

import chat.tipos.Amigos;
import chat.tipos.Pessoas;

public class ControlarAmigos extends Controlador
{

	public ControlarAmigos()
	{
		super();
	}
		
	public boolean inserirPessoas(Pessoas p) 
	{	
		colecao.add(p);
		return true;
	}

	public boolean excluirPessoas(int id) 
	{
		colecao.remove(indice);
		return true;
	}

	public Amigos obter (int id)
	{
		return (Amigos) super.obter(id);
	}
}
