package controladores;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DJCorreoTexto;
import datos.DiagramaDeClase;
import datos.RandomString;
import negocio.DiagramaDeClaseABM;



public class ControladorCrearDiagrama extends HttpServlet {
	
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
procesarPeticion(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
procesarPeticion(request, response);
}



@SuppressWarnings("null")
private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			try {
				
				
			
			DiagramaDeClaseABM diagramaabm = new DiagramaDeClaseABM();
			
			
			
			String emailCreador = request.getParameter("emailCreador");
			String titulo = request.getParameter("titulo");
			
			String contrasenia = request.getParameter("contrasenia");
			
			
			
			if (contrasenia.isEmpty()) {
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
				correoTexto.mandarCorreo(emailCreador, contrasenia);
				
			}
			
			
			
			diagramaabm.agregar(titulo, emailCreador, contrasenia);
			
	
		   	
			request.getRequestDispatcher("/elegirDiagramaDeClases.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}




			
	
	
	

}

