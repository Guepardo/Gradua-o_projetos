package br.com.template;

public class AudioPlayer {

	public static void main(String[] args)
	{
		PlayList pl = new PlayList();
		Ordenador ordenador;
		
		pl.carregarMusicas(new Musicas("Me dê um copo de vinho","Matanza",1968,4));
		pl.carregarMusicas(new Musicas("Nada a declarar","Matanza",1966,2));
		pl.carregarMusicas(new Musicas("Buraco de bala","Matanza",2000,5));
		pl.carregarMusicas(new Musicas("Esse seu buraquinho","Velhas virgens",1993,5));
		pl.carregarMusicas(new Musicas("Lake Bodom","Children of Bodom",2002,5));
		pl.carregarMusicas(new Musicas("Jumento Celestino","Mamonas Assassinas",1995,1));
		pl.carregarMusicas(new Musicas("Dance la marvada","Capiroto Dance",1800,1));
		pl.carregarMusicas(new Musicas("Jujuba calhente","Capiroto Dance",1801,1));
		pl.carregarMusicas(new Musicas("Sucupira","Capiroto Dance",2010,1));
		pl.carregarMusicas(new Musicas("Bacharidade","Yamandu",2013,5));
		pl.carregarMusicas(new Musicas(" I Know now","Capiroto Dance",1997,2));
		pl.carregarMusicas(new Musicas("Tatubis","Capiroto Dance",1999,2));
		
		
		System.out.println("\n--------------Ordenando por ano------------------\n");
		ordenador = new Ano(pl.getList());
		
		System.out.println("Nome                     |Autor               |Ano | Estrelas");
		for( Musicas temp : ordenador.ordenar())
		{
			System.out.printf("%25s|%20s|%4d|%d\n",temp.getNome(),temp.getAutor(),temp.getAno(),temp.getEstrelas());
		}
		
		System.out.println("\n--------------Ordenando por Estrelas-------------\n");
		ordenador = new Estrelas(pl.getList());
		System.out.println("Nome                     |Autor               |Ano | Estrelas");
		for( Musicas temp : ordenador.ordenar())
		{
			System.out.printf("%25s|%20s|%4d|%d\n",temp.getNome(),temp.getAutor(),temp.getAno(),temp.getEstrelas());
		}
		
		
	}

}
