package Pacote;

public class Cpu 
{
	int config;
	
	Cpu(int config )
	{
		this.config = config;
	}
	
	public boolean okCpu()
	{
		return (config > 0 );
	}
	
	public void startCpu()
	{
		System.out.println("Cpu Inciando");
	}
	
}
