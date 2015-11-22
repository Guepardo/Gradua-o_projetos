package chat.rede;
/*Classe versão 0.1
 * Autor : Allysom Maciel Guimarães
 * alterado por Erick, Luiz
 * */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import chat.administrativo.IteratorAmigos;
import chat.tipos.Amigos;
import chat.tipos.Classe;
import chat.tipos.Msg;
import chat.tipos.Pessoas;
import chat.tipos.Usuario;

public class Rede 
{
	 	private URL url;
	 	private HttpURLConnection connection = null;
	 	private BufferedReader in = null;
	 	private DataOutputStream out = null;
	 	
	 	private String tempCode (String endereço , String dados )
	 	{
	 		String flag ="0";
	 		try 
	    	{
	    		
		    	//Preparação da Url
	    		url = new URL(endereço);
					
			    connection = (HttpURLConnection)url.openConnection();
			    connection.setDoOutput(true);
			    connection.setRequestMethod("POST");
	            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		        //Fim Preparação.
		        
			    //Enviando dados
			    out = new DataOutputStream(connection.getOutputStream());
			    out.writeBytes(dados);
			    out.flush();
			    out.close();
			    //Fim Envio de dados.
			           
			    //Obtendo Resposta
			    String linha="",temp;
			    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			    
			    while((temp = in.readLine()) != null)if( temp != null)linha += temp;
			    System.out.println(linha);
			    flag = linha;
			    
			    //Fim Obtendo Resposta
	    	}
	    	catch (MalformedURLException ex) 
	    	{
	    	      System.out.println("A URL está mal formada: " + ex.getMessage());
	    	}
	    	catch (IOException ex) 
	    	{
	    	     System.out.println("Não foi possível efetuar a conexão: " + ex.getMessage());
	    	}
	    	finally 
	    	{
	    	      if(out != null) 
	    	      {
	    	    	  try 
	    	    	  {
	    	    		  out.close();
	    	    	  } 
	    	    	  catch (IOException ex) 
	    	    	  {
	    	    		  System.out.println("Não consegui fechar o stream de entrada: " + ex.getMessage());
	    	    	  }
	    	      }
	    	      
	    	      if(in != null) 
	    	      {
	    	        try 
	    	        {
	    	        	in.close();
	    	        } 
	    	        catch (IOException ex) 
	    	        {
	    	        	System.out.println("Não consegui fechar o stream de saída: " + ex.getMessage());
	    	        }
	    	      }
	    	      connection.disconnect();
	    	}
	 		return flag;
	 	}
	 	
	    public boolean cadastrar( String nome , String nick , String usuario , String senha ) 
	    {

	    	String dados="";
		    try 
		    {
				dados  = "nome="+ URLEncoder.encode(nome,"UTF-8");
				dados += "&nick="+ URLEncoder.encode(nick,"UTF-8");
			    dados += "&usuario="+ URLEncoder.encode(usuario,"UTF-8");
			    dados += "&senha="+ URLEncoder.encode(senha,"UTF-8");
			}
		    catch (UnsupportedEncodingException e) 
			{
			
				e.printStackTrace();
			}
		    	
	    	return tempCode("http://argus.zz.mu/Cadastro/Cadastro.php",dados).equals("1");
	    }
	    
	    //----------------------------------------------------------------------------------------
	    
	    public boolean manterAmigo (String usuario1 , String usuario2 , String hash , int recusar )
	    {
	    	//-1 solicitar; 0 aceitar; 1 rejeitar; 2 bloquear; 3 remover/excluir; .
	    	
	    	String dados="";
		    try 
		    {
		    	if( recusar == -1 )//Solicitar
		    	{
				    dados  = "usuario1="+ URLEncoder.encode(usuario1,"UTF-8");
					dados += "&usuario2="+ URLEncoder.encode(usuario2,"UTF-8");
				    dados += "&hash="+ URLEncoder.encode(hash,"UTF-8");
		    	}
		    	else //Rejeitar ou Aceitar
		    	{
		    		dados  = "usuario1="+ URLEncoder.encode(usuario1,"UTF-8");
					dados += "&usuario2="+ URLEncoder.encode(usuario2,"UTF-8");
				    dados += "&hash="+ URLEncoder.encode(hash,"UTF-8");
				    dados += "&recusar="+ URLEncoder.encode(String.valueOf(recusar),"UTF-8");
		    	}    
			} 
		    catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
			}
		    	
