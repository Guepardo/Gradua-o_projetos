package Monte;

public class Soma2 implements Runnable {
	int tempo;
	 
	public Soma2 ( int tempo ){
		this.tempo = tempo;
	}
	

	Janela p;
	public void run ( ){
		
		   p = new Janela(false);
		   try {
					for(int a = 100 ; a > 0 ; a-- )
					{
						p.t3.setText(""+a);
						Thread.sleep(tempo);
					}
		       } catch (InterruptedException e) {
				
				e.printStackTrace();
			   }
		
	}
}
