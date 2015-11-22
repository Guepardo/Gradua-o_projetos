/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.tipos;


public class Amigos extends Pessoas
{
	private Classe status,statusAmizade;
	
	public Amigos(String nome , String nick , String usuario , int id ,Classe status , Classe statusAmizade )
	{
		super(nome,nick, usuario,id);
		this.status = status;
		this.statusAmizade = statusAmizade;
		classe = Classe.AMIGO;
	}

	public Classe getStatus() 
	{
		return status;
	}

	public Classe getStatusAmizade() {
		return statusAmizade;
	}

	public void setStatusAmizade(Classe statusAmizade) {
		this.statusAmizade = statusAmizade;
	}

	public void setStatus(Classe status) 
	{
		
		this.status = status;
	}

}
