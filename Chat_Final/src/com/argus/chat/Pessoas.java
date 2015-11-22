package com.argus.chat;

public class Pessoas 
{
	private String nick;
	private int    id;
	protected Classe classe;
	
	public Pessoas( String nick , int id )
	{
		this.id = id;
		this.nick = nick;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getId() {
		return id;
	}
	
}
