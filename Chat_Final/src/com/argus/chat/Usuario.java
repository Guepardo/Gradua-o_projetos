package com.argus.chat;

public class Usuario extends Pessoas
{
	private String senha;
	
	public Usuario(String senha, int id, String nick )
	{
		super(nick,id);
		this.senha = senha;
		classe = Classe.USUARIO;
		
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
