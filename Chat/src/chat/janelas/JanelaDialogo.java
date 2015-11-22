/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*//////////////////////////////////versão 1.7*/
//criado por Erick
//alterado por Erick
package chat.janelas;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import chat.tipos.Amigos;
import chat.tipos.Msg;
import chat.tipos.Usuario;
import chat.rede.Rede;
/**
 *
 * @author ErIcK
 */
public class JanelaDialogo extends JFrame { 
	Amigos ami;
	Usuario usu;
	Msg msg1;
        public JanelaDialogo (Msg msg1 , Amigos ami , Usuario usu)
    {
	
        super("JanelaChat v1.7 Conversa com : " + ami.getNick());
		this.ami = ami;
		this.usu = usu;
		this.msg1= msg1;
        unir();
        if(msg1 != null)
        {
        	if(flag2==true)atualizar(msg1);
        	flag2=false;
        }
        setSize(600,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private static final long serialVersionUID = -698604143537396277L;
    Container geral;//container com o text area e o container (text) T
    Container geral2;//container que contem todo mundo no centro e espaço em margens 
    Container textoarea;//container contendo o textarea N
    Container botoes;//Container de botoes e caixa de seleção C
    Container text;//container que contem o container( msg e enviar ) T
    Container text2;//container msg e enviar T
   JTextArea texto;
   JTextArea msg;
    JComboBox <String> combo;
    JComboBox <String> cores;
    JButton troca;
    JButton enviar;
    JScrollPane scroll;
    JScrollPane msgscroll;
    JLabel label;
   String infomsg;
   boolean flag=false,flag2=true;
    int tamlet = 12;
    JCheckBox italico,negrito;
  
    class Tscroll implements AdjustmentListener{ //rolagem automatica
      public void adjustmentValueChanged(AdjustmentEvent e) {
    	  if(flag)
    	  {  
    		  e.getAdjustable().setValue(e.getAdjustable().getMaximum());
    	  }
    	  flag = false;
    } 
  }
  
    public void elementoTexto ()
    {
        textoarea = new JPanel();
        textoarea.setLayout(new BorderLayout(5,5));
        texto = new JTextArea();
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setFont(new Font("Consolas",Font.PLAIN,tamlet));
        texto.setEditable(false);
        scroll = new JScrollPane(texto);
        scroll.getVerticalScrollBar().addAdjustmentListener(new Tscroll());
        textoarea.add(BorderLayout.CENTER, scroll);
    }
    
    public void elementoButao()
    {
        botoes = new JPanel();
        troca=new JButton("Alterar layout");
        botoes.setLayout(new GridLayout(1,5,6,6));
        italico=new JCheckBox("Italico");
        negrito = new JCheckBox("Negrito");
        italico.addItemListener(new ControleMarcacao());
        negrito.addItemListener(new ControleMarcacao());
        combo = new JComboBox<>();
        cores = new JComboBox<>();
        combo.addItem("Tamanho 9");
        combo.addItem("Tamanho 10");
        combo.addItem("Tamanho 11");
        combo.addItem("Tamanho 12");
        combo.addItem("Tamanho 13");
        combo.addItem("Tamanho 14");
        combo.addItem("Tamanho 15");
        combo.addItem("Tamanho 16");
        combo.addItem("Tamanho 17");
        combo.addItem("Tamanho 18");
        combo.addItem("Tamanho 19");
        combo.addItem("Tamanho 20");
        combo.addItem("Tamanho 21");
        combo.addItem("Tamanho 22");
        combo.addItemListener(new ControleCombo());
        cores = new JComboBox<>();
        cores.addItem("Default");
        cores.addItem("Vermelho");
        cores.addItem("Verde");
        cores.addItem("Azul");
        cores.addItemListener(new ControleCores());
        botoes.add(cores);
        botoes.add(combo);
        botoes.add(troca);
        botoes.add(negrito);
        botoes.add(italico);
        textoarea.add(BorderLayout.NORTH,botoes);
    }

    public void unir()
    {
        elementoTexto ();
        elementoButao ();
        JLabel norte = new JLabel(" ");
        JLabel sul = new JLabel(" ");
        JLabel leste = new JLabel("   ");
        JLabel oeste = new JLabel("   ");
        msg=new JTextArea(4,4);
        msg.setLineWrap(true);
        msg.setWrapStyleWord(true);
        msg.addKeyListener(new enter());
        text2 = new JPanel();
        msgscroll= new JScrollPane(msg);
        enviar=new JButton("Enviar");
        enviar.addActionListener(new Enviar());
        text = new JPanel();
        text.setLayout(new GridLayout(1,2,5,5));
        text2.setLayout(new BorderLayout(5,5));
        text2.add(BorderLayout.CENTER,msgscroll);
        text2.add(BorderLayout.EAST,enviar);
        text.add(text2);
        geral2 = getContentPane();
        geral = new JPanel();
        geral.setLayout(new BorderLayout(5,5));
        geral.add(BorderLayout.CENTER,textoarea);
        geral.add(BorderLayout.SOUTH,text);
        geral2.add(BorderLayout.CENTER,geral);
        geral2.add(BorderLayout.NORTH,norte);
        geral2.add(BorderLayout.SOUTH,sul);
        geral2.add(BorderLayout.WEST,oeste);
        geral2.add(BorderLayout.EAST,leste);
    } 
    // classes listener
    class ControleMarcacao implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent e) {
            if(negrito.isSelected() && italico.isSelected())
            {
                texto.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,tamlet));
            }else if(negrito.isSelected())
            {
                texto.setFont(new Font("Serif",Font.BOLD,tamlet));
            }else if( italico.isSelected())
            {
                texto.setFont(new Font("Serif",Font.ITALIC, tamlet));
            }else {
                texto.setFont(new Font("Serif",Font.PLAIN,tamlet));
            }        
    
    }
}
    
