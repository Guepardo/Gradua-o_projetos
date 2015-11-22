package Classes;

import java.io.*;

import javazoom.jl.player.Player;

public class Reproduzir implements Runnable
{
  FileInputStream file;
  String musica;
  
	  public Reproduzir(String musica) 
	  {
		  this.musica = musica;
		  
		  try {
			  		file =  new FileInputStream(musica);
		      } 
		      catch (FileNotFoundException e) 
		      {
		    	    e.printStackTrace();
		      }
	  }
  

	public void run() 
	{
		 try{
			  Player p = new Player(file);
			  p.play();
			
		     }
		     catch(Exception erro)
		     {
		    	 System.err.printf("Falha ao abrir o arquivo de áudio : método run , classe Reproduzir");
		     }
	}


	public void Tocar ()
	{
		 Runnable tocar = new Reproduzir(musica);
		 new Thread(tocar,"Tocando").start();
	}



}