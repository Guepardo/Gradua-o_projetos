package br.com.template;

public class Musicas
{
	private String nome,autor;
	private int estrelas,ano;
	
	public Musicas ( String nome , String autor , int ano , int estrelas )
	{
		this.nome = nome;
		this.autor = autor;
		this.ano = ano;
		this.estrelas = estrelas;
	}

	public String getNome() {
		return nome;
	}

	public String getAutor() {
		return autor;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public int getAno() {
		return ano;
	}
	
}
