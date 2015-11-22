package teste;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class test2 {

	public static void main(String[] args) throws IOException 
	{
	  File f = new File("C:\\Users\\Allysom\\Desktop\\Nova Pasta\\dfadsf.ds");
	  
	  System.out.println(f.exists());
	  
	  if( !f.exists() )
	  {
		  Path p = Paths.get("C:\\Users\\Allysom\\Desktop\\Nova Pasta\\dfadsf.ds");
		  
		  Files.createDirectories(p.getParent());
	  }
	  else
	  {
		  
	  }
	}

}
