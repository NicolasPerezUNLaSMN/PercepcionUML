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



public class ControladorBorrarClase extends HttpServlet {
	
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
				
				
				
				int idClase = Integer.parseInt( request.getParameter("idClase"));
				
				
				VersionABM versionabm = new VersionABM();
				DiagramaDeClaseABM diagramaabm = new DiagramaDeClaseABM ();
				ClaseABM claseabm = new ClaseABM ();
				
				int idVersion = claseabm.traerClase(idClase).getVersion().getIdVersion();
				
			
				
				
				
				claseabm.eliminar(idClase);
				
				
				
		Version version  = versionabm.traerVersionYListaClases(idVersion);
		
		
		
		//agrego el texto para uml
		
		String texto = "\"";
		
		texto = texto +"title "  +version.getComentario() +" - Creada por: " +version.getQuien() +" - " +funciones.FuncionesNico.traerFechaCorta(version.getUltimaActualizacion()) +"\n";
	
		for (Clase c: version.getListaClases()) {
			
			texto = texto + c.armadoUML();
		}
		
		
		//veamos las relaciones
		for (Clase cRelaciones: version.getListaClases()) {
			
			
			Clase claseConRelaciones = claseabm.traerClaseYListaRelaciones(cRelaciones.getIdClase());
			
			
			texto = texto + claseConRelaciones.armandoRelaciones();
		}
		
		
		texto = texto +"\"";

				//request.setAttribute("version", version);
				//request.getRequestDispatcher("/verClases.jsp").forward(request , response);
		
		//Cosas nuevas :( 21-5
		//texto a oir
		//La version que graficaremos es la: 
		
		
		String textoOir = "";
		
		 textoOir = "Diagrama de clases, " +"creado por " +version.getQuien() +" el día " +funciones.FuncionesNico.traerFechaCorta(version.getUltimaActualizacion());
	
		 if(version.getListaClases().size()==0) {
			 textoOir = textoOir +"aún no ha comenzado a generarse";
		 }
		 
		 if(version.getListaClases().size()>0) {
			 textoOir = textoOir +" ésta compuesto por: ";
		 }
		 
		 
		for (Clase c: version.getListaClases()) {
			
			 textoOir =  textoOir + c.dictadoUML();
		}
		
		if(version.getListaClases().size()==0) {
			textoOir = textoOir;
		}
		
		if(version.getListaClases().size()>0) {
		 textoOir =  textoOir +"El Diagrama de clase posee las siguientes relaciones entre las clases: ";
		}
		
		
	
		
		//veamos las relaciones
		for (Clase cRelaciones: version.getListaClases()) {
			
			
			Clase claseConRelaciones = claseabm.traerClaseYListaRelaciones(cRelaciones.getIdClase());
			
			
			 textoOir =  textoOir + claseConRelaciones.dictadoRelaciones();
			 
			 
		}
		
		
		
	
		
		if(version.getListaClases().size()<=1) {
			 textoOir =  textoOir + "No hay relaciones en este diagrama";
		}
		
		
		
		int i = version.getDiagramaDeClase().getIdDiagramaDeClase();
		
		DiagramaDeClaseABM dabm = new DiagramaDeClaseABM();
		DiagramaDeClase d = dabm.traerDiagramaDeClaseYListaVersiones(i);
		
		
		System.out.println("LLLLLEEEGGGGUUUUEEEEEE");
		String emailCreador = d.getEmailCreador();  
		String contrasenia = d.getContrasenia();
		
		request.setAttribute("version", version);
		request.setAttribute("texto", texto);
		request.setAttribute("textoOir", textoOir);
		request.setAttribute("emailCreador", emailCreador);
		request.setAttribute("contrasenia", contrasenia);
		
		String textoParaDescargar = normalizeString(textoOir);
		request.setAttribute("textoParaDescargar", textoParaDescargar);
		
		
		System.out.print(version.toString());
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