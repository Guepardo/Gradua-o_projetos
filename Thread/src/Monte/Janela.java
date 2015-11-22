package Monte;
import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame{
	public static JTextField t1,t2,t3;
	private boolean cont=false;
	
  public Janela (boolean cont){
	  this.cont = cont;
	  
	     t1 = new JTextField("p");
		 t2 = new JTextField("p");
		 t3 = new JTextField("p");

		 t1.setEditable(false);
		 t2.setEditable(false);
		 t3.setEditable(false);
		 
	  if ( cont ){
	     
		  setSize(200,200);
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  getContentPane().setLayout( new GridLayout(3,1,1,1));
		  getContentPane().add(t1 );  getContentPane().add(t2 );
		  getContentPane().add(t3 );
		  setLocation(550,300);
		  setVisible(true);
	  }
  }
  
}
