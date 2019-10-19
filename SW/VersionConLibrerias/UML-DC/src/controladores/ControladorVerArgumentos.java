package controladores;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Clase;
import datos.DiagramaDeClase;
import datos.Metodo;
import datos.Version;
import negocio.ArgumentoABM;
import negocio.ClaseABM;
import negocio.DiagramaDeClaseABM;
import negocio.MetodoABM;
import negocio.VersionABM;



public class ControladorVerArgumentos extends HttpServlet {
	
	
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
				
				
				int idMetodo=Integer.parseInt(request.getParameter("idMetodo"));
				
				System.out.println("Metodo a ver argumentos");
				System.out.println(idMetodo);
				
				MetodoABM metodoabm = new MetodoABM();
				
				
				
				Metodo metodo = metodoabm.traerMetodoYListaArgumentos(idMetodo);
				
				System.out.println("Se instancio el metodo");
				
				
				boolean vacia = false;
				boolean nula = false;
				
				if (metodo.getListaArgumentos().isEmpty()) {
					vacia=true;
				}
				
				if(metodo.getListaArgumentos()==null) {
					nula = true;
				}
				
				System.out.println(metodo.toString());
				System.out.println(vacia);
				System.out.println(nula);
				
				
		
				
		
				request.setAttribute("metodo", metodo);
			request.getRequestDispatcher("/verArgumentos.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}