package nada;



import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;

import java.util.ArrayList;

public class Arquivo 
{
	
	public ArrayList<Registro> buscarArquivos (String path )
	{
		 
		 File f = new File(path);
		 
		 String[] a = f.list();
		
		 ArrayList<String> diretorio = new ArrayList<>();
		 ArrayList<String> arquivo   = new ArrayList<>();
		 ArrayList<String> temp      = new ArrayList<>();
		 for(String b : a ) diretorio.add(b);
			 
		 while( diretorio.size() > 0 )
		 { 
			 for( String b  : diretorio )
			 { 
				 File aux = new File(path+"\\"+b);
				 if( aux.isDirectory())
				 {
					 File listar = new File(path+"\\"+b);
					 for( String dir : listar.list() ) temp.add(b+"\\"+dir);
					 if(listar.list().length == 0 ) arquivo.add(path+"\\"+b);
				 }
				 else
				 {
					 arquivo.add(path+"\\"+b);
				 }
			  }
			 	diretorio = (ArrayList<String>) temp.clone();
			 	temp.clear();
		 }	 
		 
		 ArrayList<Registro> registro = new ArrayList<>();
		 
		 try 
		 {
			 PrintWriter gravar = new PrintWriter(new FileWriter("Log.txt"));
		
			 for ( String aux : arquivo ) 
			 {
				 f = new File(aux);
				 registro.add( new Registro(aux, aux.substring(path.lastIndexOf("\\")), f.isFile(), f.length() ) );
				 
				 try
				 {
				 gravar.printf("Absoluto : "+aux+"%n");
				 gravar.printf("Relativo : "+ aux.substring(path.lastIndexOf("\\"))+"%n");
				 gravar.printf("É um diretório ?" +f.isDirectory()+"%n");
				 gravar.printf("É um arquivo   ?" +f.isFile()+"%n");
				 gravar.printf("Tamanho em bytes :" +f.length()+"%n");
				 gravar.printf("Tamanho em Kb :" +f.length()/1024+"%n");
				 gravar.printf("Tamanho em Mb :" +(f.length()/1024)/1024+"%n");
				 gravar.printf("-----------------------------------------%n%n");
				 
				
				 }
				 catch( java.util.UnknownFormatConversionException |  java.util.MissingFormatArgumentException e)
				 {
					 
				 }
			 }
			 gravar.close();
		 } 
		 catch ( IOException e)
		 {
				e.printStackTrace();
		 }
		return registro;
	};
	
	public void latencia( int laten )
	{
		try 
		{
			Thread.sleep(laten);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	};
}
