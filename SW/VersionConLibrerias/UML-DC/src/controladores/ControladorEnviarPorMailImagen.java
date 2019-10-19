package controladores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import datos.Clase;
import datos.DJCorreoTexto;
import datos.DiagramaDeClase;
import datos.Version;
import negocio.ClaseABM;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;



public class ControladorEnviarPorMailImagen extends HttpServlet {
	
	
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
				
				
				String link = request.getParameter("link");
	
				String enviarA = request.getParameter("enviarA");
				String enviadoPor = request.getParameter("enviadoPor");
				String asunto = request.getParameter("asunto");
				
		
			
				String rutaRelativaApp= getServletContext().getRealPath("/");
				System.out.println(rutaRelativaApp);
				
				
				
				//aca escribo el txt
				
				FileWriter fichero = null;
		        PrintWriter pw = null;
		        try
		        {
		            fichero = new FileWriter(rutaRelativaApp +"/texto.txt");
		            pw = new PrintWriter(fichero);

		            
		                pw.print(link);

		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		           try {
		           // Nuevamente aprovechamos el finally para 
		           // asegurarnos que se cierra el fichero.
		           if (null != fichero)
		              fichero.close();
		           } catch (Exception e2) {
		              e2.printStackTrace();
		           }
		        }
				
		        
		        
		        
		        
		      
				
				
				
				
				
				DJCorreoTexto correoTexto = new DJCorreoTexto();
				correoTexto.mandarDCPorCorreoSoloImagen(enviarA, enviadoPor, asunto, link,rutaRelativaApp);
				
				
				
				
				//int idVersion = Integer.parseInt( request.getParameter("idVersion"));
				
				
				
				request.getRequestDispatcher("/inicioVisual.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}