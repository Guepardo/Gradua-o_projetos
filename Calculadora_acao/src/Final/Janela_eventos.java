package Final;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela_eventos extends JFrame {
	
	
	JTextField Display,CE;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,Somar,Menos,Div,Igual,Ponto,Mult,Limpa;
	 public Janela_eventos (  ){
		 
		super("Calculadora ");
		
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		Container Principal = getContentPane();
		Container Teclado   = new JPanel();
		Container CE        = new JPanel();
		
		Teclado.setLayout( new GridLayout(4,4,2,2));
		CE.setLayout( new GridLayout(2,1,1,1));
		
		CE.add(Somar  = new JButton("+"));  
		CE.add(Menos  = new JButton("-"));
		
		Teclado.add(b7    = new JButton("7"));   Teclado.add(b8     = new JButton("8"));
		Teclado.add(b9    = new JButton("9"));   Teclado.add(Limpa  = new JButton("CE"));
		Teclado.add(b4    = new JButton("4"));   Teclado.add(b5     = new JButton("5"));
		Teclado.add(b6    = new JButton("6"));   Teclado.add(CE                       );
		Teclado.add(b1    = new JButton("1"));   Teclado.add(b2     = new JButton("2"));
		Teclado.add(b3    = new JButton("3"));   Teclado.add(Mult   = new JButton("*"));
		Teclado.add(b0    = new JButton("0"));   Teclado.add(Ponto  = new JButton("."));
		Teclado.add(Igual = new JButton("="));   Teclado.add(Div    = new JButton("/"));
	    
		
		Principal.add(BorderLayout.NORTH , Display = new JTextField('0'));
		Principal.add(BorderLayout.CENTER , Teclado );
		
		Display.setEditable(false);
		setVisible(true);
		
		b1.addActionListener    ( new Ouvir('1'));     b2.addActionListener   ( new Ouvir('2'));
		b3.addActionListener    ( new Ouvir('3'));     b4.addActionListener   ( new Ouvir('4'));
		b5.addActionListener    ( new Ouvir('5'));     b6.addActionListener   ( new Ouvir('6'));
		b7.addActionListener    ( new Ouvir('7'));     b8.addActionListener   ( new Ouvir('8'));
		b9.addActionListener    ( new Ouvir('9'));     b0.addActionListener   ( new Ouvir('0'));
		Mult.addActionListener  ( new Ouvir('*'));     Igual.addActionListener( new Ouvir('='));
		Ponto.addActionListener ( new Ouvir('.'));     Div.addActionListener  ( new Ouvir('/'));
		Somar.addActionListener ( new Ouvir('+'));     Menos.addActionListener( new Ouvir('-'));
		Limpa.addActionListener (new Ouvir ('c'));
		
	}
	 
	 
	 
	 int  Elemento = 0 ;
	 String Temp [] = {"",""};
	 char Operando;
	 
	 class Ouvir implements ActionListener{
		 char Captura = '\0';
		
		 public Ouvir (char Captura ){
			 this.Captura = Captura;
		 }
		 
		 public void actionPerformed(ActionEvent evento){
			      if ( Captura == 'c' )
			      {
			    	  Elemento = 0;
			    	  Temp[0] = Temp[1] = "";
			    	  Display.setText("0");
			      }
			      
				  if ( Character.isDigit(Captura) || Captura == '.'  )
				  {
					  Temp[Elemento] += Captura;
					  Display.setText(Temp[Elemento]);
				  }
				  else if( Captura !=  '=')
				  {
					 if (Elemento != 1 ) Elemento++;
					  Operando = Captura;
				  }
				  
				  if ( Captura == '=' && Elemento == 1 )
				  {
					  System.out.println(Elemento);
					  Elemento = 0;
					  
					  switch ( Operando ){
					  case '-':
						  Temp[0]=Float.toString(Float.parseFloat(Temp[0])- Float.parseFloat(Temp[1]));
						  Temp[1]="";
						  Display.setText(Temp[0]);
					  break;
					  case '+':
						  Temp[0]=Float.toString(Float.parseFloat(Temp[0])- Float.parseFloat(Temp[1]));
						  Temp[1]="";
						  Display.setText(Temp[0]);
					  break;
					  case '/':
						  Temp[0]=Float.toString(Float.parseFloat(Temp[0])- Float.parseFloat(Temp[1]));
						  Temp[1]="";
						  Display.setText(Temp[0]);
					  break;
					  case '*':
						  Temp[0]=Float.toString(Float.parseFloat(Temp[0])- Float.parseFloat(Temp[1]));
						  Temp[1]="";
						  Display.setText(Temp[0]);
					  break;
					  }
				  }
		 }
		 
	 }

}
