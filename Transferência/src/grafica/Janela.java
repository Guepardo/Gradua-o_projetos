package grafica;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Janela extends JFrame implements Comportamento
{
	private static final long serialVersionUID = 1L;
	private JTextArea campoCopia,campoDestino,lista,campoCliente;
	private JButton    copiar,destino,conectar,enviar;
	private JLabel     ipServidor;
	private JProgressBar bar;
	private Control control = null;
	
	public Janela ()
	{
		super("Transferência");
		setLayout( null );
		
		Container c = getContentPane();
		
		c.add( painel1(null) );
		c.add( painel2() );
		c.add( painel3() );
		
		copiar.addActionListener( new Ouvir() );
		destino.addActionListener( new Ouvir());
		conectar.addActionListener( new Ouvir());
		enviar.addActionListener( new Ouvir());
		
		setSize(565,335);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		control = Control.getInstence();
	};
	
	public JPanel painel1( String ipServidor )
	{
		/*Contém o label com o ip do servidor;
		 * Botão 'Copiar'
		 * Label  JTextField mostrando o caminho a ser copiado.*/
		JPanel temp = new JPanel(null);
		
		this.ipServidor = new JLabel("Servidor IP : " + ipServidor);
		copiar = new JButton("Copiar");
		campoCopia = new JTextArea("");
		
		this.ipServidor.setBounds(5, 1,160, 20);
		copiar.setBounds(5,20,80,30);
		campoCopia.setBounds(90,20,450,30);
		
		temp.add(this.ipServidor);
		temp.add(copiar);
		temp.add(campoCopia);
		
		temp.setBounds(1,1,565,53);
		return temp;
	};
	
	public JPanel painel2()
	{
		JPanel temp = new JPanel(null);
		
		lista = new JTextArea("");
		JScrollPane scroll = new JScrollPane(lista);
		scroll.setBounds(5,1,540,165);
		temp.add(scroll);
		
		temp.setBounds(1,55,565,170);
		return temp;
	};
	
	public JPanel painel3()
	{
		JPanel temp = new JPanel(null);
		
		destino = new JButton("Destino");
		enviar  = new JButton("Enviar");
		conectar = new JButton("Conectar");
		campoDestino = new JTextArea("");
		campoCliente = new JTextArea("");
		bar = new JProgressBar();
		
		bar.setStringPainted(true);
		
		destino.setBounds(5,1,80,30);
		campoCliente.setBounds(5,35,80,30);
		campoDestino.setBounds(90,1,450,30);
		conectar.setBounds(90,35,90,30);
		enviar.setBounds(440,35,100,30);
		bar.setBounds(190,35,239,30);
		
		temp.add(destino);
		temp.add(campoDestino);
		temp.add(campoCliente);
		temp.add(conectar);
		temp.add(enviar);
		temp.add( bar );
		
		temp.setBounds(1,225,565,170);
		return temp;
	};

	public void setMaxMinBar(int max, int min) 
	{
		bar.setMaximum(max);
		bar.setMinimum(min);
	};

	@Override
	public void setNameBar(String name)
	{
		bar.setString(name);
	};

	@Override
	public void setProgressBar(int progress)
	{
		bar.setValue(progress);
	};

	@Override
	public void resetBar()
	{
		bar.setValue(0);
		bar.setMaximum(0);
		bar.setMinimum(0);
		bar.setString("");
	}

	@Override
	public  String chooserCopy() 
	{
		String temp;
		temp = chooser();
		campoCopia.setText(temp);
		return temp;
	};

	@Override
	public String chooserPaste() 
	{
		String temp;
		temp = chooser();
		campoDestino.setText(temp);
		return temp;
	};


	public void conect() 
	{
		
	};

	@Override
	public void send() 
	{
		
	};

	@Override
	public void addFileFrame(String file) 
	{
		lista.append(file +"\n");
	};
	
	private String chooser( )
	{
		JFileChooser escolher = new  JFileChooser();
		escolher.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		if( escolher.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
		{
			System.out.println(escolher.getSelectedFile().toString());
			return escolher.getSelectedFile().toString();
		}
		return null;
	};
	
	private class Ouvir implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			JButton temp = (JButton) arg0.getSource();
			System.out.println(temp.getText());
			switch( temp.getText() )
			{
			case "Copiar" : 
				control.chooserCopy();
			break;
			case "Destino":
				control.chooserPaste();
			break;
			case "Conectar":
				control.conect(campoCliente.getText().trim(),28000);
			break;
			case "Enviar" :
				control.send();
			break;
			}
		};
	}
}
