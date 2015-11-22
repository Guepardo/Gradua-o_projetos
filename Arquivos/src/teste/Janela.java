package teste;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Janela extends JFrame
{
	JProgressBar bar;
	
	public Janela ( )
	{
		super("Teste");
		
		bar = new JProgressBar();
		
		Container c = getContentPane();
		c.setLayout(null);
		
		bar.setBounds(1,1,400,30);
		
		c.add(bar);
		
		
		setResizable(false);
		setSize(405,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setNomeBar( String nome )
	{
		bar.setStringPainted(true);
		bar.setString(nome);
	}
	
	public void setMaxMin( int max , int min )
	{
		bar.setMaximum(max);
		bar.setMinimum(min);
		
	}
	
	public void progress ( int progress )
	{
		bar.setValue(progress);
	}
	
	public void reset ()
	{
		bar.setValue(0);
		bar.setMaximum(0);
		bar.setMinimum(0);
		bar.setString("");
	}
}
