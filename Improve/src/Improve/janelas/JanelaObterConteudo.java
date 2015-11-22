package Improve.janelas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Improve.admin.GameGestor;
import Improve.tipos.Frases;
import Improve.tipos.Palavras;

public class JanelaObterConteudo extends JFrame
{
	JTextField palavra,frase,despalavra,desfrase;
	JLabel     palavral,frasel,dialogo,descricaof,descricaop;
	JButton    palavrab,fraseb;
	
	GameGestor gg;
	
	
	public JanelaObterConteudo()
	{
		super("Colhendo palavras e frases ");
		
		Container c = getContentPane( );
		palavra = new JTextField();
		frase   = new JTextField();
		despalavra = new JTextField();
		desfrase   = new JTextField();
		
		palavral= new JLabel("Palavra : ");
		frasel  = new JLabel("Frase   : ");
		dialogo = new JLabel("Entre com uma frase que contenha a palavra escolhida.");
		descricaof= new JLabel("Descrição frase:");
		descricaop= new JLabel("Descrição palavra:");
		
		palavrab= new JButton("Entrar palavra");
		fraseb  = new JButton("Entrar frase");
		
		
		c.setLayout( null );
		
		palavral.setBounds(1,1,100,25);
		palavra.setBounds(55,1,150,25);
		palavrab.setBounds(230,1,120,25);
		descricaop.setBounds(1,30,120,25);
		despalavra.setBounds(1,60,360,165);
		
		
		frasel.setBounds(1,230,100,25);
		frase.setBounds(55,230,150,25);
		fraseb.setBounds(230,230,120,25);
		descricaof.setBounds(1,260,120,25);
		desfrase.setBounds(1,290,360,165);
		
		
		dialogo.setBounds(1,470,370,25);
		dialogo.setHorizontalAlignment(JLabel.CENTER);
		
		frase.setEditable(false);
		fraseb.setEnabled(false);
		desfrase.setEditable(false);
		
		c.add(palavral);
		c.add(palavra);
		c.add(palavrab);
		
		c.add(frasel);
		c.add(frase);
		c.add(fraseb);
		
		c.add(descricaof);
		c.add(descricaop);
		
		c.add(despalavra);
		c.add(desfrase);
		
		c.add(dialogo);
		
		setSize(370,530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		gg = GameGestor.obterInstancia();
				
		palavrab.addActionListener( new Acao() );
		fraseb.addActionListener  ( new Acao() );
	}
	
	
	private class Acao implements ActionListener
	{
		JButton temp;
		
		public void actionPerformed(ActionEvent arg0)
		{
			temp = ( JButton ) arg0.getSource();
			
			if( temp.getText().equals("Entrar palavra") && !palavra.getText().equals("") )
			{
				gg.inserir( new Palavras(true,false,false,palavra.getText().trim(),despalavra.getText().trim()) );
				temp.setEnabled(false);
				palavra.setEditable(false);
				despalavra.setEditable(false);
				
				frase.setEditable(true);
				fraseb.setEnabled(true);
				desfrase.setEnabled(true);
			}
			
			if( temp.getText().equals("Entrar frase") && !frase.getText().equals("") )
			{
					
				if( frase.getText().toLowerCase().contains(palavra.getText().toLowerCase()) )
				{
					String t = (gg.inserir( new Frases(true,false,false,frase.getText().trim(),null) )) ? "Frase gravada no arquivo" : "Essa frase já existe no arquivo" ;
					
					frase.setText("");
					desfrase.setText("");
					dialogo.setText(t);
				}
				else
				{
					dialogo.setText("Essa frase não contém a palavra");
				}
			}
		}
	}
}
