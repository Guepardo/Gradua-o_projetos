package Rulles;

import java.io.IOException;

public class Receber  implements Runnable {
   Principal Controle;
   boolean flag = true;
   
   public void run (){
	Controle = new Principal();
	
	while( flag )
	{
		try
		{
			System.out.println(Controle.entrada.readLine());
		}
		catch(IOException erro)
		{
			
		}
		
	}
	
   }
}
