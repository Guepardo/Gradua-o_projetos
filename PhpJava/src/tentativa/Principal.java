package tentativa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Principal {
  public static void main(String[] args) {
    String n1 = "20", n2 = "92387374";
    URL url;
    HttpURLConnection connection = null;
    BufferedReader in = null;
    DataOutputStream out = null;
    try {
      // vamos montar o conte�do a ser enviado
      String dados = "a=" + URLEncoder.encode(n1, "UTF-8");
      dados += "&b=" + URLEncoder.encode(n2, "UTF-8");
      dados += "&n=" + URLEncoder.encode("Allysom maciel guimaraes","UTF-8");
      
      url = new URL("http://argus.zz.mu/ht.html");
      // vamos efetuar a conex�o � URL especificada
      connection = (HttpURLConnection)url.openConnection();
      // vamos habilitar a escrita na URLConnection
      connection.setDoOutput(true);
      // vamos nos conectar usando o m�todo POST
      connection.setRequestMethod("POST");
      // aqui n�s definimos o tipo da requisi��o
      connection.setRequestProperty("Content-Type",
        "application/x-www-form-urlencoded");
      
      // vamos enviar os dados
      out = new DataOutputStream(connection.getOutputStream());
      out.writeBytes(dados);
      out.flush();
      out.close();
      
      // vamos obter o retorno da conex�o
      String linha;
      in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      while((linha = in.readLine()) != null) {
        System.out.println(linha);
      }
    } 
    catch (MalformedURLException ex) {
      System.out.println("A URL est� mal formada: " + ex.getMessage());
    }
    catch (IOException ex) {
      System.out.println("N�o foi poss�vel efetuar a conex�o: " + ex.getMessage());
    }
    finally {
      if(out != null) {
        try {
          out.close();
        } 
        catch (IOException ex) {
          System.out.println("N�o consegui fechar o stream de entrada: " + ex.getMessage());
        }
      }
      if(in != null) {
        try {
          in.close();
        } 
        catch (IOException ex) {
          System.out.println("N�o consegui fechar o stream de sa�da: " + ex.getMessage());
        }
      }
      connection.disconnect();
    }
  }
}