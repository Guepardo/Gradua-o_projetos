package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Janela_Login extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	JTextField email_t;
	JPasswordField senha_t;
	JButton entrar,cadastrar;
	
	public Janela_Login(){
		super("Efetue o login | Protótipo 1.0");
		JLabel logo,email,senha,fundo,rodape;
		
		logo   = new JLabel(new ImageIcon("Imagens//Logo1.png"));
		fundo  = new JLabel( new ImageIcon("Imagens//Fundo1.jpg"));
		email  = new JLabel("Endereço E-mail:");
		senha  = new JLabel("Senha:" );
		rodape = new JLabel("G4Software 2013" );
		
		
		rodape.setForeground( Color.WHITE);
		email.setForeground ( Color.WHITE);
		senha.setForeground ( Color.WHITE);
		
		senha_t   = new JPasswordField(16);
		email_t   = new JTextField("exemplo@Malle.com");
		entrar    = new JButton("Entrar");
		cadastrar = new JButton("Cadastrar");
		
		email_t.setFont(new Font("serif",Font.PLAIN,16));
		
		logo.setToolTipText   ("Mail,Allysom,Luiz,Lorena,Erick.");
		email_t.setToolTipText("Digite seu e-mail.");
		senha_t.setToolTipText("Digite sua senha.");
		rodape.setToolTipText ("Empresa não registrada.");
		
		Container princ  = getContentPane();
	
		princ.setLayout(null);
		
		fundo.setBounds    (0,0,500,600);
		logo.setBounds     (105,0,250,200);
		email.setBounds    (50,195,100,10);
		email_t.setBounds  (50,211,399,35);
		senha.setBounds    (50,285,100,10);
		senha_t.setBounds  (50,300,399,35);
		entrar.setBounds   (200,400,100,40);
		cadastrar.setBounds(200,440,100,40);
		rodape.setBounds   (200,490,100,40);
		
		princ.add(rodape   ,null);
		princ.add(logo     ,null);
		princ.add(email    ,null);
		princ.add(email_t  ,null);
		princ.add(senha    ,null);
		princ.add(senha_t  ,null);
		princ.add(entrar   ,null);
		princ.add(cadastrar,null);
		princ.add(fundo    ,null);
		
		setBounds(400,600,500,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		entrar.addActionListener   (new Ouvir(1));
		cadastrar.addActionListener(new Ouvir(2));
		
		
		
	}
	
	private class Ouvir implements ActionListener {
		int numero;
		
		public Ouvir(int numero){
			this.numero = numero;
		}
		
		public void actionPerformed ( ActionEvent evento){
			if ( numero == 2 ) new Janela_Formulario();
		}
		
	}

}
