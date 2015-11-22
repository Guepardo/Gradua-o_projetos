/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package chat.janelas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import Lista_Render.ListaRender;
import chat.administrativo.ControlarAmigos;
import chat.administrativo.IteratorAmigos;
import chat.rede.Audio;
import chat.rede.Rede;
import chat.tipos.*;

public class JanelaPainel extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	
	private DefaultListModel<Object> dlm = new DefaultListModel<Object>();
	private Rede rede;
	private ControlarAmigos ca; 
	private Usuario usu;
	private JList<Object> lista;
	private Hashtable<Integer,JanelaDialogo> haInstancia = new Hashtable<>();
	private Hashtable<Integer,Amigos>        controleOnline = new Hashtable<>();
	private ArrayList<Integer>               solicitacaoJanela = new ArrayList<>();
	private ListaRender ad;
	
	
	public JanelaPainel(Usuario usu)
	{
		super("Chat - "+usu.getNick());
		//Iniciando variáveis
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		ca = new ControlarAmigos();
		lista = criarLista(ca.obterColecao(usu.getUsuario(),usu.getSenha()));
		lista.addMouseListener( new OuvirMouse() );
		//Fim-Iniciando variáveis
		
		//Distribuindo elementos em paineis
		JPanel painel = new JPanel(new GridLayout(2,1,2,2));
		
		painel.add(criarMenu());
		painel.add(infUsuario(usu));
		//Fim- Distribuição
		
		//Adicionando ao container.
		c.add(BorderLayout.WEST,lista);
		c.add(BorderLayout.NORTH,painel);
		//Fim-Adicionando ao container
		
		setSize(500,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Operações para inicar os sistema
		
		this.usu = usu;
		rede = new Rede();	
	}
	

	private JList<Object> criarLista(ArrayList<Pessoas> p )
	{
		JList<Object> lista = new JList<Object>();
		ad = new ListaRender();
		
		//Adicionando renderizador para os ítens
		lista.setCellRenderer(ad);
		lista.setModel(dlm);
		
		//Adicionando Elementos
		for(Pessoas pe :  p)
		{
			Amigos am = (Amigos) pe;
			dlm.addElement(am.getId()+"-"+am.getNick()+"-"+am.getStatus());
		}
	    //dlm.setElementAt("Allysom-2",0);
	    
	    //Adicionando configurações adicionais a Lista.
		lista.setFixedCellHeight(20);//altura
		lista.setFixedCellWidth(100);//largura
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Tipo de seleção
		
		return lista;
	}
	
	
	private JPanel infUsuario(Usuario usu)
	{
		JPanel temp = new JPanel(new GridLayout(1,2,2,2));
		
		temp.add(new JLabel(usu.getNick()));
		temp.add(new JLabel(usu.getNome()));

		return temp;
	}
	
	
	private JMenuBar criarMenu()
	{
		JMenuBar  menuBar = new JMenuBar();
		JMenu     menu;
		JMenuItem menuItem;
		
		String[] menuConteudo       = {"Contatos"};
		String[][] ItemMenuConteudo = {{"Enviar Convite",""},{"",""}};
		
		menuBar.setBackground(Color.LIGHT_GRAY);
		
		for(int i = 0 ; i < menuConteudo.length ; i++ )
		{
			menu = new JMenu(menuConteudo[i]);
			
			for( int x = 0 ; x < ItemMenuConteudo[i].length ; x++)
			{
				menuItem = new JMenuItem(ItemMenuConteudo[i][x]);
				menuItem.addActionListener(new OuvirAcao());
				menu.add(menuItem);
			}
			menuBar.add(menu);
		}
		return menuBar;
	}
	

	
	public void run() 
	{
		ArrayList<Msg> msg = new ArrayList<>();
		int checar = 0;
		
		chegarStatus();
		
		while(true)
		{
			try 
			{
				Thread.sleep(5000);
				msg = rede.haMsgs(usu.getUsuario(),usu.getSenha());
				
				for( Msg m  : msg )
				{
					if(haInstancia.containsKey(m.getIdEmissor()))
					{
						haInstancia.get(m.getIdEmissor()).atualizar(m);
						
						haInstancia.get(m.getIdEmissor()).setVisible(true);
					}
					else
					{
						if(haInstancia.get(m.getIdEmissor()) == null)haInstancia.remove(m.getIdEmissor());
						
						haInstancia.put(m.getIdEmissor(), new JanelaDialogo(m , ca.obter(m.getIdEmissor()) , usu));
					}
					
					new Thread(new Audio(Classe.MENSAGEM),"SomMensagem").start();
				}
				System.out.println("Tô rodando..");
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			//------------------------------------------------------------------------------------------------------
			//Obtendo status dos meus amigos e configurando na JList
			if(checar++ == 3 ) 
			{
				chegarStatus();
				checar = 0;
			}
		}
	}
	
	
	private void chegarStatus ()
	{
		//Definir dinamicamente a entrada do penúltimo parâmetro.
		IteratorAmigos ia = rede.status(usu.getUsuario(),usu.getSenha(),Classe.ONLINE,1);
		
		String[] list  = new String[dlm.size()];
		String[] ids   = new String[dlm.size()];
		String[] staold= new String[dlm.size()];
		
		for(int i = 0 ; i < dlm.size(); i++ )list[i] = dlm.getElementAt(i).toString();
		//Obtendo ids vindos da JList
		for(int i = 0 ; i < dlm.size(); i++ )
		{
			String[] temp  = list[i].split("-");
			ids   [i]      = temp[0];
			staold[i]      = temp[2];
		}
		
		while( ia.hasNext() )
		{
			Amigos ami = ia.next();
			
			for( int i = 0 ; i < dlm.size(); i++ )
			{
				if(Integer.parseInt(ids[i]) == ami.getId())
				{
					//Teste para saber quem está chegando com o estatos considerados 'ONLINE'
					if( ami.getStatus() == Classe.OCUPADO || ami.getStatus() == Classe.AUSENTE || ami.getStatus() == Classe.ONLINE)
					{
						if(!controleOnline.containsKey(ami.getId()))
						{
							new Thread(new Audio(Classe.ONLINE),"SomOnline").start();
							controleOnline.put(ami.getId(),ami);
						}
						
						System.out.println(ami.getNick()+" está online ");
					}
					else
					{
						controleOnline.remove(ami.getId());
					}
					
					dlm.setElementAt(ami.getId()+"-"+ami.getNick()+"-"+ami.getStatus(),i);
				}
				
				//Lançando janela de pendencia de amizade.
				if( ami.getStatusAmizade() == Classe.PENDENTE)
				{
					boolean flag = true;
					
					for( int x = 0 ; x < solicitacaoJanela.size() ; x++ )
					{
						if( ami.getId() == solicitacaoJanela.get(x) ) flag = false;
					}
					if(flag)
					{ 
						new JanelaLimbo(usu,ami); 
						solicitacaoJanela.add(ami.getId());
					}
				}
			}
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	//--------------------------------------CRIANDO CLASSE DE MOUSE LISTENER-----------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------
	
	
	private class OuvirMouse implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent arg0) 
		{
			if( arg0.getClickCount() == 2 )
			{
				System.out.println("Quantidade de Cliques:  " + arg0.getClickCount());
				System.out.println("Elemento selecionado: "+ lista.getSelectedValue());
				emergirJanelaMouse(lista.getSelectedValue().toString());
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	private void emergirJanelaMouse( String elemento )
	{
		String[] temp = elemento.split("-");
		int id =Integer.parseInt(temp[0]);
		
		if( haInstancia.containsKey(id) )
		{
			haInstancia.get(id).setVisible(true);
		}
		else
		{
			haInstancia.put(id, new JanelaDialogo(null,ca.obter(id),usu) );
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------
	//--------------------------------------CRIANDO CLASSE DE ACTION LISTENER----------------------------------------------
	//---------------------------------------------------------------------------------------------------------------------
	
	private class OuvirAcao implements ActionListener
	{
		JMenuItem item;
		
		public void actionPerformed(ActionEvent arg0)
		{
			item = (JMenuItem) arg0.getSource();
			
			System.out.println("Item precionado " + item.getText());
			
			if(item.getText().equals("Enviar Convite"))
			{
				new JanelaSolicitacao(usu);
				return;
			}	
		}	
	}
}
