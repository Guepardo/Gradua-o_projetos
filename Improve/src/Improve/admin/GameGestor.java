package Improve.admin;


import java.util.ArrayList;
import java.util.Hashtable;

import Improve.tipos.Palavras;
import Improve.tipos.Persistir;


public class  GameGestor 
{
	private static GameGestor gg = null;
	private Hashtable<Tipos,Gerenciador> busca;
	private ArrayList<Palavras> exercicio;
	
	
	public GameGestor()
	{
		busca = new Hashtable<>();
		busca.put( Tipos.PALAVRA , new GerenciadorPalavras());
		busca.put( Tipos.FRASE   , new GerenciadorFrases()  );
	}
	
	
	public static GameGestor obterInstancia ()
	{
		if( gg == null )gg = new GameGestor();
		return gg;
	}
	
	
	public boolean inserir ( Persistir ob )
	{
		return busca.get( ob.getTipo() ).inserir(ob);
	}
	
	
	public boolean retirar ( Persistir ob )
	{
		return busca.get( ob.getTipo() ).retirar(ob);
	}
	
	
	private  ArrayList<Palavras> gerarContexto()
	{
		 GerenciadorPalavras gp = (GerenciadorPalavras) busca.get(Tipos.PALAVRA);
		 return gp.gerarContexto( busca.get( Tipos.FRASE ).obterColecao() );
	}
	
	
	public boolean atualizar ( Persistir ob )
	{
		return busca.get(ob.getTipo()).atualizar(ob);
	}
	
	
	public ArrayList<Persistir> obterColecao ( Tipos tipo )
	{
		return busca.get(tipo).obterColecao();
	}
	
	
	/*
	 * Gerar uma lista de para o exercício
		dificil - repete 3 vezes
		medio   - repete 2 vezes
		facil   - repete 1 vez.
	 * */
	public ArrayList<Palavras> gerarExercicio ( )
	{
		exercicio = new ArrayList<>();
		ArrayList<Palavras> temp =gerarContexto();
		
		for( int i = 0 ; i < temp.size(); i++ )
		{
			int copias = 0;
			
			if(temp.get(i).isDificil()) copias = 3;
			if(temp.get(i).isMedio()  ) copias = 2;
			if(temp.get(i).isFacil()  ) copias = 1;
			if(temp.get(i).isBranco() ) copias = 0;
			
			while( copias-- != 0 )
			{
				exercicio.add(temp.get(i));
			}
		}
		return exercicio;
	}
}
