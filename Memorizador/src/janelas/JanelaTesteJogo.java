package janelas;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tipos.Exercicio;
import tipos.Palavras;
import adm.Arquivo;

public class JanelaTesteJogo  extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField visor, entrada;
	private JLabel inf;
	private Exercicio exercicio;
	private ArrayList<Palavras> temporario;
	private Arquivo arq;
	private Palavras palavraTemp;
	private JButton botao;
	
	
	public JanelaTesteJogo( )
	{
		super("Treinando....");
		
		visor = new JTextField("Teste memória");
		entrada= new JTextField("");
		inf = new JLabel("");
		botao = new JButton("Del");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		visor.setBounds(10,10,380,40);
		entrada.setBounds(10,130,300,40);
		inf.setBounds(10,50,380,40);
		botao.setBounds(320,130,60,40);
		
		visor.setFont( new Font("Consolas",Font.PLAIN,20) );
		entrada.setFont( new Font("Consolas", Font.PLAIN,20));
		visor.setEnabled(false);
		
		visor.setHorizontalAlignment(JTextField.CENTER);
		entrada.setHorizontalAlignment(JTextField.CENTER);
		inf.setHorizontalAlignment(JLabel.CENTER);
		
		c.add(visor);
		c.add(entrada);
		c.add(inf);
		c.add(botao);
		
		setSize(405,205);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
		//Adicionando Eventos aqui
		entrada.addKeyListener( new OuvirTeclado() );
		botao.addActionListener( new Ouvir() );
		
		arq = new Arquivo("Armazem.bin");
		temporario = arq.recuperar();
		exercicio = new Exercicio(temporario);
		pegarPalavraExercicio();
	}
	
	private void limparCampos()
	{
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
		inf.setText(palavraTemp.getInf());
		System.out.println(palavraTemp.getPalavra());
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
			
			if( arg0.getKeyCode() == KeyEvent.VK_ALT )
			{
				visor.setText(palavraTemp.getPalavra());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0)
		{
			//Verificar se a palavra é identica ao do exercicio, se a palavra for a mesma será pego outra do exercicio
			if(palavraTemp.getPalavra().toLowerCase().equals(entrada.getText().toLowerCase()))
			{
				exercicio.remover(palavraTemp);
				pegarPalavraExercicio();		
				System.out.println("Palavra correta");
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
			
			if( arg0.getKeyCode() == KeyEvent.VK_ALT )
			{
				visor.setText("Teste Memória");
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) 
		{
		  
		}
	}
	
	private class Ouvir implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JButton temp = ( JButton ) arg0.getSource();
			
			if( temp.getText().equals("Del") )
			{
				for( int i = 0 ; i < temporario.size() ; i++)
				{
					if(temporario.get(i).getPalavra().equals(palavraTemp.getPalavra()))
					{
						temporario.get(i).setEstudavel(false);
						arq.gravar(temporario);
						break;
					}
				}
				
				exercicio.remover(palavraTemp);
				pegarPalavraExercicio();
			}
		}
	}
}
