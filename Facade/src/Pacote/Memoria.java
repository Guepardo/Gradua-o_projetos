package Pacote;

public class Memoria {
	int quantidade=0;
	
	Memoria(int quantidade )
	{
		this.quantidade = quantidade;
	}
	
	public boolean okMemoria()
	{
		return ( quantidade > 0 );
	}
	
	public void startMemoria()
	{
		System.out.println("Mem�ria trabalhando a " + quantidade); 
	}
}
