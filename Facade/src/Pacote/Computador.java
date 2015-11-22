package Pacote;

public class Computador 
{
	Memoria m;
	Cpu     c;
	Hd      h;
	
	Computador(int cpu , int hd , int memoria)
	{
		m = new Memoria(memoria);
		c = new Cpu(cpu);
		h = new Hd(hd);
	}
	
	public boolean testHardware ()
	{
		return(m.okMemoria() && c.okCpu() && h.okHd());
	}
	
	public boolean startComputador()
	{
		if( testHardware() )
		{
			m.startMemoria();
			c.startCpu();
			h.startHd();
			return true;
		}
		return false;
    }
}
