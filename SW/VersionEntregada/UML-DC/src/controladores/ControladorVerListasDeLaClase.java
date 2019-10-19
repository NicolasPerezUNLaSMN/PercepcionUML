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



public class ControladorVerListasDeLaClase extends HttpServlet {
	
	
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
				
				
				int idClase=Integer.parseInt(request.getParameter("idClase"));
				
				VersionABM versionabm = new VersionABM();
				ClaseABM claseabm = new ClaseABM();
				AtributoABM atributoabm = new AtributoABM();
				MetodoABM metodoabm = new MetodoABM();
				RelacionABM relacionabm = new RelacionABM();
				
			

					
				Clase claseConAtributos =  claseabm.traerClaseYListaAtributos(idClase);
				Clase claseConMetodos = claseabm.traerClaseYListaMetodos(idClase);
				Clase claseConRelaciones =  claseabm.traerClaseYListaRelaciones(idClase);
				
				System.out.println("Ha traido bien las listas vacias");
					
				Set<Atributo> atributos = null;
				Set<Metodo> metodos = null;
				Set<Relacion> relaciones = null;
				
					
					if(!claseConAtributos.getListaAtributos().isEmpty()) {
				atributos = claseConAtributos.getListaAtributos();}
					
					if(!claseConMetodos.getListaMetodos().isEmpty()) {
				metodos = claseConMetodos.getListaMetodos();}
					
					
					if(!claseConRelaciones.getListaRelaciones().isEmpty()) {
						relaciones = claseConRelaciones.getListaRelaciones();}
				
					
					
					
				
				
				
		
				request.setAttribute("idClase", idClase);
				request.setAttribute("metodos", metodos);
				request.setAttribute("atributos", atributos);
				request.setAttribute("relaciones", relaciones);
			request.getRequestDispatcher("/verListasDeLaClase.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}