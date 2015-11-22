/*
 * Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * Ateraçãos : ----
 */
package chat.administrativo;

import java.util.ArrayList;
import java.util.Iterator;

import chat.tipos.Amigos;

public class IteratorAmigos implements Iterator<Object>
{
	ArrayList<Amigos> ami;
	int id;
	
	
	public IteratorAmigos (ArrayList<Amigos> ami)
	{
		this.ami = ami;
		id = 0;
	}
	
	public boolean hasNext()
	{
		return(id != ami.size());
	}

	
	public Amigos next() 
	{
		return ami.get(id++);
	}


	public void remove()
	{
		
		
	}
}
