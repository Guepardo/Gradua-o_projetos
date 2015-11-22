package teste;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Arq 
{
	public static void main ( String[] args )
	{
		
		File saida   = new File( new File("D:/"),"2.txt");
		File entrada = new File("D:/2.txt");
		
		FileInputStream i = null;
		FileOutputStream o = null;
		
		try 
		{
			i = new FileInputStream( entrada );
			o = new FileOutputStream( saida  );
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		BufferedInputStream in = new BufferedInputStream ( i );
		BufferedOutputStream out= new BufferedOutputStream( o );
		
		int x;
		
		try 
		{
			while((x = in.read()) != -1 )
			{
				out.write(x);
				System.out.println(" Byte : " + x );
			}
			
			out.flush();
			out.close();
			in.close();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
