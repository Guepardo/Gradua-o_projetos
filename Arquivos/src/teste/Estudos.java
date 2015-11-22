package teste;


import java.io.*;



public class Estudos
{
	public static void main(String[] args) {
	    String name =   "E:/Riddick.3.2013.DVDRip.XviD.Dual.Audio-YKS/Riddick.3.2013.DVDRip.XviD.Dual.Audio-YKS.avi";
	    String target = "D:/copia.avi";
	    copyFile(name, target);
	}
	
	
	public static void copyFile(String sourceFile, String destFile){
	    try {       
	        InputStream in = new FileInputStream(sourceFile);
	        OutputStream os = new FileOutputStream(destFile);
	        byte[] buffer = new byte[1024];
	        int count;
	        
	        while ((count = in.read(buffer)) > 0) 
	        {
	            os.write(buffer, 0, count);
	        }
	        in.close();
	        os.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
		
	}
		
	
	
	
