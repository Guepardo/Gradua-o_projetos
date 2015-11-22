package Improve.tipos;

import Improve.admin.Tipos;

public class Frases extends Persistir
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2694154600225639951L;

	public Frases ( boolean facil , boolean medio , boolean dificil , String conteudo , String descricao )
	{
		super(facil, medio, dificil , conteudo , descricao );
		super.tipo = Tipos.FRASE;
	}
}
