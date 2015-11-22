package grafica;

import javax.swing.JOptionPane;

import principal.Evento;

public class Control implements Comportamento
{
	private static Control c = null;
	private Janela janela;
	private Evento evento;
	private String destino,copia;
	
	public Control()
	{
		evento = new Evento(28000);
	}
	
	public static Control getInstence()
	{
		if( c == null )
		{	
			return c = new Control();
		}
		return c;
	};
	
	public void janelaInstance()
	{
		if( janela == null) janela = new Janela();
	}
	
	@Override
	public void setMaxMinBar(int max, int min)
	{
		janela.setMaxMinBar(max, min);
	};

	@Override
	public void setNameBar(String name)
	{
		janela.setNameBar(name);
	};

	@Override
	public void setProgressBar(int progress) 
	{
		janela.setProgressBar(progress);
	};

	@Override
	public void resetBar() 
	{
		janela.resetBar();
	};

	@Override
	public String chooserCopy() 
	{
		copia = janela.chooserCopy();
		return copia;
	};

	public String getDestino() {
		return destino;
	}

	public String getCopia() {
		return copia;
	}

	@Override
	public String chooserPaste() 
	{
		destino = janela.chooserPaste();
		return destino;
	};

	public void conect( String ip , int porta ) 
	{
		evento.modoCliente(ip,porta);
	};

	@Override
	public void send() 
	{
		if( copia != null )
		{
			evento.enviarArquivos(copia,1024*1024 * 5);
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Entre com os dados necessários");
		}
	};

	@Override
	public void addFileFrame(String file) 
	{
		janela.addFileFrame(file);
	};
}
