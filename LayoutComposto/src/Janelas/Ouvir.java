package Janelas;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ouvir implements ActionListener {
	
	String menssage = null;
	JTextField t;
	
	public Ouvir (String menssage, JTextField t ){
		this.menssage = menssage;
		this.t = t;
	}
	
	public void actionPerformed(ActionEvent evento ){
		JOptionPane.showMessageDialog(null, evento.toString());
	}
	  

}
