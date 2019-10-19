package controladores;
import java.io.IOException;
import java.text.Normalizer;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Clase;
import datos.DiagramaDeClase;
import datos.Version;
import negocio.ClaseABM;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;



public class ControladorAgregarClase extends HttpServlet {
	
	
	public static String normalizeString(String str){
		 str=Normalizer.normalize(str,Normalizer.Form.NFKD);
		 return str.replaceAll("[^a-z,^A-Z,^0-9,^ ,^.,^/]", "");
		}
	
	
	
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
				int idVersion = Integer.parseInt( request.getParameter("idVersion"));
				
				
				nombre = nombre.replace(" ", "_");
				
				
				
				VersionABM versionabm= new VersionABM();
				Version version = versionabm.traerVersionYListaClases(idVersion);
				
				
				
				ClaseABM claseabm = new ClaseABM();
				
				claseabm.agregar(nombre,tipo, version);
				
				
				Version versionCompleta = versionabm.traerVersionYListaClases(idVersion);
				
				
				
		
				
				
				
				//agrego el texto para uml
				
				String texto = "\"";
				
				texto = texto +"title "  +versionCompleta.getComentario() +" - Creada por: " +versionCompleta.getQuien() +" - " +funciones.FuncionesNico.traerFechaCorta(versionCompleta.getUltimaActualizacion()) +"\n";
			
				for (Clase c: versionCompleta.getListaClases()) {
					
					texto = texto + c.armadoUML();
				}
				
				
				//veamos las relaciones
				for (Clase cRelaciones: versionCompleta.getListaClases()) {
					
					
					Clase claseConRelaciones = claseabm.traerClaseYListaRelaciones(cRelaciones.getIdClase());
					
					
					texto = texto + claseConRelaciones.armandoRelaciones();
				}
				
				
				texto = texto +"\"";
				
				
				
				
				//texto a oir
				//La version que graficaremos es la: 
				
				
				String textoOir = "";
				
				 textoOir = "Diagrama de clases, " +"creado por " +versionCompleta.getQuien() +" el día " +funciones.FuncionesNico.traerFechaCorta(version.getUltimaActualizacion());
			
				 if(versionCompleta.getListaClases().size()==0) {
					 textoOir = textoOir +"aún no ha comenzado a generarse";
				 }
				 
				 if(versionCompleta.getListaClases().size()>0) {
					 textoOir = textoOir +" ésta compuesto por: ";
				 }
				 
				 
				for (Clase c: versionCompleta.getListaClases()) {
					
					 textoOir =  textoOir + c.dictadoUML();
				}
				
				if(versionCompleta.getListaClases().size()==0) {
					textoOir = textoOir;
				}
				
				if(versionCompleta.getListaClases().size()>0) {
				 textoOir =  textoOir +"El Diagrama de clase posee las siguientes relaciones entre las clases: ";
				}
				
				
			
				
				//veamos las relaciones
				for (Clase cRelaciones: versionCompleta.getListaClases()) {
					
					
					Clase claseConRelaciones = claseabm.traerClaseYListaRelaciones(cRelaciones.getIdClase());
					
					
					 textoOir =  textoOir + claseConRelaciones.dictadoRelaciones();
					 
					 
				}
				
				
				
			
				
				if(versionCompleta.getListaClases().size()<=1) {
					 textoOir =  textoOir + "No hay relaciones en este diagrama";
				}
				
				
				
				int i = versionCompleta.getDiagramaDeClase().getIdDiagramaDeClase();
				
				DiagramaDeClaseABM dabm = new DiagramaDeClaseABM();
				DiagramaDeClase d = dabm.traerDiagramaDeClaseYListaVersiones(i);
				
				
				System.out.println("LLLLLEEEGGGGUUUUEEEEEE");
				String emailCreador = d.getEmailCreador();  
				String contrasenia = d.getContrasenia();
				
				request.setAttribute("version", versionCompleta);
				request.setAttribute("texto", texto);
				request.setAttribute("textoOir", textoOir);
				request.setAttribute("emailCreador", emailCreador);
				request.setAttribute("contrasenia", contrasenia);
				
				String textoParaDescargar = normalizeString(textoOir);
				request.setAttribute("textoParaDescargar", textoParaDescargar);
				
				
				System.out.print(versionCompleta.toString());
				System.out.print(texto);
				System.out.print(textoOir);
				System.out.print(emailCreador);
				System.out.print(contrasenia);
				System.out.print(textoParaDescargar);
				

				//request.setAttribute("version", versionCompleta);
				//request.setAttribute("texto", texto);
				request.getRequestDispatcher("/verClases.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}