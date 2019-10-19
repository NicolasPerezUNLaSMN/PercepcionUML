package controladores;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer;
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



public class ControladorEnviarPorMail extends HttpServlet {
	
	
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
				
				
				String url = request.getParameter("url");
				String protocolo = request.getParameter("protocolo");
				String textoOir = request.getParameter("textoOir");
				String enviarA = request.getParameter("enviarA");
				String enviadoPor = request.getParameter("enviadoPor");
				String asunto = request.getParameter("asunto");
				
				System.out.println(url);
				System.out.println("------------------");
				System.out.println(textoOir);
				System.out.println("------------------");
				System.out.println(protocolo);
				System.out.println("------------------");
				
				
				String urlMail =  funciones.FuncionesNico.reemplazar(url, " ", "%20");
				
				System.out.println(urlMail);
				System.out.println("------------------");
				
				
				String textoParaElMail = funciones.FuncionesNico.mejorarElTextoParaElMail(textoOir);
				
				//solo para server brasilero
				textoParaElMail = Normalizer.normalize(textoParaElMail, Normalizer.Form.NFD);
		
				textoParaElMail = textoParaElMail.replace("á", "a");
				textoParaElMail = textoParaElMail.replace("é", "e");
				textoParaElMail = textoParaElMail.replace("í", "i");
				textoParaElMail = textoParaElMail.replace("ó", "o");
				textoParaElMail = textoParaElMail.replace("ú", "u");
				textoParaElMail = textoParaElMail.replace("Á", "A");
				textoParaElMail = textoParaElMail.replace("É", "E");
				textoParaElMail = textoParaElMail.replace("Í", "I");
				textoParaElMail = textoParaElMail.replace("Ó", "O");
				textoParaElMail = textoParaElMail.replace("Ú", "U");
				textoParaElMail = textoParaElMail.replace("ñ", "ni");
				
			
				
				
				
				System.out.println("----------------------" +textoParaElMail);
				
				//Fin solo brasil
			
				String rutaRelativaApp= getServletContext().getRealPath("/");
				System.out.println(rutaRelativaApp);
				
				
				//aca escribo el txt
				
				FileWriter fichero = null;
		        PrintWriter pw = null;
		        try
		        {
		            fichero = new FileWriter(rutaRelativaApp +"/texto.txt");
		            pw = new PrintWriter(fichero);

		        
		                pw.print(textoParaElMail);

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
				
		        
		        //Ahora adjunto la descarga
		        try
		        {
		            fichero = new FileWriter(rutaRelativaApp +"/descarga.txt");
		            pw = new PrintWriter(fichero);

		            
		                pw.print(urlMail);

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
		        
		        
		        
		      //Ahora adjunto el protocolo
		        try
		        {
		            fichero = new FileWriter(rutaRelativaApp +"/protocolo.txt");
		            pw = new PrintWriter(fichero);

		            
		                pw.print(protocolo);

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
				
				
				//Fin de la escritura
				
				
				
				
				
				
				DJCorreoTexto correoTexto = new DJCorreoTexto();
				correoTexto.mandarDCPorCorreo(enviarA, enviadoPor, asunto, urlMail, textoParaElMail, protocolo,rutaRelativaApp);
				
			
				
				//int idVersion = Integer.parseInt( request.getParameter("idVersion"));
				


				
				
				request.getRequestDispatcher("/inicioVisual.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}