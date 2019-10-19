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



public class ControladorBorrarArgumento extends HttpServlet {
	
	
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
				
				
				
				int idArgumento = Integer.parseInt( request.getParameter("idArgumento"));
				
				System.out.println("-----ARGUMENTO A BORRAR-----");
				
				System.out.println(idArgumento);
				
				
				
				ArgumentoABM argumentoabm = new ArgumentoABM();
				MetodoABM metodoabm = new MetodoABM();
				
				int idMetodo = argumentoabm.traerArgumento(idArgumento).getMetodo().getIdMetodo();
				
				System.out.println("-----Metodo traido-----");
				System.out.println(idMetodo);
				
			
				
				
				
				argumentoabm.eliminar(idArgumento);
				
				System.out.println("-----Se elimino el argumento-----");
				
				
				
		Metodo metodo  = metodoabm.traerMetodoYListaArgumentos(idMetodo);

				request.setAttribute("metodo", metodo);
				request.getRequestDispatcher("/verArgumentos.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}