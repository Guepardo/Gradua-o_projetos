package Improve.tipos;

import java.io.Serializable;

import Improve.admin.Tipos;

public class Persistir implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3920442466310856591L;
	protected Tipos tipo;
	protected boolean facil, medio , dificil,branco;
	protected String conteudo,descricao;
	protected int contador;
	
	public Persistir ( boolean facil , boolean medio , boolean dificil , String conteudo , String descricao )
	{
		this.facil    = facil;
		this.dificil  = dificil;
		this.medio    = medio;
		this.conteudo = conteudo;
		contador = 0;
		this.descricao = descricao;
	}
	
	public int getContador() {
		return contador;
	}

	public void setContador() {
		contador++;
	}

	public boolean isFacil() {
		return facil;
	}

	public void setFacil(boolean facil) {
		this.facil = facil;
	}

	public boolean isMedio() {
		return medio;
	}

	public void setMedio(boolean medio) {
		this.medio = medio;
	}

	public boolean isDificil() {
		return dificil;
	}

	public void setDificil(boolean dificil) {
		this.dificil = dificil;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipos getTipo() {
		return tipo;
	}
	
	public boolean isBranco() {
		return branco;
	}

	public void setBranco(boolean branco) {
		this.branco = branco;
	}
}
