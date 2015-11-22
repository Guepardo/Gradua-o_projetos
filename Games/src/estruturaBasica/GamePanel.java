package estruturaBasica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable
{
	private static final long serialVersionUID = 1L;
	public static int ALTURA = 400;
	public static int LARGURA = 700;
	
	private Thread thread;
	private boolean rodando;
	private BufferedImage image;
	private Graphics2D g;
	private int x=0,y=0;
	
	public GamePanel()
	{
		super();
		setPreferredSize( new Dimension(LARGURA, ALTURA) );
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify()
	{
		super.addNotify();
		if( thread == null)
		{
			thread = new Thread(this);
			thread.start();
		}
	}


	public void run() 
	{
		rodando = true;
		
		image = new BufferedImage( LARGURA , ALTURA, BufferedImage.TYPE_INT_RGB);
		
		g = (Graphics2D) image.getGraphics();
		
		while( rodando )
		{
			gameUpdate();
			gameRender();
			gameDraw();
		}
	}
	
	private void gameUpdate()
	{
		x++;
		y++;
	}
	
	private void gameRender()
	{
		g.setColor(Color.WHITE);
		g.fillRect(0,0, LARGURA, ALTURA);
		g.setColor(Color.BLACK);
		g.fillOval(x, y,10,10);
	}
	
	private void gameDraw()
	{
		Graphics g2 = this.getGraphics();
		
		g2.drawImage(image,0,0,null);
		g2.dispose();
	}
}
