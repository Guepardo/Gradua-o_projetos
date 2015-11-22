import java.util.ArrayList;


public class Teste {

	public static void main(String[] args) {
	    Id n ;
	    int cont=0;
	    
	    String allysom = " Allysom";
	    System.out.println(allysom.indexOf(" "));
	    
	    if (allysom.charAt(0) == ' '){
	    	System.out.println("Verdade");
	    }
		ArrayList <Id> stat = new ArrayList <Id>();
		
        stat.add(new Id("alias",0));
        stat.add(new Id("vadia",0));
        stat.add(new Id("meda",0));
        stat.add(new Id("caralho",0));
        stat.add(new Id("bixa",0));
        stat.add(new Id("teclado",0));
        stat.add(new Id("porrada",0));
        stat.add(new Id("eita",0));
        stat.add(new Id("melda",0));
        stat.add(new Id("roda",0));
        
      
        
        
        while ( stat.size() > cont)
        {
        	n = stat.get(cont);
        	
        	if ( n.a.equals("eita"))
        	{
        		n.d++;
        		stat.remove(cont);
        		stat.add(cont,n);
        	}
        	
        	cont++;
        }
        
        
    
	}
	
}