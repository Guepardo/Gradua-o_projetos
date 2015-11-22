package Improve.admin;


import java.util.ArrayList;

import Improve.janelas.JanelaGame;
import Improve.janelas.JanelaObterConteudo;
import Improve.tipos.Frases;
import Improve.tipos.Palavras;
import Improve.tipos.Persistir;

public class Test {

	public static void main(String[] args) 
	{
		/*
		ArrayList<Frases> arl = new ArrayList<>();
		Arquivo arq = new Arquivo("Frase.bin");
		
		arl.add(new Frases(true , false , false,"Olá mundo do Java1?"));
		arl.add(new Frases(true , false , false,"Olá mundo do Java2?"));
		arl.add(new Frases(true , false , false,"Olá mundo do Java3?"));
		arl.add(new Frases(true , false , false,"Olá mundo do Java4?"));
		arl.add(new Frases(true , false , false,"Olá mundo do Java?5"));
		arl.add(new Frases(true , false , false,"Olá mundo do Java6?"));
		
		arq.gravar(arl);
		
		arl.clear();
		
		arl = null;
		
		arl = arq.recuperar();
		
		for (Frases a : arl )
		{
			System.out.println("Conteudo da frase : "+ a.getConteudo());
		}
		*/
		
		  new JanelaGame();
		  //new JanelaObterConteudo();
		
		/*
		GerenciadorPalavras gp = new GerenciadorPalavras();
		GerenciadorFrases   gf = new GerenciadorFrases ();
		
		ArrayList<Frases>     f = gf.obterColecao();
		
		ArrayList<Palavras> arl = gp.gerarContexto(f);
		
		for( int i = 0 ; i < arl.size() ; i++ )
		{
			ArrayList<Integer> indices = arl.get(i).getArl();
			
			if( indices != null)
			{
				for( int x = 0 ; x < indices.size() ; x++ )
				{
					System.out.println("Palavra : "+arl.get(i).getConteudo()+" | "+x+" Frase : " + f.get(indices.get(x)).getConteudo());
				}
			}
		}
		
		
		*/
		
		GameGestor gg = GameGestor.obterInstancia();
		ArrayList<Persistir> f = gg.obterColecao(Tipos.FRASE);
		
		for(Palavras a : gg.gerarExercicio())
		{
			ArrayList<Integer> array = a.getArl();
			System.out.println("Palavra : "+ a.getConteudo());
			
			for( int i = 0 ; i < array.size() ; i++)
			{
				System.out.println(i + " | "+f.get(array.get(i)).getConteudo());
			}
			System.out.println("--------------------------------------");
		}
		
	}
}
