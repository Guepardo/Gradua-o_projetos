package banco;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Esta classe apenas se conecta ao banco de dados e oferece serviços básicos:
//Inserir sql com retorno booleano e inserir sql com o retorno de uma Resultset.
public class Bd {
	
	private final String conector = "jdbc:postgresql://localhost:5432/aliens";
	private final String user = "postegres";
	private final String senha= "12345";
	Statement executor;
	
	//Carrega os drivers necessários para se criar um executor.
	Bd() throws SQLException{
		 try {
		      Class.forName("org.postgresql.Driver");
		      System.out.println("JDBC driver carregado.");
		    }
		    catch (ClassNotFoundException e) {
		      System.out.println(e.toString());
		    }
		 executor = DriverManager.getConnection(conector,user,senha).createStatement();
	};
	
	//Injeta Sql ao banco de dados e retorna true ou false;
	public boolean injetarSql( String sql ){
		try {
			return executor.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	};
	
	//Injeta Sql ao banco de dados e retorna um ResultSet.
	public ResultSet insjetarSql(String sql ){
		try {
			return executor.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
