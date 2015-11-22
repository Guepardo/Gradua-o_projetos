package Improve.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Improve.tipos.Frases;
import Improve.tipos.Persistir;

public class Arquivo 
{
	private String nomeArquivo;
	private ObjectOutputStream oos;
	private ObjectInputStream  ois;
	private FileInputStream    fis;
	
	public Arquivo( String nomeArquivo )
	{
		this.nomeArquivo = nomeArquivo;
		oos = null;
		ois = null;
	}
	
	public ArrayList<Persistir> recuperar ()
	{
		ArrayList<Persistir> arl = new ArrayList<>();
		Persistir ob;
		File f = new File( nomeArquivo );
		
		try 
		{
			if( f.exists() )
			{
				ois = new ObjectInputStream( fis = new FileInputStream( nomeArquivo ) );
				
				while( fis.available() > 0 )
				{
					ob = (Persistir) ois.readObject();
					arl.add(ob);
				}
			}
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if ( ois != null ) ois.close();
				if ( fis != null ) fis.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		return arl;
	}
	
	public void gravar (ArrayList<Persistir> arl )
	{
		File arq = new File(nomeArquivo);
		
		if( arq.exists() ) arq.delete();		
		
		try 
		{
			oos = new ObjectOutputStream( new FileOutputStream( nomeArquivo ) );
			
			for( int i = 0 ; i < arl.size() ; i++ )
			{
				oos.writeObject( arl.get(i) );
			}
		} 
		catch ( IOException e) 
		{
			e.printStackTrace();
		}
	}
}
