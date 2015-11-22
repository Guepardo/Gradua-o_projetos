/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */

package Lista_Render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListaRender extends JLabel implements ListCellRenderer<Object> 
{
	private static final long serialVersionUID = -790032084677788679L;

	public ListaRender ()
	{
		setOpaque(true);
	}
	
	public Component getListCellRendererComponent(JList<?> list, Object value,int index, boolean isSelected, boolean cellHasFocus) 
	{
		    // O valor values é dividido em três partes id - nick - estatus
            /*0 = online
			  1 = ocupado
			  2 = ausente
			  3 = offline*/
		
			String [] path = {"/Imagens/Online.png","/Imagens/Ocupado.png","/Imagens/Ausente.png","/Imagens/Offline.png"};
			int a=0;
			String [] resul = value.toString().split("-");
			
			switch(resul[2])
			{
			case "AUSENTE":
				a = 2;
				break;
			case "OFFLINE":
				a = 3;
				break;
			case "ONLINE" :
				a = 0;
				break;
			case "OCUPADO":
				a = 1 ;
				break;
			}
			
	        setIcon(new ImageIcon(getClass().getResource(path[a])));  
	        setText(resul[1]);
	        
	        //Testes de seleção e foco.
	        if(isSelected){
	            setForeground(list.getSelectionForeground());
	            setBackground(list.getSelectionBackground());	            
	          }
	          else{
	            setForeground(list.getForeground());
	            setBackground(list.getBackground());	            
	          }
	        
	        if(cellHasFocus){
	            setForeground(Color.GRAY);
	            setBackground(Color.darkGray);	       
	          }
	          else{
	            setForeground(list.getForeground());
	            setBackground(list.getBackground());	           
	          } 
	      return this;
	}
}
