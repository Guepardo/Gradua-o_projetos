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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import chat.rede.Rede;
import chat.tipos.Usuario;

public class JanelaSolicitacao extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5115713992490536521L;
	
	JTextField nomeUsuario;
	JButton b1;
	Rede r;
	Usuario usu;
	
	public JanelaSolicitacao(Usuario usu)
	{
		super("Enviar convite");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		nomeUsuario = new JTextField();
		b1          = new JButton("Enviar");
		r           = new Rede();
		
		nomeUsuario.setBounds(1,20,185,25);
		b1.setBounds(190, 20,100,25);
		
		c.add(nomeUsuario);
		c.add(b1);
		
		b1.addActionListener(new Ouvir());
		setSize(300,100);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.usu = usu;
	}
	
	private class Ouvir implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0)
		{
			if(nomeUsuario.getText().length() > 0 )
			{
				String resul = (r.manterAmigo(usu.getUsuario(),nomeUsuario.getText(),usu.getSenha(),-1)) ? "Solicitação feita com sucesso."  :"Ocorreu um Erro. Tente novamente.";
				
				JOptionPane.showMessageDialog(null,resul);
				dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Entre com o nome de usuário para efetuarmos a solicitação.");
			}
		}
	}
}
