package principal;

import grafica.Control;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

import nada.Arquivo;

public class Ouvir implements Runnable
{
	private ObjectInputStream ois;
	private Arquivo arq;
	private Control c;
	
	public Ouvir(ObjectInputStream ois )
	{
		this.ois = ois;
		c = Control.getInstence();
		arq = new Arquivo();
	};

	public void run() 
	{
		String controle = null;
		OutputStream out = null;
		
		while( true )
		{
			try 
			{
				System.out.println("Lendo....");
				Protocolo p = ( Protocolo )  ois.readObject();
				
				if( Tipo.ARQUIVO == p.getTipo() )
				{ 
					if( !p.getRelativo().equals(controle) )
					{
						if( out != null) out.close();
						controle = p.getRelativo();
						arq.criaDiretorio(c.getDestino()+p.getRelativo(),p.getTipo());
						out = new FileOutputStream(c.getDestino()+p.getRelativo());
						c.setNameBar(p.getRelativo());
						c.setMaxMinBar( (int ) p.getParteTotal(),0);
					}
					out.write(p.getBuffer(),0,p.getCont()); 
					c.setProgressBar(( int ) p.getParteAtual());
					out.flush();
					System.out.println("Arquivo : " + p.getRelativo() +" Parte total : "+ p.getParteTotal() + " Parte atual : " + p.getParteAtual());
				}
				else
				{ 
					out.close();
					JOptionPane.showMessageDialog(null,"Envio concluído.");
				}
				p = null;
			} 
			catch (IOException | ClassNotFoundException e ) 
			{
				JOptionPane.showMessageDialog(null,"Erro na Thread Ouvir!");
			}
			System.gc();
		}
	};
}
