package enumemacao;

public class Registro 
{
	private String absoluto,relativo;
	private boolean arquivo;
	private long tamanho;
	
	public Registro( String absoluto, String relativo, boolean arquivo , long tamanho)
	{
		this.absoluto = absoluto;
		this.relativo = relativo;
		this.arquivo = arquivo;
		this.tamanho = tamanho;
	}

	public String getAbsoluto() {
		return absoluto;
	}

	public String getRelativo() {
		return relativo;
	}

	public boolean isArquivo() {
		return arquivo;
	}

	public long getTamanho() {
		return tamanho;
	}
}
