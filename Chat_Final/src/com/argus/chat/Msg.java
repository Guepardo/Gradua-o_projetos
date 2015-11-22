package com.argus.chat;

public class Msg 
{
	private int id_remetente;
	private String msg,nick;
	
	public Msg(int id_remetente , String msg , String nick )
	{
		this.id_remetente = id_remetente;
		this.msg = msg;
		this.nick = nick;
	}

	public int getId_remetente() {
		return id_remetente;
	}

	public String getMsg() {
		return msg;
	}

	public String getNick() {
		return nick;
	}
	
}
