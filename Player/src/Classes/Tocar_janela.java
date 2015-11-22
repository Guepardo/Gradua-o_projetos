package Classes;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.filechooser.*;


public class Tocar_janela extends JFrame 
{
	
	JFileChooser procura;
	JTextField relogio,cardapio;
	JButton pause,play,adicionar;
	JFileChooser chooser;
	String musica = null;
	Reproduzir r;
	boolean play_on = false;
	
	
   public Tocar_janela ( )
   {
	   super("Tocandor");
	   setSize(550,200);
	   chooser   = new JFileChooser();
	   relogio   = new JTextField("\t00:00");
	   cardapio  = new JTextField("Click em Add para adicionar uma música a lista");
	   pause     = new JButton("Pause");
	   play      = new JButton("Play");
	   adicionar = new JButton("Add");
	   
	   Container c = getContentPane();
	   Container s = new JPanel( new GridLayout(1,4,4,4));
	   Container b = new JPanel( new GridLayout(2,1,6,6));
	   c.setLayout( new BorderLayout());
	   
	   s.add(pause);
	   s.add(play);
	   s.add(adicionar);
	   b.add(relogio);
	   b.add(s);
	   
	   c.add(BorderLayout.CENTER , cardapio);
	   c.add(BorderLayout.EAST, b);
	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setVisible(true);
	   
	   pause.addActionListener    ( new Ouvir(1));
	   play.addActionListener     ( new Ouvir(2));
	   adicionar.addActionListener( new Ouvir(3));
   }
   
   private class Ouvir implements ActionListener 
   {
	   int cod;
	   
	   public Ouvir ( int cod )
	   {
		   this.cod = cod;
	   }
	   
	   public void actionPerformed ( ActionEvent evento)
	   {
		   switch ( cod )
		   {
		   case 1 : 
			       
			   break;
		   case 2 : 
			    	Reproduzir r = new Reproduzir(musica);
			    	r.Tocar();
			   break;
		   case 3 :
			    	chooser.showOpenDialog( new JFrame() ); 
			    	musica = chooser.getSelectedFile().getAbsolutePath();
			    	cardapio.setText(musica);
			   break;
		   }
	   }
	   
   }
}
