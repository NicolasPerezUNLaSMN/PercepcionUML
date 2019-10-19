package controladores;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DiagramaDeClase;
import negocio.DiagramaDeClaseABM;



public class ControladorVerVersiones extends HttpServlet {
	
	
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
			String contrasenia = request.getParameter("contrasenia");
			
			
			System.out.println("--------------" +emailCreador +contrasenia);
			
			
			int id = diagramaabm.traerDiagramaDeClase(emailCreador, contrasenia).getIdDiagramaDeClase();
			
			DiagramaDeClase diagrama = diagramaabm.traerDiagramaDeClaseYListaVersiones(id);
			
			
			
			System.out.println(diagrama.toString());
		
		
		
		   	
			request.setAttribute("diagrama", diagrama);
			request.setAttribute("contrasenia", contrasenia);
			request.setAttribute("emailCreador", emailCreador);
			request.getRequestDispatcher("/verVersiones.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}