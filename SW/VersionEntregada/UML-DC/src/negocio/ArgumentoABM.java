package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.ArgumentoDao;				
import datos.Argumento;
import datos.Metodo;

public class ArgumentoABM {				
	ArgumentoDao dao=new ArgumentoDao();
	

	
	public Argumento traerArgumento(int dni) throws Exception{
		Argumento c= dao.traerArgumento(dni);  
		if (c == null){ 
			throw new Exception ("Argumento nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Argumento == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(String tipo, String nombre, Metodo m) throws Exception { 
		
		//Consultar si existe un Argumento con el mismo dni, si existe arrojar la Excepcion:
		
			Argumento c;
			
			c= new Argumento(tipo, nombre,m);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Argumento c) throws Exception {
		// Implementar antes de actualizar que no exista un Argumento con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Argumento d = dao.traerArgumento(c.getIdArgumento());
		if (d != null){					
			if (d.getIdArgumento() != c.getIdArgumento()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Argumento con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(int idArgumento) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el Argumento no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Argumento c= dao.traerArgumento(idArgumento); 
		if (c == null){
			throw new Exception ("El Argumento es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	public List<Argumento> traerArgumento(){
		return dao.traerArgumento(); 
	} 
	
	
		
	
}
