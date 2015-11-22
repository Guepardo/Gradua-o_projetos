package Monte;


public class Principal {
	static Janela p;
	
	public static void main (String [] args ){
		
		
		Runnable b  = new Soma(100);
		Runnable b1 = new Soma1(200);
		Runnable b2 = new Soma2(300);
		
	
		
		new Thread(b,"Soma 1").start();
		new Thread(b1,"Soma 1").start();
		new Thread(b2,"Soma 1").start();
		
		
		p = new Janela(true);
		
	}

}
