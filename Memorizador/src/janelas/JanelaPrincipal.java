package janelas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import tipos.Palavras;
import adm.Arquivo;

public class JanelaPrincipal extends JFrame
{
	private JButton treino, memoria;
	private JTextArea estatisticas;
	
	public JanelaPrincipal()
	{
		super("Escolhar o seu destino");
		
		Container c = getContentPane();
		c.setLayout(null);
		
		treino = new JButton("Treino");
		memoria = new JButton("Memória");
		estatisticas = new JTextArea("");
		
		treino.setBounds(40,200,100,40);
		memoria.setBounds(160,200,100,40);
		estatisticas.setBounds(10,10,270,100);
		
		c.add(treino);
		c.add(memoria);
		c.add(estatisticas);
		
		setSize(300,300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		treino.addActionListener( new Ouvir() );
		memoria.addActionListener( new Ouvir() );
		
		gerarEstatisticas();
	}
	
	private void gerarEstatisticas()
	{
		Arquivo arq = new Arquivo("Armazem.bin");
		ArrayList<Palavras> array = arq.recuperar();
		
		int estudavel = 0 ,naoEstudavel = 0;
		
		for( Palavras p : array )
		{
			if( p.isEstudavel() )
			{
				estudavel++;
			}
			else
			{
				naoEstudavel++;
			}
		}
		estatisticas.setText("Total de palavras cadastradas : " + (estudavel+naoEstudavel) +" Palavras\n");
		estatisticas.append("Em aprendizagem                       : " + estudavel +" Palavras.\n");
		estatisticas.append("Aprendidas                                    : " + naoEstudavel + " Palavras.");
	}
	
	private class Ouvir implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) 
		{
			JButton temp = ( JButton )  arg0.getSource();
			
			if(temp.getText().equals("Memória"))
			{
				new JanelaTesteJogo();
			}
			
			if(temp.getText().equals("Treino") )
			{
				new JanelaJogo();
			}	
		}
	}
}
