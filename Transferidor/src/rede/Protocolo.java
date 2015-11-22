package rede;

import java.io.Serializable;

import enumemacao.Tipo;

public class Protocolo implements Serializable
{
	private static final long serialVersionUID = 1L;
	private byte buffer[];
	private int parteAtual, parteTotal,cont;
	private String relativo;
	private Tipo tipo;
	
	public Protocolo ( byte[] buffer, int parteAtual, int parteTotal, String relativo, Tipo tipo, int cont )
	{
		this.buffer = buffer;
		this.parteAtual = parteAtual;
		this.parteTotal = parteTotal;
		this.relativo = relativo;
		this.tipo = tipo;
		this.cont = cont;
	}

	public byte[] getBuffer() {
		return buffer;
	}

	public int getParteAtual() {
		return parteAtual;
	}

	public int getParteTotal() {
		return parteTotal;
	}

	public String getRelativo() {
		return relativo;
	}
	
	public int getCont ()
	{
		return cont;
	}

	public Tipo getTipo() {
		return tipo;
	}
}
