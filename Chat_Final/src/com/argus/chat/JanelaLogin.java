package com.argus.chat;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JanelaLogin extends JFrame
{
	JTextField login,senha;
	JLabel     j_login,j_senha,j_estado;
	
	JButton    logar,cadastrar;
	
	public JanelaLogin()
	{
		super("Login-versão 1.0");
		//Iniciando variáveis
		Container container = getContentPane();
		
		login = new JTextField();
		senha  = new JTextField();
		
		j_login   = new JLabel("Usuário : ");
		j_senha   = new JLabel("Senha : ");
		j_estado  = new JLabel(" Login ou senha estão icorretos.");
		
		j_estado.setForeground(Color.red);
		j_estado.setVisible(false);
		
		logar = new JButton("Logar");
		cadastrar = new JButton("Cadastrar");
		
		container.setLayout(null);
		//Iniciação de variáveis - fim.
		
		
		//Definindo setBounds;
		login.setBounds(170,200,200,25);
		j_login.setBounds(100,200,100,25);
		senha.setBounds(170,250,200,25);
		j_senha.setBounds(100,250,100,25);
		j_estado.setBounds(170,300,200,25);
		logar.setBounds(220,350,100,40);
		cadastrar.setBounds(220,400,100,40);
		//Definindo setBounds - fim.
		
		//Adicionando ao container
		container.add(login);
		container.add(j_login);
		container.add(senha);
		container.add(j_senha);
		container.add(j_estado);
		container.add(logar);
		container.add(cadastrar);
		//Adicionando ao container - fim.
		
		
		//Adicionando ActionListener
		logar.addActionListener(new Ouvir(logar));
		cadastrar.addActionListener(new Ouvir(cadastrar));
		//Adicionando ActionListener - fim.
		
		setSize(500,600);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//---------------Classe ActionListener---------------
	
	public class Ouvir implements ActionListener
	{
		JButton temp;
		public Ouvir(JButton temp)
		{
			this.temp = temp;
		}
		
		public void actionPerformed(ActionEvent evento) 
		{
			
			if(temp.getText().equals("Logar"))
			{
				//Chamar função de logar.
				if(login.getText().equals("") || senha.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Preencha os campos.");
				}
				JOptionPane.showMessageDialog(null,"Logar.");			
			}
			
			if(temp.getText().equals("Cadastrar"))
			{
				//Chamar função de cadastrar.
				JOptionPane.showMessageDialog(null,"Cadastrar.");	
			}
		}
			
	}
	
}


