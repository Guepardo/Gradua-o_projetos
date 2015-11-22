package tipos;

import java.util.ArrayList;
import java.util.Random;

public class Exercicio 
{
	private ArrayList<Palavras> array;
	
	public Exercicio( ArrayList<Palavras> array )
	{
		this.array = new ArrayList<>();
		
		for( Palavras p : array )
		{
			if( p.isEstudavel() )
			{
				this.array.add(p);
			}
		}
	};
	
	public Palavras getPalavra()
	{
		if( array.size() == 0 ) return null;
		
		Random random = new Random();
		Palavras temp;
		
		int aleatorio = random.nextInt(array.size());
		temp = array.get(aleatorio);
		
		return temp;
	};
	
	public void remover ( Palavras palavra )
	{
		for( int i = 0 ; i < array.size() ; i++)
		{
			if( array.get(i).getPalavra().equals( palavra.getPalavra() ) )
			{
				array.remove(i);
			}
		}
	};
}