class ControleCombo implements ItemListener {

    @Override
    public void itemStateChanged(ItemEvent e) {
             if(e.getStateChange()== ItemEvent.SELECTED)
            {
                int temp=combo.getSelectedIndex();
                if(temp==0)tamlet=9;
                else
                {
                    tamlet=9+temp;
                }
                texto.setFont(new Font("",Font.PLAIN,tamlet));
            } 
    }
    
}    
    
 
class ControleCores implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent e) {
             if(e.getStateChange()== ItemEvent.SELECTED)
             {
                 switch(cores.getSelectedIndex())
                 {
                     case 0:
                         texto.setForeground(Color.black);
                         break;                         
                     case 1:
                         texto.setForeground(Color.red);
                         break;
                     case 2:
                         texto.setForeground(Color.green);
                      break;
                     case 3:
                         texto.setForeground(Color.blue);
                     break;
                 }  
             }
            }
    }
    private class Enviar implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
		if ( msg.getText().length()  > 0  )
			{
				if(msg.getText()!=null)
				{	
				String enviar = msg.getText().trim();
				msg.setText(null);
				String hora=(new Rede().enviarMsg(usu.getUsuario(),ami.getUsuario(),usu.getSenha(),enviar));
				infomsg="Você diz as "+hora+" : \n"+enviar;
				texto.append(infomsg+"\n");
				infomsg = null;
				hora=null;
				flag=true;
				}
			}
    }
    }
    public void atualizar ( Msg msg)
	{
    	String enviar = msg.getTexto();
		texto.append(ami.getNick()+" diz as "+msg.getHora()+":"+msg.getMinuto()+":"+msg.getSegundo()+" # \n"+enviar+"\n");
		enviar=null;
		flag=true;
	}
    
    class enter implements KeyListener{
		public void keyPressed(KeyEvent ke) {
			if (ke.getKeyCode() == KeyEvent.VK_ENTER) { 	
				ke.consume();
				if(msg.getText().length()!=0)
				{
				String enviar = msg.getText().trim();
				msg.setText(null);
				String hora=(new Rede().enviarMsg(usu.getUsuario(),ami.getUsuario(),usu.getSenha(),enviar));
				infomsg="Você diz as "+hora+" : \n"+enviar;
				texto.append(infomsg+"\n");
				infomsg = null;
				hora=null;
				flag=true;
				}
		    } 
			
		}

		@Override
		public void keyReleased(KeyEvent ke) {

		}

		@Override
		public void keyTyped(KeyEvent ke) {

		}
			
    	
    }
}

