package br.com.Locadora;

public class Fita extends ItemPersistencia
{
	String nome,autor;
	
	public Fita( int id , String nome , String autor )
	{
		super(id);
		this.nome = nome;
		this.autor = autor;
		classe = Classe.FITA;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
