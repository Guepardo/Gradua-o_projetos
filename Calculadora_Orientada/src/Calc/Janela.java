package Calc;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame {
	
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,ba,bm,bv,bd,bi,bc,bp;
	JTextField display;
	JLabel info;
	
	String num[] = {"",""};
	
  public Janela (){
	super("Calculadora");
	
	Container painel = new JPanel();
	Container princ  = getContentPane();
	Container dispc  = new JPanel();
	display = new JTextField("0", 9);
	
	display.setBackground( new Color(206,249,204));
	display.setFont( new Font("serif",Font.BOLD,26));
	
	setBounds(100,100,300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	
	// Adiconando no painel secundário.
	
	painel.setLayout(new GridLayout(4,4,4,4));
	
	b0 = new JButton("0");
	b1 = new JButton("1");
	b2 = new JButton("2");
	b3 = new JButton("3");
	b4 = new JButton("4");
	b5 = new JButton("5");
	b6 = new JButton("6");
	b7 = new JButton("7");
	b8 = new JButton("8");
	b9 = new JButton("9");
	ba = new JButton("+");
	bm = new JButton("-");
	bd = new JButton("/");
	bv = new JButton("*");
	bi = new JButton("=");
	bc = new JButton("C");
	bp = new JButton(".");
	
	b0.setBackground(Color.WHITE);
	b1.setBackground(Color.WHITE);
	b2.setBackground(Color.WHITE);
	b3.setBackground(Color.WHITE);
	b4.setBackground(Color.WHITE);
	b5.setBackground(Color.WHITE);
	b6.setBackground(Color.WHITE);
	b7.setBackground(Color.WHITE);
	b8.setBackground(Color.WHITE);
	b9.setBackground(Color.WHITE);
	
	ba.setBackground(new Color(186,204,245));
	bm.setBackground(new Color(186,204,245));
	bi.setBackground(new Color(186,204,245));
	bd.setBackground(new Color(186,204,245));
	bv.setBackground(new Color(186,204,245));
	bp.setBackground(new Color(186,204,245));
	bc.setBackground(new Color(240,252,173));
	
	painel.add(b7);
	painel.add(b8);
	painel.add(b9);
	painel.add(bd);
	
	painel.add(b4);
	painel.add(b5);
	painel.add(b6);
	painel.add(bv);
	
	painel.add(b1);
	painel.add(b2);
	painel.add(b3);
	painel.add(bm);
	
	painel.add(bp);
	painel.add(b0);
	
	painel.add(bi);
	painel.add(ba);
	
	princ.setLayout(new BorderLayout());
	
	dispc.add(BorderLayout.CENTER , display );
	dispc.add(BorderLayout.EAST ,bc );
	
	princ.add(BorderLayout.NORTH , dispc );
	princ.add(BorderLayout.CENTER, painel);
	
	setResizable(false);
	setVisible(true);
	
	b0.addActionListener( new Ouvir('0'));
	b1.addActionListener( new Ouvir('1'));
	b2.addActionListener( new Ouvir('2'));
	b3.addActionListener( new Ouvir('3'));
	
	b4.addActionListener( new Ouvir('4'));
	b5.addActionListener( new Ouvir('5'));
	b6.addActionListener( new Ouvir('6'));
	b7.addActionListener( new Ouvir('7'));
	
	b8.addActionListener( new Ouvir('8'));
	b9.addActionListener( new Ouvir('9'));
	ba.addActionListener( new Ouvir('+'));
	bc.addActionListener( new Ouvir('c'));
	
	bm.addActionListener( new Ouvir('-'));
	bd.addActionListener( new Ouvir('/'));
	bi.addActionListener( new Ouvir('='));
	bv.addActionListener( new Ouvir('*'));
	
	
	
  }
  
  char operando;
  int id = 0;
  public class Ouvir implements ActionListener  {
		char controle;
	
		
		public Ouvir ( char controle ){
			
			this.controle = controle;
		}
		
		public void actionPerformed ( ActionEvent evento ){
			if ( controle == 'c' )
			{
				id = 0;
				num[0] = num[1] = "";
				display.setText("");
			}
			
			if ( id != 2 )
			{
					if ( (Character.isDigit(controle) || controle == '.') )
					{
						num[id]+= Character.toString(controle);
						display.setText(num[id]);
					}
					else if (controle != '=' )
					{
						display.setText("");
						operando = controle; 
						id++;
					}
			}	
				if ( controle == '=')
				{
					switch ( operando )
					{
					case '+':
						System.out.println(operando);
						break;
					case '-':
						System.out.println(operando);
						break;
					case '*':
						System.out.println(operando);
						break;
					case '/':
						System.out.println(operando);
						break;		
					}
				}
				
		}

	}
}
