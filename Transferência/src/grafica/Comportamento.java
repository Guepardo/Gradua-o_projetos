package grafica;

public interface Comportamento 
{
	public void setMaxMinBar( int max , int min );
	public void setNameBar( String name );
	public void setProgressBar( int progress );
	public void resetBar();
	public String chooserCopy();
	public String chooserPaste();
	public void send();
	public void addFileFrame(String file );
}
