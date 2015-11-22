package Classes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Janela_Formulario extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	JTextField email_t,nome_t,uf_t,city_t,p_t,idade_t;
	JButton    submit;
	JCheckBox   feminino,masculino; 
	
     public Janela_Formulario (){
    	 super("Cadastro | Protótipo 1.0");
    	 
    	 JLabel fundo,logo,nome_l,
    	 email_l,email_12,city_l,p_l,uf_l,idade_l;
    	 
    	 Container princ = getContentPane();
    	 
    	 submit  = new JButton("Submit");
    	 
    	 email_t = new JTextField("Exemplo");
    	 nome_t  = new JTextField();
    	 uf_t    = new JTextField();
    	 city_t  = new JTextField();
    	 p_t   = new JTextField();
    	 idade_t = new JTextField();
    	 
    	 masculino = new JCheckBox ("Maculino");
    	 feminino  = new JCheckBox ("Feminino");
    	 
    	 
    	 fundo    = new JLabel( new ImageIcon("Imagens//Fundo1.jpg"));
    	 logo     = new JLabel( new ImageIcon("Imagens//Logo_formulario.png"));
    	 nome_l   = new JLabel("Nome: ");
    	 email_l  = new JLabel("E-mail: ");
    	 email_12 = new JLabel("@Malle.com");
    	 uf_l     = new JLabel("Estado:");
    	 city_l   = new JLabel("Cidade:");
    	 p_l      = new JLabel("País:");
    	 idade_l  = new JLabel ("Idade:");
    	 email_t.setFont (new Font ("serif",Font.PLAIN,16));
    	 /*
    	 email_12.setFont(new Font("serif",Font.PLAIN,16));
    	 nome_l.setFont  (new Font  ("serif",Font.PLAIN,16));
    	 */
    	 
    	 email_l.setForeground  (Color.WHITE);
    	 email_12.setForeground (Color.WHITE);
    	 nome_l.setForeground   (Color.WHITE);
    	 city_l.setForeground   (Color.WHITE);
    	 p_l.setForeground      (Color.WHITE);
    	 uf_l.setForeground     (Color.WHITE);
    	 idade_l.setForeground  (Color.WHITE);
    	 submit.setBackground   (Color.GRAY );
    	 
    	 princ.setLayout(null);
    	 
    	 submit.setBounds   (300,400,100,40);
    	 feminino.setBounds (210,290,90,20);
    	 masculino.setBounds(390,290,90,20);
    	 idade_l.setBounds  (230,200,100,30);
    	 idade_t.setBounds  (270,200,30,30);
    	 city_l.setBounds   (310,200,100,30);
    	 city_t.setBounds   (360,200,100,30);
    	 uf_l.setBounds     (470,200,100,30);
    	 uf_t.setBounds     (520,200,50,30 );
    	 p_l.setBounds      (580,200,50,30 );
    	 p_t.setBounds      (620,200,50,30 );
    	 nome_t.setBounds   (45,200,170,30);
    	 nome_l.setBounds   (0,200,170,30);
    	 email_12.setBounds (400, 90, 170,30);
    	 email_t.setBounds  (245, 90, 150,30);
    	 email_l.setBounds  (200, 90, 100,30);
    	 logo.setBounds     (3,3,180,140);
    	 fundo.setBounds    (0,0,700,600);
    	
    	 princ.add(feminino,  null);
    	 princ.add(masculino, null);
    	 
    	 princ.add(uf_l,    null);
    	 princ.add(city_l,  null);
    	 princ.add(p_l,     null);
    	 princ.add(idade_l, null);
    	 princ.add(idade_t, null);
    	 princ.add(p_t,     null);
    	 princ.add(uf_t,    null);
    	 princ.add(city_t,  null);
    	 princ.add(submit,  null);
    	 princ.add(nome_t,  null);
    	 princ.add(nome_l,  null);
    	 princ.add(email_12,null);
    	 princ.add(email_t, null);
    	 princ.add(email_l, null);
    	 princ.add(logo,    null);
    	 princ.add(fundo,   null);
    	  
    	 setBounds(700,600,700,500);
    	 setVisible(true);
    	 setResizable(false);
    	 setLocationRelativeTo(null);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 
    	 submit.addActionListener( new Ouvir(1));
    	 feminino.addItemListener(  new Ouvir(2));
    	 masculino.addItemListener( new Ouvir(3));
    	 
     }
     
     private class Ouvir implements ActionListener,ItemListener {
    	 int id;
    	 
    	public Ouvir ( int id ){
    		this.id = id;
    	}
    	 
		public void actionPerformed(ActionEvent evento) {
			BancoDados bd = new BancoDados();
			bd.Cadastrar("sadfsdf", "asdfsdafasdf");
		}

		public void itemStateChanged(ItemEvent evento) {
			if ( id == 2 ) JOptionPane.showMessageDialog(null,"Menina.");
			else JOptionPane.showMessageDialog(null,"Menino.");
		}
     }
     
      
     
}





