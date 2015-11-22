package Janelas;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame  {
	
	private JTextField t;
	private JButton b1,b2,b3,b4;
	public Janela (){
		
		super("Janela Composta");
		
		Container principal = getContentPane();//armazenado o conteiner da minha janela em uma variável do tipo Container
		
		Container secundario = new JPanel();
		
		secundario.setLayout( new GridLayout(4,1));
		
		secundario.add(b1 = new JButton("1"));
		secundario.add(b2 = new JButton("2"));
		secundario.add(b3 = new JButton("3"));
		secundario.add(b4 = new JButton("4"));
		
		principal.setLayout( new BorderLayout(1,1));
		
		principal.add(BorderLayout.EAST,   secundario );
		principal.add(BorderLayout.CENTER, t = new JTextField("Entre com o texto aqui"));
	
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Ouvir c1 = new Ouvir("1", t);
		
		b1.addActionListener(c1);
		
	}

}
