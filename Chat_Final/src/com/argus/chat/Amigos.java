package com.argus.chat;

public class Amigos extends Pessoas
{
	private int status,contador;
	
	public Amigos(int id, String nick, int status , int contador)
	{
		super(nick,id);
		this.status = status;
		this.contador = contador;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}
	
}
