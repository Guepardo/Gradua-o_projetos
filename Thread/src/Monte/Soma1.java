package Monte;

public class Soma1 implements Runnable {
	int tempo;
	 
	public Soma1 ( int tempo ){
		this.tempo = tempo;
	}
	

	Janela p;
	public void run ( ){
		
		   p = new Janela(false);
		   try {
					for(int a = 0 ; a < 100 ; a++ )
					{
						p.t2.setText(""+a);
						Thread.sleep(tempo);
					}
		       } catch (InterruptedException e) {
				
				e.printStackTrace();
			   }
		
	}
}
