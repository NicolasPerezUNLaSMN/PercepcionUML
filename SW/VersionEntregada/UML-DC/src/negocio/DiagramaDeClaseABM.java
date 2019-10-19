package negocio;


import java.util.List;	
import dao.DiagramaDeClaseDao;				
import datos.DiagramaDeClase;

public class DiagramaDeClaseABM {				
	DiagramaDeClaseDao dao=new DiagramaDeClaseDao();
	
	public DiagramaDeClase traerDiagramaDeClase(long idDiagramaDeClase) throws Exception{	
		DiagramaDeClase c= dao.traerDiagramaDeClase(idDiagramaDeClase); 
		if (c == null){
			throw new Exception ("DiagramaDeClase nulo");				
		}
		return c; 
		
		/*�Las excepciones no deben estar en DiagramaDeClaseDao como excepciones Hibernate? -> El acceso a los datos surge ah�. Hibernate deberia lanzar un error al no encontrar el id en la base de datos.
		 * Poner la excepcion ac� luego de traer el DiagramaDeClase asume que Hibernate puede traer un DiagramaDeClase = null cuando no encuentra un "id" en la base de datos.
		 */
	}
	
	public DiagramaDeClase traerDiagramaDeClase(String emailCreador, String contrasenia) throws Exception{
		DiagramaDeClase c= dao.traerDiagramaDeClase(emailCreador, contrasenia);  
		if (c == null){ 
			throw new Exception ("DiagramaDeClase nulo");			
		}
		return c;
	 
		//Misma opinion que en el metodo anterior. �El problema de DiagramaDeClase == null no deberia identificarse en la capa de acceso a datos? 
	} 
	
	public int agregar(String titulo, String emailCreador, String contrasenia) throws Exception { 
		
		//Consultar si existe un DiagramaDeClase con el mismo dni, si existe arrojar la Excepcion:
		
			DiagramaDeClase c;
			
			c= new DiagramaDeClase(titulo, emailCreador, contrasenia);
			return dao.agregar(c); 
			
			//A diferencia de los dos metodos anteriores, Hibernate en este caso podria NO ARROJAR una excepcion si el DNI se repitiese debido a que el DNI no es nuestra clave primaria. 
			//No hay una restriccion impuesta en la base de datos como sucede con el id. Aqui si necesitariamos declarar una excepcion. 
	} 
	
	
	public void modificar(DiagramaDeClase c) throws Exception {
		// Implementar antes de actualizar que no exista un DiagramaDeClase con el mismo documento a modificar y con el mismo id, lanzar la excepcion:
		
		DiagramaDeClase d = dao.traerDiagramaDeClase(c.getIdDiagramaDeClase());
		if (d != null){					
			if (d.getIdDiagramaDeClase() != c.getIdDiagramaDeClase()){ //Si son distintos id quiere decir que son distintos registros. Por ende, otro registro ya tiene ese DNI. Si son el mismo id, existe un registro con el mismo DNI pero es �l mismo. 
				throw new Exception ("Ya existe un DiagramaDeClase con este DNI");
			}
		}
		//Que podamos modificar un DNI es valido pero... �Por qu� preguntar si se va a repetir el ID? -> El id de un objeto no puede modificarse. Hay una restriccion.
		//Nunca tendria que poder llegar a modificarse desde memoria principal (desde la aplicacion). 
		dao.actualizar(c);
			
	}	
	
	public void eliminar(long idDiagramaDeClase) throws Exception {
		
		/* En este caso es una baja f�sica. En gral, no se se aplicar�a este caso de uso. 
		 * Si se hiciera, habr�a que validar que el DiagramaDeClase no tenga dependencias*/
		
		//Implementar que si es null arroje una excepcion 
		DiagramaDeClase c= dao.traerDiagramaDeClase(idDiagramaDeClase); 
		if (c == null){
			throw new Exception ("El DiagramaDeClase es nulo");		
		}
		
		
		dao.eliminar(c); 			
	}
	
	public List<DiagramaDeClase> traerDiagramaDeClase(){
		return dao.traerDiagramaDeClase(); 
	} 
	
	
	public DiagramaDeClase traerDiagramaDeClaseYListaVersiones(int idDiagramaDeClase) throws Exception{	
		DiagramaDeClase c = dao.traerDiagramaDeClaseYListaVersiones(idDiagramaDeClase);
																						  
		return c;															 
	}			
	
}
