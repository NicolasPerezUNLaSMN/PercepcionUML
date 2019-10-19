package controladores;
import java.io.IOException;
import java.text.Normalizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Clase;

import datos.Version;
import negocio.ClaseABM;

import negocio.VersionABM;



public class ControladorVerClases extends HttpServlet {
	
	
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
				
				
				int idVersion=Integer.parseInt(request.getParameter("idVersion"));
				String emailCreador = request.getParameter("emailCreador");
				String contrasenia = request.getParameter("contrasenia");
				
				VersionABM versionabm = new VersionABM();
				ClaseABM claseabm = new ClaseABM();
				
				
				Version version = versionabm.traerVersionYListaClases(idVersion);
				

				int cantiAtributos = 0;
				int cantiRelaciones= 0;
				int cantiMetodos= 0;
				
				
				for (Clase claseParcial: version.getListaClases()) {


					int idClase = claseParcial.getIdClase();
					
					
					Clase claseConAtributos =  claseabm.traerClaseYListaAtributos(idClase);
					Clase claseConMetodos = claseabm.traerClaseYListaMetodos(idClase);
					Clase claseConRelaciones =  claseabm.traerClaseYListaRelaciones(idClase);
					
					
				
					
					if(!claseConAtributos.getListaAtributos().isEmpty()) {
				cantiAtributos = claseConAtributos.getListaAtributos().size();}
					
					//System.out.println("-----------" +cantiAtributos  +"---" +cantiRelaciones +"-----" +cantiMetodos);
					
					if(!claseConRelaciones.getListaRelaciones().isEmpty()) {
				cantiRelaciones = claseConRelaciones.getListaRelaciones().size();}
					
					//System.out.println("-----------" +cantiAtributos  +"---" +cantiRelaciones +"-----" +cantiMetodos);
					
					if(!claseConMetodos.getListaMetodos().isEmpty()){
				cantiMetodos = claseConMetodos.getListaMetodos().size();}
					
					//System.out.println("-----------" +cantiAtributos  +"---" +cantiRelaciones +"-----" +cantiMetodos);
					

				
				}
				
				
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
				
				
				
				//texto a oir
				//La version que graficaremos es la: 
				
				
				String textoOir = "";
				
				 textoOir = "Diagrama de clases, " +"creado por " +version.getQuien() +" el día " +funciones.FuncionesNico.traerFechaCorta(version.getUltimaActualizacion());
			
				 if(version.getListaClases().size()==0) {
					 textoOir = textoOir +", aún no ha comenzado a generarse, por lo que";
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
				
				
				System.out.println(version.getListaClases().size());
			
				
				if(version.getListaClases().size()<=1) {
					 textoOir =  textoOir + " no hay relaciones en este diagrama.";
				}
				
				
				//Creo el protocolo
				System.out.println("--------------------------");
				System.out.println(texto);
				
				
				//Creo el procolo para enviar por mail. 
				String protocolo = texto;
				
				System.out.println("Arranco el protocolo----------------------------");
				System.out.println("Arranco el protocolo----------------------------");
				System.out.println("Arranco el protocolo----------------------------");
				
				
				//Reemplazar Titulo por title
				protocolo = protocolo.replace("title","Titulo");
				
				//Reemplazar Abstracta
				protocolo = protocolo.replace("abstract class","ClaseAbstracta");
				protocolo = protocolo.replace("interface","Interface");
				
				//Reemplazar classe por class
				protocolo = protocolo.replace("Class","Clase" );
				
				protocolo = protocolo.replace("<|--", "HeredaA");
				protocolo = protocolo.replace("--|>", "HeredaDe");
				
				//Reemplazar Composicion
				protocolo = protocolo.replace("--*","ComposicionHacia");
				protocolo = protocolo.replace("*--","ComposicionDesde");
				
				//Reemplazar Composicion
				protocolo = protocolo.replace("--o","AgregacionHacia");
				protocolo = protocolo.replace("o--", "AgregacionDesde");
				
				//Reemplazar Composicion
				protocolo = protocolo.replace("..>", "Implementa");
				protocolo = protocolo.replace("-->", "Implementa");
				
			
				
				//Cardinalidad
				protocolo = protocolo.replace("&quot;1..*&quot;", "UnoAMuchos");
				protocolo = protocolo.replace("&quot;0..*&quot;", "CeroAMuchos");
				protocolo = protocolo.replace("&quot;0,1&quot;", "CeroAUno");
				protocolo = protocolo.replace("&quot;0..1&quot;", "CeroAUno");
				
				protocolo = protocolo.replace("\"", "");
				protocolo = protocolo.replace("__", "");
				
				
				
				
				
				System.out.println("-------------------------------");
				System.out.println("-------------------------------");
				System.out.println("-------------------------------");
				System.out.println("-------------------------------");
				System.out.println(protocolo);
				
				
				
				
				
				
				
				
				//Request para el html
				
				
				request.setAttribute("version", version);
				request.setAttribute("texto", texto);
				request.setAttribute("textoOir", textoOir);
				request.setAttribute("emailCreador", emailCreador);
				request.setAttribute("contrasenia", contrasenia);
				request.setAttribute("protocolo", protocolo);
				
				
				
				String textoParaDescargar = normalizeString(textoOir);
				request.setAttribute("textoParaDescargar", textoParaDescargar);
				
				
				
			request.getRequestDispatcher("/verClases.jsp").forward(request , response);
			
			
			} catch (
			Exception e) {
				
			request.getRequestDispatcher("/inicioVisualError.jsp").forward(request , response);
			//response.sendError(500, "Los datos son erroneos.");
			}
			}
			
	
	
	

}