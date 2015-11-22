package nada;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) 
	{
		Arquivo arq = new Arquivo();
		
		String local = JOptionPane.showInputDialog("Entre com a unidade, exemplo D:, E: ...");
		
		arq.buscarArquivos(local.trim()+"//");

	}

}
