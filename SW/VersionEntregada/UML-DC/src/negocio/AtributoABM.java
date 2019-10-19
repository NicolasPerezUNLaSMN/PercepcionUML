package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.AtributoDao;
import datos.DiagramaDeClase;
import datos.Atributo;
import datos.Clase;

public class AtributoABM {				
	AtributoDao dao=new AtributoDao();
	
	public Atributo traerAtributo(int idAtributo) throws Exception{	
		Atributo c= dao.traerAtributo(idAtributo); 
		if (c == null){
			throw new Exception ("Atributo nulo");				
		}
		return c; 
		
		/*¿Las excepciones no deben estar en AtributoDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Atributo asume que Hibernate puede traer un Atributo = null cuando no encuentra un "id" en la base de datos.
		 */
	}
	
	public Atributo traerAtributo(String emailCreador, String contrasenia) throws Exception{
		Atributo c= dao.traerAtributo(emailCreador, contrasenia);  
		if (c == null){ 
			throw new Exception ("Atributo nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Atributo == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(String privilegio, String tipo, String nombre, Clase cl) throws Exception { 
		
		//Consultar si existe un Atributo con el mismo dni, si existe arrojar la Excepcion:
		
			Atributo c;
			
			c= new Atributo(privilegio, tipo, nombre,cl);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Atributo c) throws Exception {
		// Implementar antes de actualizar que no exista un Atributo con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Atributo d = dao.traerAtributo(c.getIdAtributo());
		if (d != null){					
			if (d.getIdAtributo() != c.getIdAtributo()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Atributo con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(int idAtributo) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el Atributo no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Atributo c= dao.traerAtributo(idAtributo); 
		if (c == null){
			throw new Exception ("El Atributo es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	public List<Atributo> traerAtributo(){
		return dao.traerAtributo(); 
	} 
	
	

	
		
	
}
