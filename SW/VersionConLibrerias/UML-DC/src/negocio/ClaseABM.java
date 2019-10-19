package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.ClaseDao;
import datos.DiagramaDeClase;
import datos.Version;
import datos.Clase;
import datos.Clase;
import datos.Clase;

public class ClaseABM {				
	ClaseDao dao=new ClaseDao();
	
	
	
	public Clase traerClase(int idClase) throws Exception{	
		Clase c= dao.traerClase(idClase); 
		if (c == null){
			throw new Exception ("Clase nulo");				
		}
		return c; 
		
		/*¿Las excepciones no deben estar en ClaseDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Clase asume que Hibernate puede traer un Clase = null cuando no encuentra un "id" en la base de datos.
		 */
	}
		
		/*¿Las excepciones no deben estar en ClaseDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Clase asume que Hibernate puede traer un Clase = null cuando no encuentra un "id" en la base de datos.
		 */
	
	
	public Clase traerClase(String nombre, int  idClase) throws Exception{
		Clase c= dao.traerClase(nombre, idClase);  
		if (c == null){ 
			throw new Exception ("Clase nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Clase == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(String nombre, String tipo, Version v) throws Exception { 
		
		//Consultar si existe un Clase con el mismo dni, si existe arrojar la Excepcion:
		
			Clase c;
			
			c= new Clase(nombre,tipo, v);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Clase c) throws Exception {
		// Implementar antes de actualizar que no exista un Clase con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Clase d = dao.traerClase(c.getIdClase());
		if (d != null){					
			if (d.getIdClase() != c.getIdClase()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Clase con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(int idClase) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el Clase no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Clase c= dao.traerClase(idClase); 
		if (c == null){
			throw new Exception ("El Clase es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	public List<Clase> traerClase(){
		return dao.traerClase(); 
	} 
	
	
	public Clase traerClaseYListaAtributos(int idClase) throws Exception{	
		Clase c = dao.traerClaseYListaAtributos(idClase);
		
		/*
		if (c.getListaAtributos().isEmpty()) {	
			throw new Exception ("Este Clase no tiene ListaAtributos"); 
		}			*/																		  
		return c;															 
	}	
	
	
	public Clase traerClaseYListaRelaciones(int idClase) throws Exception{	
		Clase c = dao.traerClaseYListaRelaciones(idClase);
		
		/*
		if (c.getListaAtributos().isEmpty()) {	
			throw new Exception ("Este Clase no tiene ListaAtributos"); 
		}			*/																		  
		return c;															 
	}	
	
	
	public Clase traerClaseYListaMetodos(int idClase) throws Exception{	
		Clase c = dao.traerClaseYListaMetodos(idClase);
		
		/*
		if (c.getListaAtributos().isEmpty()) {	
			throw new Exception ("Este Clase no tiene ListaAtributos"); 
		}			*/																		  
		return c;															 
	}	
	
	
	
	
		
	
}
