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



public class ControladorBorrarVersion extends HttpServlet {
	
	
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
				
				
				
				int idVersion = Integer.parseInt( request.getParameter("idVersion"));
				
				
				VersionABM versionabm = new VersionABM();
				DiagramaDeClaseABM diagramaabm = new DiagramaDeClaseABM ();
				
				
				int idDiagrama = versionabm.traerVersion(idVersion).getDiagramaDeClase().getIdDiagramaDeClase();
				
				System.out.println(idDiagrama);
				
				
				
				versionabm.eliminar(idVersion);
				
				
				
		DiagramaDeClase diagrama = diagramaabm.traerDiagramaDeClaseYListaVersiones(idDiagrama);

				request.setAttribute("diagrama", diagrama);
				request.getRequestDispatcher("/verVersiones.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}