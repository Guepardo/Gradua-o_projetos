/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */
package chat.janelas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.rede.Rede;
import chat.tipos.Amigos;
import chat.tipos.Usuario;

public class JanelaLimbo  extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6562415258709630681L;
	
	JButton aceitar, recusar;
	Amigos ami;
	Usuario usu;
	Rede r;
	
	public JanelaLimbo (Usuario usu , Amigos ami)
	{
		super("aceitar ou recusar");
		
		aceitar = new JButton("Aceitar");
		recusar = new JButton("Recusar");
		JLabel j = new JLabel(ami.getNome() + " está solicitando a sua amizade.");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		aceitar.setBounds(50, 45,100,25);
		recusar.setBounds(155,45,100,25);
		j.setBounds(30, 1,250,25);
		
		c.add(aceitar);
		c.add(recusar);
		c.add(j);
		
		aceitar.addActionListener(new Ouvir());
		recusar.addActionListener(new Ouvir());
		
		this.ami = ami;
		this.usu = usu;
		
		r = new Rede();
		
		setSize(300,100);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private class Ouvir implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			JButton b = (JButton) arg0.getSource();
			
			if( b.getText().equals("Aceitar"))
			{
				System.out.println("Aceitei");
				r.manterAmigo(usu.getUsuario(),ami.getUsuario(),usu.getSenha(),0);
				dispose();
			}
			else
			{
				System.out.println("Recusei");
				r.manterAmigo(usu.getUsuario(),ami.getUsuario(),usu.getSenha(),1);
				dispose();
			}
		}
	}
}
