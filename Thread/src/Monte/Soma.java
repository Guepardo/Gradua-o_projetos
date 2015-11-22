package Monte;

public class Soma implements Runnable {
	int tempo;
	 
	public Soma ( int tempo ){
		this.tempo = tempo;
	}
	

	Janela p;
	public void run ( ){
		
		   p = new Janela(false);
		   try {
					for(int a = 0 ; a < 100 ; a++ )
					{
						p.t1.setText(""+a);
						Thread.sleep(tempo);
					}
		       } catch (InterruptedException e) {
				
				e.printStackTrace();
			   }
		
	}

}
