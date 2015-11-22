package testes;

import janelas.JanelaPrincipal;

import java.util.ArrayList;
import java.util.Random;



public class TesteGrafico 
{
	public static void main ( String [] args )
	{
		//new JanelaJogo();
		new JanelaPrincipal();
		
		/*
		Arquivo arq = new Arquivo("Armazem.bin");
		
		ArrayList<Palavras> arl = new ArrayList<>();
		
		arl.add( new Palavras("alright","Uma palavras em inglês", true ) );
		arl.add( new Palavras("already","Uma palavras em inglês", true ) );
		arl.add( new Palavras("address","Uma palavras em inglês", true ) );
		arl.add( new Palavras("afraid","Uma palavras em inglês", true ) );
		arl.add( new Palavras("advertisement","Uma palavras em inglês", true ) );
		arl.add( new Palavras("sick","Uma palavras em inglês", true ) );
		arl.add( new Palavras("cut","Uma palavras em inglês", true ) );
		arl.add( new Palavras("cat","Uma palavras em inglês", true ) );
		arl.add( new Palavras("dog","Uma palavras em inglês", true ) );
		arl.add( new Palavras("accompany","Uma palavras em inglês", true ) );
		arl.add( new Palavras("accept","Uma palavras em inglês", true ) );
		arl.add( new Palavras("accident","Uma palavras em inglês", true ) );
		arl.add( new Palavras("accompany","Uma palavras em inglês", true ) );
		arl.add( new Palavras("actually","Uma palavras em inglês", true ) );
		arl.add( new Palavras("Dictionary","What you're reading right now?", true ) );
		arq.gravar(arl);
		
		/*
		String a = "parabolica";
		
		for( int i = 0 ; i < 6 ; i++ )
		{
			a = tiraLetras(a,"parabolica");
		}
		*/
	}
		
	public static String tiraLetras (String palavra , String palavraEstatica )
	{
		int tamanho = palavra.length();
		
		Random rand = new Random();
		
			char array [] = new char[tamanho];
			
			for( int b = 0 ; b < tamanho ; b++ ) array[b] = palavra.charAt(b);
			
			int cont = 0;
			int verificador = -1;
			
			if( !palavra.contains(" ") )
			{
				while(cont < tamanho/2 )
				{
					int temp = rand.nextInt(tamanho);
					
					if( temp != verificador && palavra.charAt(temp) != ' ' )
					{
						array[temp] = ' ';
						verificador = temp;
						cont++;
					}
				}
			}
			else
			{
				while(cont < 1 )
				{
					int temp = rand.nextInt(tamanho);
					
					if( palavra.charAt(temp) == ' ')
					{
						array[temp] = palavraEstatica.charAt(temp);
						cont++;
					}
				}
			}
			
			System.out.println( new String(array));
			return new String(array);
		}
}