	    	return tempCode("http://argus.zz.mu/Amigos/Solicitar.php",dados).equals("1");
	    }
	    
	    //----------------------------------------------------------------------------------------
	    
	    public String enviarMsg(String usuario1 , String usuario2 , String hash , String msg )
	    {
	    	
	    
	    	String dados="";
		    try 
		    {
		    		dados  = "usuario1="+ URLEncoder.encode(usuario1,"UTF-8");
					dados += "&hash="+ URLEncoder.encode(hash,"UTF-8");
				    dados += "&usuario2="+ URLEncoder.encode(usuario2,"UTF-8");
				    dados += "&msg="+ URLEncoder.encode(URLEncoder.encode(msg, "UTF-8"), "UTF-8");
			} 
		    catch (UnsupportedEncodingException e) 
			{
			
				e.printStackTrace();
			}
		    String retorno = tempCode("http://argus.zz.mu/Mensagens/Enviar.php",dados); 
		    if(!retorno.equals("0")) { 
		    		String Horas = retorno.substring(0,2); 
		    		String Minutos=retorno.substring(2,4); 
		    		String Segundos=retorno.substring(4,6); 
		    		return Horas+":"+Minutos+":"+Segundos; 
		    	} 
		    return null;
	    }
	    
	    public ArrayList<Pessoas> listarContatos(String usuario , String hash )
	    {
	    	ArrayList<Pessoas> amigos = new ArrayList<>();
	    	String retorno="",dados="";
	    	
			
			  try 
			    {
				  	dados  = "usuario="+ URLEncoder.encode(usuario,"UTF-8");
					dados += "&senha="+ URLEncoder.encode(hash,"UTF-8");  
				} 
			    catch (UnsupportedEncodingException e) 
				{
				
					e.printStackTrace();
				}
			
	    	retorno = tempCode("http://argus.zz.mu/Amigos/Amigos.php",dados);
	    	
	    	//Transformando o texto em objetos
	    	String array[] = retorno.split(";");
	    	//Ordem de chegada dos dados: id,nick,nome,usuario;
	    	
	    	for(int i = 0 ; i < array.length ; i++ )System.out.println("Apos o Split: "+array[i]);
	    	
	    	for(int i = 1 ; i < array.length ; i++ )
	    	{
	    		String [] temp = array[i].split(",");
	    		amigos.add(new Amigos(temp[2],temp[1],temp[3],Integer.parseInt(temp[0]),Classe.OFFLINE,Classe.ACEITO));
	    	}
	    	
	    	//fim transformando em objetos.
	    	
	    	return amigos;
	    }
	    
	  //----------------------------------------------------------------------------------------
	    
	    public ArrayList<Msg> haMsgs(String usuario , String hash)
	    {
	    	ArrayList<Msg> msg = new ArrayList<>();
	    	String retorno="",dados="";
			
			  try 
			    {
				  	dados  = "usuario="+ URLEncoder.encode(usuario,"UTF-8");
					dados += "&hash="+ URLEncoder.encode(hash,"UTF-8");  
				} 
			    catch (UnsupportedEncodingException e) 
				{
				
					e.printStackTrace();
				}
			
	    	retorno = tempCode("http://argus.zz.mu/Mensagens/Recuperar.php",dados);
	    	
	    	/*
	    	 *  10 caracteres: ID do emissor
				10 caracteres: contador de mensagem
				2 pra hora, minuto, segundo, dia, mês
				4 pra ano
				10 pra qte de caracteres
	    	 * */
	    	
	    	if( retorno.length() < 45 ) return msg;
	    	
		    	do
		    	{
			    	int idEmissor   = Integer.parseInt(retorno.substring(0,10));
			    	int contMsg     = Integer.parseInt(retorno.substring(10,20));
			    	
			    	int hora        = Integer.parseInt(retorno.substring(20,22));
			    	int minuto      = Integer.parseInt(retorno.substring(22,24));
			    	int segundo     = Integer.parseInt(retorno.substring(24,26));
			    	
			    	int dia         = Integer.parseInt(retorno.substring(26,28));
			    	int mes         = Integer.parseInt(retorno.substring(28,30));
			    	int ano         = Integer.parseInt(retorno.substring(30,34));
			    	
			    	int qtdCaracter    = Integer.parseInt(retorno.substring(34,44));
			    	String texto="";
			    	
					try 
					{
						texto = URLDecoder.decode(retorno.substring(44,qtdCaracter+44),"UTF-8");
					} 
						catch (UnsupportedEncodingException e) 
					{
						
						e.printStackTrace();
					}
			    	
			    	//System.out.println("\n\n\nId emissor : "+idEmissor+" Contador msg: "+ contMsg+" | Hora : "+hora+" Minuto : "+minuto +" Segundo : "+segundo+" | Dia : "+dia+" Mês :"+mes+" Ano :"+ano+" Quantidade de Carácteres : "+qtdCaracter+" Msg : "+texto);
			    	
			    	msg.add( new Msg(idEmissor,contMsg,hora,minuto,segundo,dia,mes,ano,qtdCaracter,texto));
			    	
			       retorno = retorno.substring(44+qtdCaracter);
			    	
		    	}while(0 < retorno.length());
	    	
	    	return msg;
	    }
	    
	  //----------------------------------------------------------------------------------------
	    
	    public Usuario login (String usuario , String hash )
	    {
	    	String retorno="",dados="";
	    	Usuario usu;
	    	
			   /*
			    * Colocar função para gerar a senha MD5 aqui.
			    * */
	    	
			  try 
			    {
				  	dados  = "usuario="+ URLEncoder.encode(usuario,"UTF-8");
					dados += "&hash="+ URLEncoder.encode(hash,"UTF-8");  
				} 
			    catch (UnsupportedEncodingException e) 
				{
				
					e.printStackTrace();
				}
			
	    	retorno = tempCode("http://argus.zz.mu/Cadastro/Login.php",dados);
	    	
	    	if(retorno.equals("0")) return null;
	    	
	    	String [] array = retorno.split(";");
	    	
	    	usu = new Usuario(array[2],array[1],usuario,Integer.parseInt(array[0]),hash);
	    	
	    	return usu;
	    }
	    
	  //----------------------------------------------------------------------------------------
	    
	    public IteratorAmigos status(String usuario , String hash , Classe status , int verOffLine )
	    {
	    	ArrayList<Amigos> ami = new ArrayList<>();
	    	String dados = "" ,retorno = "" ;
	    	int statusInt = 0;
	    	
	    	 /*0 = online
			  1 = ocupado
			  2 = ausente
			  3 = offline
			  
			  retorno : 
			  
			  amizade recusada = -1; amizade pendente = 0; amizade aceita = 1
			  status_amizade,id,nick,nome,usuario,status
			  */
	    	
	    	switch(status.toString())
			{
			case "AUSENTE":
				statusInt = 2;
				break;
			case "OFFLINE":
				statusInt = 3;
				break;
			case "ONLINE" :
				statusInt = 0;
				break;
			case "OCUPADO":
				statusInt = 1 ;
				break;
			}
	    	
		    try 
		    {
		    		dados  = "usuario="+ URLEncoder.encode(usuario,"UTF-8");
					dados += "&hash="+ URLEncoder.encode(hash,"UTF-8");
				    dados += "&status="+ URLEncoder.encode(String.valueOf(statusInt),"UTF-8");
				    dados += "&offlines="+ URLEncoder.encode(URLEncoder.encode(String.valueOf(verOffLine), "UTF-8"), "UTF-8");
			} 
		    catch (UnsupportedEncodingException e) 
			{
				e.printStackTrace();
			}
		    
	    	retorno = tempCode("http://argus.zz.mu/Amigos/Status.php",dados);
	    	
	    	String[] array = retorno.split(";");
	    	
	    	for( int i = 0 ; i < array.length ; i++ )
	    	{
	    		String[] temp = array[i].split(",");
	    		Classe classe = null, statusAmizade = null;
	    		//status_amizade,id,nick,nome,usuario,status
	    		switch(Integer.parseInt(temp[5]))
				{
				case 2:
					classe = Classe.AUSENTE;
					break;
				case 3:
					classe = Classe.OFFLINE;
					break;
				case 0:
					classe = Classe.ONLINE;
					break;
				case 1:
					classe = Classe.OCUPADO ;
					break;
				}
	    		
	    		switch(Integer.parseInt(temp[0]))
				{
				case -1:
					statusAmizade = Classe.REJEITADO;
					break;
				case 0:
					statusAmizade = Classe.PENDENTE;
					break;
				case 1:
					statusAmizade = Classe.ACEITO;
					break;
				}
	    		//status_amizade,id,nick,nome,usuario,status
	    		//nome[3] ,nick[2], usuario[4] ,id[1] 
	    		
	    		ami.add(new Amigos(temp[3],temp[2],temp[4],Integer.parseInt(temp[1]),classe,statusAmizade));
	    	}
	    	return new IteratorAmigos(ami);
	    }
	    
	  //----------------------------------------------------------------------------------------
	    
}
