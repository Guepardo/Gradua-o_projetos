package Classes;

import java.sql.*;

import javax.swing.JOptionPane;


public class BancoDados {
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con;
	PreparedStatement stm;
	
	public void BancoDados( ){
		
		try {
				con = DriverManager.getConnection(url,"allysom","master");
		 	} 
		catch (SQLException e) 
		   {
			    JOptionPane.showMessageDialog(null,"Erro no servidor.");
				e.printStackTrace();
		   }
	
	}
	
	public void Cadastrar(String nome,String email){
				try {
						stm = con.prepareStatement("insert to malle value(2,'"+nome+"','"+email+"');");
						stm.executeUpdate();
				    } catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Erro no servidor.");
						e.printStackTrace();
				    }
		}
		
}
	

