package principal;

import grafica.Control;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Arquivo 
{
	
	public ArrayList<Registro> buscarArquivos (String path )
	{
		 Control c = Control.getInstence();
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
				 
				 c.addFileFrame(aux.substring(path.lastIndexOf("\\"))+"Tam :" +(f.length()/1024)/1024);
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
	
	public  void enviarArquivos( ArrayList<Registro> colecao , int tamBuffer , ObjectOutputStream oos )
	{
		DataInputStream in = null;
		byte[] buffer = new byte[tamBuffer];
                
		for( int a = 0 ; a < colecao.size(); a++ )
		{
			long parteTotal = ( int ) colecao.get(a).getTamanho()/tamBuffer;
			long parteAtual = 0 ;
			try 
			{
				in = new  DataInputStream( new FileInputStream(colecao.get(a).getAbsoluto()) );
				int cont;
				
				while( in.available() > 0 )
				{
					cont = in.read(buffer);
					oos.writeObject(new Protocolo(buffer,parteAtual++, parteTotal, colecao.get(a).getRelativo(),Tipo.ARQUIVO,cont));
					oos.flush();
                    oos.reset();
					latencia(1000);
				}
				in.close();//Alteração aqui
				if( a+1 == colecao.size() ) {oos.writeObject(new Protocolo(null,0,0,null,Tipo.FIM_ENVIO,0)); System.out.println("Fim envio");}
			} 
			catch ( IOException e) 
			{
				e.printStackTrace();
			}
		}
                buffer = null;
                in = null;
	};
	
	public void criaDiretorio( String dir , Tipo tipo ) throws IOException
	{
		Path p;
		File f;
		
		if( Tipo.ARQUIVO  == tipo )
		{
			p = Paths.get(dir);
			f = new File(p.getParent().toString());
			if( !f.exists() ) Files.createDirectories(p.getParent());  
		}
		else
		{
			p = Paths.get(dir);
			f = new File( dir );
			if( !f.exists() ) Files.createDirectories(p);
		}
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
