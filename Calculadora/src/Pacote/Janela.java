package Pacote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela extends JFrame {
	
	TextField texto;
	JButton b1,b2,b3;
  public Janela (){
	Container Tela = getContentPane();
	Container Teclado = new JPanel();
	
	setSize(300,300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setTitle("Calculadora");
	
	Teclado.setLayout( new GridLayout(4,4));
	Teclado.add( b1 = new JButton("9"));
	Teclado.add( b2 = new JButton("8"));
	Teclado.add( b3 = new JButton("7"));
	Teclado.add( new JButton("+"));
	Teclado.add(new JButton("6"));
	Teclado.add(new JButton("5"));
	Teclado.add(new JButton("4"));
	Teclado.add(new JButton("-"));
	Teclado.add(new JButton("3"));
	Teclado.add(new JButton("2"));
	Teclado.add(new JButton("1"));
	Teclado.add(new JButton("/"));
	Teclado.add(new JButton("0"));
	Teclado.add(new JButton("."));
	Teclado.add(new JButton("="));
	Teclado.add(new JButton("x"));
	
	Tela.add(BorderLayout.NORTH, new JTextField("Ainda não fiz ActionListener"));
	Tela.add(BorderLayout.CENTER, Teclado);
	
	setVisible(true);
	
	Ouvir ab1 = new Ouvir(1);
	Ouvir ab2 = new Ouvir(2);
	Ouvir ab3 = new Ouvir(3);
	
	b1.addActionListener(ab1);
	b2.addActionListener(ab2);
	b3.addActionListener(ab3);
	
	
  }
  
  class Ouvir implements ActionListener{
	  int Avaliar;
	  
	  public Ouvir ( int Avaliar ){
		  this.Avaliar = Avaliar;
	  }
	  
	  public void actionPerformed ( ActionEvent evento){
		  
		  switch(Avaliar){
		  case 1:
			  texto.setText("9");
			  break;
		  case 2:
			  texto.setText("8");
			  break;
		  case 3:
			  texto.setText("7");
			  break;
		  }
		  
	  }
  }
  
}
