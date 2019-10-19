package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.RelacionDao;
import datos.Clase;
import datos.DiagramaDeClase;
import datos.Relacion;

public class RelacionABM {				
	RelacionDao dao=new RelacionDao();
	
	public Relacion traerRelacion(int idRelacion) throws Exception{	
		Relacion c= dao.traerRelacion(idRelacion); 
		if (c == null){
			throw new Exception ("Relacion nulo");				
		}
		return c; 
		
		/*¿Las excepciones no deben estar en RelacionDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Relacion asume que Hibernate puede traer un Relacion = null cuando no encuentra un "id" en la base de datos.
		 */
	}
	
	public Relacion traerRelacion(String emailCreador, String contrasenia) throws Exception{
		Relacion c= dao.traerRelacion(emailCreador, contrasenia);  
		if (c == null){ 
			throw new Exception ("Relacion nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Relacion == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar( String tipoRelacion, String clase, String inicioRelacion, String finRelacion, Clase claseInicial) throws Exception { 
		
		//Consultar si existe un Relacion con el mismo dni, si existe arrojar la Excepcion:
		
			Relacion c;
			
			c= new Relacion(tipoRelacion, clase, inicioRelacion, finRelacion ,claseInicial);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Relacion c) throws Exception {
		// Implementar antes de actualizar que no exista un Relacion con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Relacion d = dao.traerRelacion(c.getIdRelacion());
		if (d != null){					
			if (d.getIdRelacion() != c.getIdRelacion()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Relacion con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(int idRelacion) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el Relacion no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Relacion c= dao.traerRelacion(idRelacion); 
		if (c == null){
			throw new Exception ("El Relacion es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	public List<Relacion> traerRelacion(){
		return dao.traerRelacion(); 
	} 
	
	

	
		
	
}
