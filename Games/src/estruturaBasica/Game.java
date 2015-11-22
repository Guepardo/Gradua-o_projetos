package estruturaBasica;

import javax.swing.JFrame;

public class Game 
{
	public static void main ( String [] args )
	{
		JFrame janela = new JFrame("Primeiro Jogo em Java.");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setContentPane( new GamePanel() );
		
		janela.pack();
		janela.setVisible(true);
	}
}
