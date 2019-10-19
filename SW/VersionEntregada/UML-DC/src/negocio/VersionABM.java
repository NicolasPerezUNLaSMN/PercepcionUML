package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.VersionDao;
import datos.DiagramaDeClase;
import datos.Version;

public class VersionABM {				
	VersionDao dao=new VersionDao();
	
	public Version traerVersion(int idVersion) throws Exception{	
		Version c= dao.traerVersion(idVersion); 
		if (c == null){
			throw new Exception ("Version nulo");				
		}
		return c; 
		
		/*¿Las excepciones no deben estar en VersionDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Version asume que Hibernate puede traer un Version = null cuando no encuentra un "id" en la base de datos.
		 */
	}
	
	public Version traerVersion(String emailCreador, String contrasenia) throws Exception{
		Version c= dao.traerVersion(emailCreador, contrasenia);  
		if (c == null){ 
			throw new Exception ("Version nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Version == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(GregorianCalendar ultimaActualizacion, String comentario, String quien, DiagramaDeClase d) throws Exception { 
		
		//Consultar si existe un Version con el mismo dni, si existe arrojar la Excepcion:
		
			Version c;
			
			c= new Version(ultimaActualizacion,comentario, quien,d);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Version c) throws Exception {
		// Implementar antes de actualizar que no exista un Version con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Version d = dao.traerVersion(c.getIdVersion());
		if (d != null){					
			if (d.getIdVersion() != c.getIdVersion()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Version con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(int idVersion) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el Version no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Version c= dao.traerVersion(idVersion); 
		if (c == null){
			throw new Exception ("El Version es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	
	
	
	public List<Version> traerVersion(){
		return dao.traerVersion(); 
	} 
	
	
	public Version traerVersionYListaClases(int idVersion) throws Exception{	
		
		
		Version c = dao.traerVersionYListaClases(idVersion);
		
		/*
		if (c.getListaClases().isEmpty()) {	
			throw new Exception ("Este no hay clases asignadas"); 
		}	 */																				  
		return c;															 
	}	
	
	
		
	
}
