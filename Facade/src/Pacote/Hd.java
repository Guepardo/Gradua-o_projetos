package Pacote;

public class Hd {
	int tamanho=0;
	
	Hd(int tamanho )
	{
		this.tamanho  = tamanho;
	}
	
	public boolean okHd()
	{
		return ( tamanho  >  0 );
	}

	public void startHd()
	{
		System.out.println("HD com "+tamanho+" rodando a 7200 RPM");
	}
}
