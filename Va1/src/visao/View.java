package visao;

import java.io.IOException;

import biz.source_code.miniTemplator.MiniTemplator;
import biz.source_code.miniTemplator.MiniTemplator.TemplateSyntaxException;

public class View {
	MiniTemplator generator;
	
	final String cadastro1 = "templates\\cad1.html";
	final String cadastro2 = "templates\\cad2.html";
	final String home = "templates\\home.html";
	private String caminhoAbsoluto;
	
	public View( String caminhoAbsoluto ){
		this.caminhoAbsoluto = caminhoAbsoluto;
	};
	
	public String gerarVeiw(){
		return gerarHome();//A princípio.
	}
	
	private String gerarHome(){
		System.out.println(caminhoAbsoluto+home);
		MiniTemplator gerador = null;
		try {
			gerador = new MiniTemplator(caminhoAbsoluto+home);
		} catch (TemplateSyntaxException | IOException e) {
			System.out.println("Não conseguir achar o template do home.");
			e.printStackTrace();
		}
		for(int a = 0 ; a < 100 ; a++ ){
		gerador.setVariable("nome","Alguma");
		gerador.setVariable("idade","234");
		gerador.setVariable("raca","Poodle");
		gerador.setVariable("cor","Black");
		gerador.setVariable("id1","1");
		gerador.setVariable("id2","1");
		gerador.addBlock("row");
		}
		
		return gerador.generateOutput();
	};
}
