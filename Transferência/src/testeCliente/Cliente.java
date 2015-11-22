package testeCliente;

import java.io.IOException;

import javax.swing.JOptionPane;

import principal.Evento;

public class Cliente 
{

	public static void main(String[] args) throws IOException 
	{
		Evento evento = new Evento(28000);
		
		evento.modoCliente("192.168.0.18",28000);
		JOptionPane.showMessageDialog(null,"Come�ar a copiar.");
		evento.enviarArquivos("E:\\Riddick.3.2013.DVDRip.XviD.Dual.Audio-YKS",(1024*1024)*5);
	}

}
