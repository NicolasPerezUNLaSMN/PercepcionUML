package controladores;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DiagramaDeClase;
import datos.Version;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;



public class ControladorAgregarVersion extends HttpServlet {
	
	
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
				
				
				String comentario = request.getParameter("comentario");
				String quien = request.getParameter("quien");
				int idDiagrama = Integer.parseInt( request.getParameter("idDiagrama"));
				
				
				DiagramaDeClaseABM d = new DiagramaDeClaseABM();
				DiagramaDeClase diagrama = d.traerDiagramaDeClaseYListaVersiones(idDiagrama);
				
				
				
				VersionABM versionabm = new VersionABM();
				
				versionabm.agregar(new GregorianCalendar(), comentario, quien, diagrama);
				
				
				DiagramaDeClase diagramaCompleto = d.traerDiagramaDeClaseYListaVersiones(idDiagrama);
		

				request.setAttribute("diagrama", diagramaCompleto);
				request.getRequestDispatcher("/verVersiones.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}