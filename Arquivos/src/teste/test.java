package teste;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class test
{

	public static void main(String[] args) 
	{
		
		JFileChooser escolher = new  JFileChooser();
		escolher.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		String path = null;
		
		 if( escolher.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
		 {
		System.out.println(escolher.getSelectedFile().toString());
		 path = escolher.getSelectedFile().toString();
		 }
		 
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
					// System.out.print("É um diretório: ");
					 File listar = new File(path+"\\"+b);
					 for( String dir : listar.list() ) temp.add(b+"\\"+dir);
					 if(listar.list().length == 0 ) arquivo.add(path+"\\"+b);
				 }
				 else
				 {
					 //System.out.print("É um arquivo : ");
					 arquivo.add(path+"\\"+b);
				 }
				 //System.out.println(path+"\\"+b); 
			 }
			 diretorio = (ArrayList<String>) temp.clone();
			 temp.clear();
		 }	 
		 for ( String aux : arquivo ) System.out.println(aux);
	}
}
