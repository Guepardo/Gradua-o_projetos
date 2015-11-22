package tipos;

import java.io.Serializable;

public class Palavras implements Serializable
{
	private boolean estudavel;
	private String palavra;
	private String inf;
	
	public Palavras(String palavra, String inf , boolean estudavel )
	{
		this.estudavel =estudavel;
		this.palavra = palavra;
		this.inf = inf;
	}

	public boolean isEstudavel() {
		return estudavel;
	}

	public void setEstudavel( boolean b )
	{
		estudavel = b;
	}
	public String getPalavra() {
		return palavra;
	}
	
	public String getInf()
	{
		return inf;
	}
}
