/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.administrativo;

import chat.tipos.Pessoas;
import chat.tipos.Usuario;

public class ControlarUsuario extends Controlador
{

	public ControlarUsuario ()
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

	public Usuario obter(int id)
	{
		return (Usuario) super.obter(id);
	}
}
