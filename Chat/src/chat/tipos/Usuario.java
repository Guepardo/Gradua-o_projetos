/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.tipos;


public class Usuario extends Pessoas
{
	private String senha;
	
	public Usuario(String nome , String nick, String usuario , int id , String senha)
	{
		super(nome,nick, usuario,id);
		this.senha = senha;
		classe = Classe.USUARIO;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
