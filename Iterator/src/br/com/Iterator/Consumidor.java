package br.com.Iterator;

import java.util.ArrayList;

public class Consumidor 
{
	
	public static void main ( String[] args )
	{   //Inciando Vetor
		int[] vetor ={1,2,3,4,5,6,7,8,9,10};
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		//Inciando o ArrayList
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);
		arrayList.add(8);
		arrayList.add(9);
		arrayList.add(10);
		
		
		//Criando Iteratores
		
		Iterator array = new IteratorArrayList(arrayList);
		Iterator vet   = new IteratorVetor(vetor);
		
		System.out.println("----------------Usando Iterator ArrayList--------------");
		while( array.hasNext())
		{
			System.out.println("Valor: " + array.next());
		}
		
		System.out.println("----------------Usando Iterator Vetor------------------");
		while( vet.hasNext() )
		{
			System.out.println("Valor: " + vet.next());
		}
	}
	
	
	
	
	
}
