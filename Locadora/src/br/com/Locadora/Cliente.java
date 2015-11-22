package br.com.Locadora;

public class Cliente extends ItemPersistencia
{
	private String nome,endereco;
	
	public Cliente ( String nome , String endereco , int id )
	{
		super(id);
		
		this.nome = nome;
		this.endereco = nome;
		classe = Classe.CLIENTE;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
