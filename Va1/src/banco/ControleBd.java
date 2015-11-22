package banco;

import java.sql.ResultSet;

//Esta classe ir� converter objetos para a linguagem Sql e tratar� das intera��es
//com o banco de dados
public class ControleBd {
	private static ControleBd single = null;
	
	public static ControleBd getSingleControleBd(){
		if( single == null )single = new ControleBd();
		return single;
	};
	
	public boolean insert(){
		return false;
	};
	
	public boolean update(){
		return false;
	};
	
	public boolean delete(){
		return false;
	};
	
	public ResultSet select(){
		return null;
	};
		
}
