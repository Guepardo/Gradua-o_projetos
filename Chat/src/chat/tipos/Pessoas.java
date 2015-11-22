/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.tipos;


public class Pessoas 
{
	private String nick,nome,usuario;
	private int    id;
	protected Classe classe;
	
	public Pessoas( String nome , String nick , String usuario , int id )
	{
		this.id = id;
		this.nick = nick;
		this.nome = nome;
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
