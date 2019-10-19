package test;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import datos.DJCorreoTexto;
import datos.RandomString;

public class TestContraseniaRandom {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
	
	
		String contrasenia = "";
		
		
		   String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	       StringBuilder salt = new StringBuilder();
	       Random rnd = new Random();
	       while (salt.length() < 18) { // length of the random string.
	           int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	           salt.append(SALTCHARS.charAt(index));
	       }
	       String saltStr = salt.toString();
	     
	       contrasenia = saltStr;
		
		
		
	
		
		 DJCorreoTexto correoTexto = new DJCorreoTexto();
		  correoTexto.mandarCorreo("nico_perez_velez@hotmail.com", contrasenia);
		
	
	
	
	
	
	
	System.out.println(contrasenia);

}
	
	
     

    }
