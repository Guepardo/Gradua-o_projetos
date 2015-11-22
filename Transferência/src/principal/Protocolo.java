package principal;

import java.io.Serializable;

public class Protocolo implements Serializable
{
	private byte buffer[];
	private long parteAtual, parteTotal;
	int cont;
	private String relativo;
	private Tipo tipo;
	
	public Protocolo ( byte[] buffer, long parteAtual, long parteTotal, String relativo, Tipo tipo, int cont )
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

	public long getParteAtual() {
		return parteAtual;
	}

	public long getParteTotal() {
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
