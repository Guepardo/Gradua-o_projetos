package Improve.janelas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Improve.admin.GameGestor;
import Improve.admin.Tipos;
import Improve.tipos.Palavras;
import Improve.tipos.Persistir;

public class JanelaGame extends JFrame
{
	JLabel interacao;
	JTextField campoPalavra,campoEntrada;
	JCheckBox  facil,medio,dificil;
	GameGestor gg;
	
	//Variáveis para administração do exercício.
	int indicep=0,indicef=0,contador=0;
	String temp="(Ctrl) for start.";
	ArrayList<Integer>   frasesParaPalavras;
	ArrayList<Palavras>  arrayPalavras;
	ArrayList<Persistir> arrayFrases;
	
	boolean verificacao = true;// caso true é uma palavra, caso contrário e uma frase.
	Random random;
	
	public JanelaGame( )
	{
		super("Janela Game");
		
		campoPalavra   = new JTextField("(Ctrl) for start.");
		campoEntrada   = new JTextField("");
		
		facil		   = new JCheckBox("Easy");
		dificil		   = new JCheckBox("Hard");
		medio          = new JCheckBox("Medium");
		
		interacao		= new JLabel("to train a few sentences of this word, press (Alt).");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		campoPalavra.setHorizontalAlignment(JTextField.CENTER);
		campoEntrada.setHorizontalAlignment(JTextField.CENTER);
		
			
		interacao.setHorizontalAlignment(JLabel.CENTER);
		
		interacao.setFont( new Font("Consolas",Font.PLAIN,20) );
		campoEntrada.setFont( new Font("Consolas",Font.PLAIN,20) );
		campoPalavra.setFont( new Font("Consolas",Font.PLAIN,20) );
		
		campoPalavra.setForeground(Color.gray);
		
		//                     x,y-20 largura, altura;
		campoPalavra.setBounds(175,24,400,70);
		campoEntrada.setBounds(103,295,535,70);
		facil.setBounds(190,270,100,25);
		medio.setBounds(340,270,100,25);
		dificil.setBounds(500,270,100,25);
		interacao.setBounds(1,124,750,70);
		
		c.add(campoPalavra);
		c.add(campoEntrada);
		
		c.add(facil);
		c.add(medio);
		c.add(dificil);
		
		c.add(interacao);
		
		campoPalavra.setEditable(false);
		
		campoEntrada.addKeyListener( new OuvirTeclado() );
		facil.addItemListener( new OuvirItens() );
		medio.addItemListener( new OuvirItens() );
		dificil.addItemListener(new OuvirItens());
		
		gg = GameGestor.obterInstancia();
		arrayPalavras = gg.gerarExercicio();
		arrayFrases   = (ArrayList<Persistir>) gg.obterColecao(Tipos.FRASE).clone();

		random = new Random();
		
		setSize(750,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private String embaralhar ( String temp )
	{
		String resul = "";
		int cont=0;
		ArrayList<Integer> inteiros = new ArrayList<>();
		boolean flag = true;
		
		String[] array = temp.split(" ");
		
		Random r = new Random();
		
		while(cont < array.length)
		{
			int aux = r.nextInt(array.length);
			flag = true;
			
			for(int a  : inteiros )
			{
				if( a == aux) flag = false;
			}
			
			if( flag )
			{
				resul += " "+array[aux];
				inteiros.add(aux);
				cont++;
			}
		}
		System.out.println(resul);
		return resul;
	}
	
	private class OuvirTeclado implements KeyListener
	{

		//Verificação se a String digitada até momento corresponde com a mostrada no painel.
		public void keyPressed(KeyEvent arg0) 
		{
			if( arg0.getKeyCode() == KeyEvent.VK_CONTROL)
			{
				//System.out.println("Tamanho da lista de exercicio : " + arrayPalavras.size());
				verificacao = true;
				//arrayPalavras.remove(indicep);
				
				if( arrayPalavras.size() > 0 ) 
				{
					indicep = random.nextInt(arrayPalavras.size());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Fim do exercício."); 
					dispose();
					return;
				}
				
				campoPalavra.setText(arrayPalavras.get(indicep).getConteudo());
				temp = campoPalavra.getText();
				contador = 0 ;
			}
			
			if( arg0.getKeyCode() == KeyEvent.VK_ALT)
			{
				verificacao = false;
				Palavras palavra = arrayPalavras.get(indicep);
				frasesParaPalavras = palavra.getArl();
				
				indicef = random.nextInt(frasesParaPalavras.size());
				temp = arrayFrases.get(frasesParaPalavras.get(indicef)).getConteudo();
				System.out.println("Apertei alt o valor do indice f é " + indicef);
				interacao.setText(temp);
			}
		}

		
		public void keyReleased(KeyEvent arg0) 
		{
			//Limpar campo e aumentar o contador de palavra ou frase digitada.
			if( temp.toLowerCase().equals( campoEntrada.getText().toLowerCase() ) )
			{
				System.out.println("Correta.");
				Persistir ob = null;
				
				if( verificacao )
				{
					ob = arrayPalavras.get(indicep);
					ob.setContador();
					System.out.println( ob.getContador() );
					
					gg.atualizar(ob);
				}
				else
				{
					ob = arrayFrases.get(frasesParaPalavras.get(indicef));
					ob.setContador();
					
					gg.atualizar(ob);
				}
				
				//Adicionando a palavra nova;
				if( contador++ == 1 ) 
				{
					//campoPalavra.setText("");
					if( !verificacao )interacao.setText(embaralhar(temp));
					contador = 0;
				}
				campoEntrada.setText("");
			}
			
			//Verificação gráfica para avisar para o usuário que ele está digitando a sentença correta.
			if( temp.toLowerCase().startsWith( campoEntrada.getText().toLowerCase() ) )
			{
				campoEntrada.setForeground(Color.BLUE);
			}	
			else
			{
				campoEntrada.setForeground(Color.RED);
			}
		}

		public void keyTyped(KeyEvent arg0)
		{
			
		}
	}
	
	
	private class OuvirItens implements ItemListener
	{
		JCheckBox box;
		
		
		public void itemStateChanged(ItemEvent arg0) 
		{
			box = ( JCheckBox ) arg0.getSource();
			
			switch ( box.getText() )
			{
			case "Easy":
				System.out.println("facil");
				
				medio.setSelected(false);
				dificil.setSelected(false);
				break;
			case "Medium":
				System.out.println("médio");

				facil.setSelected(false);
				dificil.setSelected(false);
				break;
			case "Hard":
				System.out.println("difícil");
				
				facil.setSelected(false);
				medio.setSelected(false);
				break;
			}
		}
	}
}
