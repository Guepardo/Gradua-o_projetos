package GUI;
import java.awt.event.*;
import javax.swing.*;

public class Listener implements ActionListener  {
	String b;
	Listener( String a ){
		b = a ;
	}
	
	public void actionPerformed(ActionEvent evento){
		JOptionPane.showMessageDialog(null,b);
	}

}
