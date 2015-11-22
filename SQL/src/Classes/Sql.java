package Classes;

import java.sql.*;

import javax.swing.JOptionPane;

public class Sql {
	
	String url = "jdbc:mysql://localhost:3306/malle?user=root&password=master";
	Connection con;
	Statement stmt;
	ResultSet rs ; 
	
  public Sql(){
			 try {
				con = DriverManager.getConnection(url,"root","master");
				System.out.println("Status : "+ con );
				stmt = con.createStatement();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro na conexão.");
				e.printStackTrace();
			}
	 
  }
  
  public void  Enviar ( String nome , String email ){
	  try {
		stmt.executeUpdate("insert into pessoas (nome,email) values ('"+nome+"','"+email+"');");
		stmt.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
  }
  
}
