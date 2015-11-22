/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.janelas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import chat.administrativo.ControlarUsuario;
import chat.rede.Rede;
import chat.tipos.Usuario;

public class JanelaLogin extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6961776793301862569L;
	
	JTextField login,senha;
	JLabel     j_login,j_senha,j_estado,java,php;
	JButton    logar,cadastrar;
	ControlarUsuario ca;
	
	Rede r;
	
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
		java      = new JLabel( new ImageIcon(getClass().getResource("/Imagens/java.jpg")) );
		php       = new JLabel( new ImageIcon(getClass().getResource("/Imagens/php.jpg"))  );
		
		j_estado.setForeground(Color.red);
		j_estado.setVisible(false);
		
		logar = new JButton("Logar");
		cadastrar = new JButton("Cadastrar");
		
		container.setLayout(null);
		//Iniciação de variáveis - fim.
		
		
		//Definindo setBounds;
		login.setBounds(160,200,200,25);
		j_login.setBounds(90,200,100,25);
		senha.setBounds(160,250,200,25);
		j_senha.setBounds(90,250,100,25);
		j_estado.setBounds(160,300,200,25);
		logar.setBounds(210,350,100,40);
		cadastrar.setBounds(210,400,100,40);
		java.setBounds(230,470,100,40);
		php.setBounds(190,470,100,40);
		//Definindo setBounds - fim.
		
		//Adicionando ao container
		container.add(login);
		container.add(j_login);
		container.add(senha);
		container.add(j_senha);
		container.add(j_estado);
		container.add(logar);
		container.add(cadastrar);
		container.add(java);
		container.add(php);
		//Adicionando ao container - fim.
		
		
		//Adicionando ActionListener
		logar.addActionListener(new Ouvir(logar));
		cadastrar.addActionListener(new Ouvir(cadastrar));
		//Adicionando ActionListener - fim.
		
		setSize(500,600);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		r  = new Rede();
		ca = new ControlarUsuario();
	}
	
	//---------------Classe ActionListener---------------
	
	public class Ouvir implements ActionListener
	{
		JButton temp;
	
		public Ouvir(JButton temp )
		{
			this.temp = temp;
		}
		
		public void actionPerformed(ActionEvent evento) 
		{
			Usuario usu;
            
			if(temp.getText().equals("Logar"))
			{
				//Chamar função de logar.
				if(login.getText().equals("") || senha.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Preencha os campos.");
					return;
				}
				
				usu = r.login(login.getText().trim(),senha.getText().trim());
				
				if( usu != null)
				{
					new Thread(new JanelaPainel(usu),"Painel-Chat").start();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Login incorreto.");
				}
			}
			
			//---------------------------------------------------------------------------
			
			if(temp.getText().equals("Cadastrar"))
			{
				Desktop desk = Desktop.getDesktop();
				try 
				{
					desk.browse(new URI("http://argus.zz.mu/Cadastro/Cadastro.html"));
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				} 
				catch (URISyntaxException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}


