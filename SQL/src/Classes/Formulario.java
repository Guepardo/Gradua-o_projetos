package Classes;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

public class Formulario extends JFrame {
	
	JTextField b1,b2;

	public Formulario (){
		super("Formulário");
		setSize(300,300);
		
		JButton submit = new JButton("Submit");
		
		Container c =  new JPanel();
		Container p =  getContentPane();
		
		c.setLayout(new GridLayout(2,3,3,3));
		
		c.add( new JLabel("Nome: ")); c.add( b1 = new JTextField());
		c.add( new JLabel("Email:")); c.add( b2 = new JTextField());
		
		p.add(BorderLayout.NORTH, c);
		p.add(BorderLayout.SOUTH, submit);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		submit.addActionListener(new Ouvir());
		
	}
	
	private class Ouvir implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
		 
			Sql bd = new Sql();
		    bd.Enviar(b1.getText(), b2.getText());
		 
		}
	}
}
