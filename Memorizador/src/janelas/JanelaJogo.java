package janelas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tipos.Exercicio;
import tipos.Palavras;
import adm.Arquivo;


public class JanelaJogo extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JTextField visor, entrada;
	private JLabel inf;
	private Exercicio exercicio;
	private ArrayList<Palavras> temporario;
	private Arquivo arq;
	private Palavras palavraTemp;
	private String tempVisor;
	private boolean trocaAutomatica = false;
	
	public JanelaJogo( )
	{
		super("Treinando....");
		
		visor = new JTextField("");
		entrada= new JTextField("");
		inf = new JLabel("adsfasdf");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		visor.setBounds(10,10,380,40);
		entrada.setBounds(10,130,380,40);
		inf.setBounds(10,50,380,40);
		
		visor.setFont( new Font("Consolas",Font.PLAIN,20) );
		entrada.setFont( new Font("Consolas", Font.PLAIN,20));
		
		visor.setHorizontalAlignment(JTextField.CENTER);
		entrada.setHorizontalAlignment(JTextField.CENTER);
		inf.setHorizontalAlignment(JLabel.CENTER);
		
		c.add(visor);
		c.add(entrada);
		c.add(inf);
		
		setSize(405,205);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		//Adicionando Eventos aqui
		entrada.addKeyListener( new OuvirTeclado() );
		
		arq = new Arquivo("Armazem.bin");
		temporario = arq.recuperar();
		exercicio = new Exercicio(temporario);
		pegarPalavraExercicio();
	}
	
	private void limparCampos()
	{
		visor.setText("");
		entrada.setText("");
		inf.setText("");
	}
	
	private void pegarPalavraExercicio()
	{
		palavraTemp = exercicio.getPalavra();
		
		if(palavraTemp == null )
		{
			limparCampos();
			inf.setText("Fim Exercício");
			
			return;
		}
		limparCampos();
		visor.setText(palavraTemp.getPalavra());
		tempVisor = palavraTemp.getPalavra().toLowerCase();
		inf.setText(palavraTemp.getInf());
	}
	
	public String tiraLetras (String palavra , String palavraEstatica )
	{
		int tamanho = palavra.length();
		
		Random rand = new Random();
		
		char array [] = new char[tamanho];
			
		for( int b = 0 ; b < tamanho ; b++ ) array[b] = palavra.charAt(b);
			
		int cont = 0;
		int verificador = -1;
		if( trocaAutomatica && !palavra.contains(" ") )
		{
			trocaAutomatica = false;
			exercicio.remover(palavraTemp);
			pegarPalavraExercicio();
			return palavraTemp.getPalavra().toLowerCase();
		}
			
		if( !palavra.contains(" ") )
		{
			trocaAutomatica = true;
				
			while(cont < tamanho/2 )
			{
				int temp = rand.nextInt(tamanho);
					
				if( temp != verificador && palavra.charAt(temp) != ' ' )
				{
					array[temp] = ' ';
					verificador = temp;
					cont++;
				}
			}
		}
		else
		{
			while(cont < 1 )
			{
				int temp = rand.nextInt(tamanho);
					
				if( palavra.charAt(temp) == ' ')
				{
					array[temp] = palavraEstatica.charAt(temp);
					cont++;
				}
			}
		}
			
		System.out.println( new String(array));
		return new String(array);
	}
	
	//Classe para ouvir o teclado.
	class OuvirTeclado implements KeyListener
	{

		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			if( arg0.getKeyCode() == KeyEvent.VK_CONTROL )
			{
				pegarPalavraExercicio();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0)
		{
			//Verificar se a palavra é identica ao do exercicio, se a palavra for a mesma será pego outra do exercicio
			if(palavraTemp.getPalavra().toLowerCase().equals(entrada.getText().toLowerCase()))
			{
				//pegarPalavraExercicio();
				tempVisor = tiraLetras(tempVisor,palavraTemp.getPalavra().toLowerCase());
				if( tempVisor != null ) visor.setText(tempVisor);
				entrada.setText("");
				//implementar a função para dinamizar o jogo e chamar aqui.
			}
			
			//Se o que foi digitado até momento estiver contido na palavra do exercício o campo entrada ficará azul.
			
			if(palavraTemp.getPalavra().toLowerCase().contains(entrada.getText().toLowerCase()))
			{
				entrada.setForeground(Color.BLUE);
			}
			else
			{
				entrada.setForeground(Color.RED);
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) 
		{
		  
		}
		
	}
}
