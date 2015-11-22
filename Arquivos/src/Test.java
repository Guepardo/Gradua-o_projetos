import teste.Janela;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Janela j = new Janela();
		
		String [] arquivos  = {"Música.mp2","Foto.jpg","Um Fimle.mkv"};
		
		for( int b = 0 ; b < arquivos.length ; b++ )
		{
			j.setNomeBar(arquivos[b]);
			j.setMaxMin(10,0);
			for( int a = 0 ; a < 11 ; a ++)
			{
				j.progress(a);
				Thread.sleep(500);
			}
			
			j.reset();
		}
	}

}
