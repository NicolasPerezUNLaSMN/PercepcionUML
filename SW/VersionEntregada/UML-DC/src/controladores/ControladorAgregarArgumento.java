package controladores;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DiagramaDeClase;
import datos.Metodo;
import datos.Version;
import negocio.ArgumentoABM;
import negocio.ClaseABM;
import negocio.DiagramaDeClaseABM;
import negocio.MetodoABM;
import negocio.VersionABM;



public class ControladorAgregarArgumento extends HttpServlet {
	
	
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
				
				
				String nombre = request.getParameter("nombre");
				String tipo = request.getParameter("tipo");
				int idMetodo = Integer.parseInt( request.getParameter("idMetodo"));
				
				nombre = nombre.replace(" ", "_");
				
				
				MetodoABM metodoabm= new MetodoABM();
				Metodo metodo = metodoabm.traerMetodoYListaArgumentos(idMetodo);
				
				
				
				ArgumentoABM argumentoabm = new ArgumentoABM();
				
				argumentoabm.agregar(tipo,nombre, metodo);
				
				
				Metodo metodoCompleta = metodoabm.traerMetodoYListaArgumentos(idMetodo);
		

				request.setAttribute("metodo", metodoCompleta);
				request.getRequestDispatcher("/verArgumentos.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}