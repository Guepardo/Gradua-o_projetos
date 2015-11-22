package GUI;
import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
	
	GridLayout a ; 
	 
	public Janela (){
		super("Teste Janela Java.");
		
		a = new GridLayout(8,4);
		
		JButton botao1 = new JButton("Botão 1");
		JButton botao2 = new JButton("Botão 2");
		
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		getContentPane().setLayout(a);
		
		getContentPane().add(botao1);
		getContentPane().add(botao2);
		
		Listener acaobotao1 = new Listener("Caralho merda");
		Listener acaobotao2 = new Listener("Mais que merda e essa");
		
		botao1.addActionListener(acaobotao1);
		botao2.addActionListener(acaobotao2);
		
		
	}

}
