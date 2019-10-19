package controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import funciones.FuncionesNico;



public class ControladorProcesarTexto extends HttpServlet {
	

	
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
				
				
			
			String textoAProcesar = request.getParameter("textoAProcesar");
			
			textoAProcesar = FuncionesNico.agregoComillasInicioYFinUMLPlantText(textoAProcesar);
			
			
			
		  
		
		   	request.setAttribute("textoAProcesar", textoAProcesar);
			
			
		 	System.out.println(textoAProcesar);
		 	
		 	String textoAProcesarSinComillas = textoAProcesar.replace("\"", "");
		 	
		 	
		 	request.setAttribute("textoAProcesarSinComillas", textoAProcesarSinComillas);
			request.getRequestDispatcher("/verDiagramaConProtocolo.jsp").forward(request , response);
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}




			
	
	
	

}









