package controladores;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Atributo;
import datos.Clase;
import datos.Metodo;
import datos.Relacion;
import negocio.AtributoABM;
import negocio.ClaseABM;
import negocio.MetodoABM;
import negocio.RelacionABM;
import negocio.VersionABM;

public class ControladorEnviarMailImagen extends HttpServlet {
	
	
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
				

				String link =request.getParameter("link");
				
				
				System.out.println(link);
				
				System.out.println("lllllllllllllllll");
				
				
				request.setAttribute("link", link);
		
			request.getRequestDispatcher("/envioImagen.jsp").forward(request , response);
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}


