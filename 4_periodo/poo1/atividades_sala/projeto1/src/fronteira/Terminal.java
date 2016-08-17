package fronteira;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Terminal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
    public String leStringdoTeclado(){
    	 BufferedReader teclado = new BufferedReader(  
    		      new InputStreamReader( System.in ));  
    	 
    	 try {
			return teclado.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
	

}
