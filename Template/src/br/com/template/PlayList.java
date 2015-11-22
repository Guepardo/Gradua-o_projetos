package br.com.template;

import java.util.ArrayList;

public class PlayList 
{
		ArrayList<Musicas> musicas;
		
		public PlayList()
		{
			musicas = new ArrayList<>();
		}
		
		public void carregarMusicas ( Musicas musica )
		{
			musicas.add(musica);
		}
		
		public ArrayList<Musicas> getList()
		{
			return musicas;
		}
}
