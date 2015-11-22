/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */
package chat.rede;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import chat.tipos.Classe;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Audio implements Runnable
{
	String[] path = {"/Sons/AlertaOnline.mp3","/Sons/AlertaMensagem.mp3"};
	int id=0;
	
    public Audio ( Classe classe )
    {
    	switch(classe.toString())
    	{
    	case "ONLINE" :
    		id = 0;
    		break;
    	case "MENSAGEM" :
    		id = 1;
    		break;
    	}
    }
    
    
	public void run() 
	{
		FileInputStream in;
		 try 
		 {
		  //Inicializa o FileInputStream com o endereço do arquivo para tocar
			 in = new FileInputStream(getClass().getResource(path[id]).getFile());

		  //Cria uma instancia da classe player passando para ele o InpuStream do arquivo
			 Player p = new Player(in);

		  //executa o som
			 
			 p.play();
		 } 
		 catch (FileNotFoundException e) 
		 {
			 e.printStackTrace();
		 } 
		 catch (JavaLayerException w) 
		 {
			 w.printStackTrace();
		 }
	}
}
