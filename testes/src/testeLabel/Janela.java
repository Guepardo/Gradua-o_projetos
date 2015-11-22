package testeLabel;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Janela extends JFrame
{
	JLabel j;
	JButton b;
	
	Janela ()
	{
		Container c = getContentPane();
		j= new JLabel();
		b = new JButton("Mudar");
		c.setLayout( new GridLayout(1,2,1,1));
		
		c.add(j);
		c.add(b);
		
		b.addActionListener( new Ouvir() );
		
		setVisible( true );
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private class Ouvir  implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			j.setIcon( new ImageIcon(getClass().getResource("Loading.gif")));
		}
	}
}
