package negocio;

import java.util.GregorianCalendar;
import java.util.List;	
import dao.MetodoDao;
import datos.Clase;
import datos.DiagramaDeClase;
import datos.Metodo;

public class MetodoABM {				
	MetodoDao dao=new MetodoDao();
	
	public Metodo traerMetodo(int idMetodo) throws Exception{	
		Metodo c= dao.traerMetodo(idMetodo); 
		if (c == null){
			throw new Exception ("Metodo nulo");				
		}
		return c; 
		
		/*¿Las excepciones no deben estar en MetodoDao como excepciones Hibernate? -> El acceso a los datos surge ahí. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion acá luego de traer el Metodo asume que Hibernate puede traer un Metodo = null cuando no encuentra un "id" en la base de datos.
		 */
	}
	
	public Metodo traerMetodo(String emailCreador, String contrasenia) throws Exception{
		Metodo c= dao.traerMetodo(emailCreador, contrasenia);  
		if (c == null){ 
			throw new Exception ("Metodo nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. ¿El problema de Metodo == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(String privilegio, String retorno, String nombre, Clase c) throws Exception { 
		
		//Consultar si existe un Metodo con el mismo dni, si existe arrojar la Excepcion:
		
			Metodo cnueva;
			
			cnueva= new Metodo(privilegio, retorno, nombre,c);
			return dao.agregar(cnueva); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(Metodo c) throws Exception {
		// Implementar antes de actualizar que no exista un Metodo con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		Metodo d = dao.traerMetodo(c.getIdMetodo());
		if (d != null){					
			if (d.getIdMetodo() != c.getIdMetodo()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es él mismo. 
				throw new Exception ("Ya existe un Metodo con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... ¿Por qué preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(int idMetodo) throws Exception {
		
		/* En este caso es una baja física. En gral, no se se aplicaría este caso de uso. 
		 * Si se hiciera, habría que validar que el Metodo no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		Metodo c= dao.traerMetodo(idMetodo); 
		if (c == null){
			throw new Exception ("El Metodo es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	public List<Metodo> traerMetodo(){
		return dao.traerMetodo(); 
	} 
	
	
	public Metodo traerMetodoYListaArgumentos(int idDiagramaDeClase) throws Exception{	
		Metodo c = dao.traerMetodoYListaArgumentos(idDiagramaDeClase);
		/*if (c.getListaArgumentos().isEmpty()) {	
			throw new Exception ("Este DiagramaDeClase no tiene ListaMetodoes"); 
		}	*/																				  
		return c;															 
	}	
	
	
		
	
}
