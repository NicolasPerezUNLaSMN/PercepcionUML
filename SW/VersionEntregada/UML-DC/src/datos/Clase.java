package datos;

import java.util.Set;

import negocio.ClaseABM;
import negocio.MetodoABM;

public class Clase {

	
	private int idClase;
	private String nombre;
	private String tipo;
	



	Set<Atributo> listaAtributos;
	Set<Metodo> listaMetodos;
	Set<Relacion> listaRelaciones;
	
	
	private Version version;
	
	
	public Clase(String nombre, String tipo, Version version) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.version = version;
		
	}

	
	
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}


	
	public int getIdClase() {
		return idClase;
	}
	protected void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Set<Atributo> getListaAtributos() {
		return listaAtributos;
	}
	public void setListaAtributos(Set<Atributo> listaAtributos) {
		this.listaAtributos = listaAtributos;
	}
	public Set<Metodo> getListaMetodos() {
		return listaMetodos;
	}
	public void setListaMetodos(Set<Metodo> listaMetodos) {
		this.listaMetodos = listaMetodos;
	}
	public Set<Relacion> getListaRelaciones() {
		return listaRelaciones;
	}
	public void setListaRelaciones(Set<Relacion> listaRelaciones) {
		this.listaRelaciones = listaRelaciones;
	}
	public Clase(int idClase, String nombre, String tipo, Set<Atributo> listaAtributos, Set<Metodo> listaMetodos,
			Set<Relacion> listaRelaciones) {
		super();
		this.idClase = idClase;
		this.nombre = nombre;
		this.tipo = tipo;
		this.listaAtributos = listaAtributos;
		this.listaMetodos = listaMetodos;
		this.listaRelaciones = listaRelaciones;
	}
	
	public Clase(){}
	
	
	@Override
	public String toString() {
		return "Clase [idClase=" + idClase + ", nombre=" + nombre + ", tipo=" + tipo;
	};
	
	
	public String explicacionDeLaClase3 () {
		
		String texto ="";
		
		texto = "Clase " +tipo  +" cuyo nombre es " +nombre +" y sus atributos son:";
		
		for (Atributo a: listaAtributos) {
			String texto2 = " -Un atributo " +a.getPrivilegio() +" del tipo "+a.getTipo() +" con nombre " +a.getNombre() +" ";
			texto = texto + texto2;
		}
		
		texto = texto +"  Ademas esta compuesta por los metodos:";
		
		for (Metodo m:listaMetodos) {
			String texto3 = " -Un metodo " +m.getPrivilegio() +" con un retorno del tipo " +m.getRetorno() 
			+" cuyo nombre es " +m.getNombre() +" ,el mismo necesita de los argumentos:";
			
			for (Argumento arg: m.listaArgumentos) {
				String texto4 = " -un " +arg.getTipo() +" con nombre " +arg.getNombre() +" ";
				texto3 = texto3 + texto4;
			}
			texto = texto + texto3;
		}
		
		texto = texto +" Y tiene las siguientes relaciones:";
		
		for (Relacion r:listaRelaciones) {
			String texto5 = " -Esta relacionada con la clase " +r.getClase() +" por medio de una " +r.getTipoRelacion() +".";
			texto = texto + texto5;
		}
		
		
		return texto;
	}
	
	
	public String explicacionDeLaClase2 () {
		
		String texto ="Clase publica cuyo nombre es Estudiante y sus atributos son: -Un atributo privado del tipo int con nombre edad -Un atributo privado del tipo String con nombre nombre Ademas esta compuesta por los metodos: -Un metodo publico con un retorno del tipo boolean cuyo nombre es esMayorDeEdad ,el mismo necesita de los argumentos: -un int con nombre edad Y tiene las siguientes relaciones: -Esta relacionada con la clase Materia por medio de una Agregacion.";
		
		
		return texto;
	}
	
	
	
	public String explicacionDeLaClase () {
		
		String texto ="";
		
		texto = "Clase " +tipo  +" cuyo nombre es " +nombre +" y sus atributos son:\n";
		
		for (Atributo a: listaAtributos) {
			String texto2 = " -Un atributo " +a.getPrivilegio() +" del tipo "+a.getTipo() +" con nombre " +a.getNombre() +" \n";
			texto = texto + texto2;
		}
		
		texto = texto +"  \nAdemas esta compuesta por los metodos:\n";
		
		for (Metodo m:listaMetodos) {
			String texto3 = " -Un metodo " +m.getPrivilegio() +" con un retorno del tipo " +m.getRetorno() 
			+" cuyo nombre es " +m.getNombre() +" ,el mismo necesita de los argumentos:\n";
			
			for (Argumento arg: m.listaArgumentos) {
				String texto4 = " -un " +arg.getTipo() +" con nombre " +arg.getNombre() +" \n";
				texto3 = texto3 + texto4;
			}
			texto = texto + texto3;
		}
		
		texto = texto +" \nY tiene las siguientes relaciones:\n";
		
		for (Relacion r:listaRelaciones) {
			String texto5 = " -Esta relacionada con la clase " +r.getClase() +" por medio de una " +r.getTipoRelacion() +".";
			texto = texto + texto5;
		}
		
		
		return texto;
	}



	public Clase(int idClase, String nombre, String tipo, Set<Atributo> listaAtributos, Set<Metodo> listaMetodos,
			Set<Relacion> listaRelaciones, Version version) {
		super();
		this.idClase = idClase;
		this.nombre = nombre;
		this.tipo = tipo;
		this.listaAtributos = listaAtributos;
		this.listaMetodos = listaMetodos;
		this.listaRelaciones = listaRelaciones;
		this.version = version;
	}
	
	public Clase(String nombre, String tipo, Set<Atributo> listaAtributos, Set<Metodo> listaMetodos,
			Set<Relacion> listaRelaciones, Version version) {
		super();
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.listaAtributos = listaAtributos;
		this.listaMetodos = listaMetodos;
		this.listaRelaciones = listaRelaciones;
		this.version = version;
	}
	
	
	public Clase(String nombre, String tipo, Set<Atributo> listaAtributos,  Version version) {
		super();
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.listaAtributos = listaAtributos;

		this.version = version;
	}
	
	
	
	public String armadoUML() throws Exception {
		
		String armado ="";
		
		if (tipo.equals("Publica") || tipo.equals("Privada")){
			
			armado = "Class " +nombre +" {\n";
		}
		
		
		
		if (tipo.equals("Interface")){
			
			armado = "interface " +nombre +" {\n";
		}
		
		
		
		if (tipo.equals("Enum")){
			
			armado = "enum " +nombre +" {\n";
		}
		
		
		if (tipo.equals("Abstracta")){
			
			armado = "abstract class " +nombre +" {\n";
		}
		
		
		
		armado = armado + "\n";
		/////////////////////////////
		
		//Traigo los atributos
		
		ClaseABM claseabm = new ClaseABM();
		Clase claseConAtributos = claseabm.traerClaseYListaAtributos(idClase);
		
		
		for (Atributo atributo: claseConAtributos.getListaAtributos()) {
			
			String valor = "";
			
			if (atributo.getPrivilegio().equals("Publica")) {
				valor = "+";
			}
			
			if (atributo.getPrivilegio().equals("Privada")) {
				valor = "-";
			}
			
			if (atributo.getPrivilegio().equals("Protected")) {
				valor = "#";
			}
			
			if (atributo.getPrivilegio().equals("Estatico")) {
				valor = "{static}";
			}
			
			if (atributo.getPrivilegio().equals("Sin Definir")) {
				valor = " ";
			}
			
			
			armado = armado +valor +atributo.getTipo() +" "  +atributo.getNombre() +"\n";
			
			
			
			
		}//Cierro lista de atributos
		
		
		
		armado = armado + "__\n";
		
		
		
		//////////////////////
		
		
		
		///////////////VAMOS CON LOS METODOS//////////////
		
		
		
		Clase claseConMetodos = claseabm.traerClaseYListaMetodos(idClase);
		
		
		for (Metodo metodo : claseConMetodos.getListaMetodos()) {
			boolean primerArgumento = true;
			
			String valor = "";
			
			if (metodo.getPrivilegio().equals("Publica")) {
				valor = "+";
			}
			
			if (metodo.getPrivilegio().equals("Privada")) {
				valor = "-";
			}
			
			if (metodo.getPrivilegio().equals("Protected")) {
				valor = "#";
			}
			
			if (metodo.getPrivilegio().equals("Sin Definir")) {
				valor = " ";
			}
			
			
			armado = armado +valor +metodo.getNombre()  +" ( ";
			
			MetodoABM metodoabm = new MetodoABM();
			Metodo metodoConArgumentos = metodoabm.traerMetodoYListaArgumentos(metodo.getIdMetodo());
			
			for (Argumento argumento: metodoConArgumentos.listaArgumentos) {
				
				if (!primerArgumento) {
					armado = armado +", " + argumento.getTipo() +" " +argumento.getNombre() +" ";
					}
				
				
				if (primerArgumento) {
				armado = armado + argumento.getTipo() +" " +argumento.getNombre() +" ";
				primerArgumento = false;}
				
				
				
				
			}//Cierro argumento
			
			armado =armado +") :" +metodo.getRetorno() +"\n";
			
			
		} //cierro el metodo
		
		
		
		
		/////////////////////////////////////////////////////
		
		
		//cierro la clase
		armado = armado +" }\n";
		
		
		return armado;
	}
	
	
	public String dictadoRelaciones() {
		String texto = "";
		
		
		
		if (listaRelaciones.size()>0) {//abre el if
		
		for (Relacion relacion:listaRelaciones) {
			
			String inicio ="";
			String fin ="";
			
			if(relacion.getInicioRelacion().contains("0..1")) {
				inicio = "cero a uno";
			}
			
			if(relacion.getInicioRelacion().contains("0..*")) {
				inicio = "cero a muchos";
			}
			
			if(relacion.getInicioRelacion().contains("1..*")) {
				inicio = "1 a muchos";
			}
			
			
			if(relacion.getFinRelacion().contains("0..1")) {
				fin = "cero a uno";
			}
			
			if(relacion.getFinRelacion().contains("0..*")) {
				fin = "cero a muchos";
			}
			
			if(relacion.getFinRelacion().contains("1..*")) {
				fin = "1 a muchos";
			}
			
			
			
			String tipo = "";
			
			if (relacion.getTipoRelacion().equals("Agregacion")) {
				tipo = "agregación";
			}
			
			if (relacion.getTipoRelacion().equals("Composicion")) {
				tipo = "composición";
			}
			
			if (relacion.getTipoRelacion().equals("Hereda de")) {
				tipo = "herencia";
			}
			
			if (relacion.getTipoRelacion().equals("Hereda a")) {
				tipo = "herencia";
			}
			
			if (relacion.getTipoRelacion().equals("Dependencia")) {
				tipo = "dependencia";
			}
			
			if (relacion.getTipoRelacion().equals("Implementacion")) {
				tipo = "implementación";
			}
			
			texto = texto +"La clase " +relacion.getClaseInicial().nombre +" " +" con una relación de " +tipo +" con la clase " +relacion.getClase() +".";
			
			
			if(relacion.getInicioRelacion().contains(".")&&relacion.getFinRelacion().contains(".")) {
				texto = texto +"Además esta relación va desde " +inicio  +" hasta " +fin +".";
			}
			
			
		}//Cierra el HAY RELACION
		
		}//cierra el if
		else texto = texto +"La clase " +nombre +" no tiene relaciones a nombrar.";
		
		
		
		return texto;
	}
	
	
	
	
public String dictadoUML() throws Exception {
		
		String armado ="";
		
		if (tipo.equals("Publica")){
			
			armado = "Clase pública denominada " +nombre +", " ;
		}
		
		if (tipo.equals("Privada")){
			
			armado = "Clase privada denominada " +nombre  +", ";
		}
		
		
		
		if (tipo.equals("Interface")){
			
			armado = "Interface denominada " +nombre +", " ;
		}
		
		
		
		if (tipo.equals("Enum")){
			
			armado = "Enum denominado " +nombre  +", ";
		}
		
		
		if (tipo.equals("Abstracta")){
			
			armado = "Clase abstracta denominada " +nombre +", " ;
		}
		
		
		/////////////////////////////
		
		//Traigo los atributos
		
		ClaseABM claseabm = new ClaseABM();
		Clase claseConAtributos = claseabm.traerClaseYListaAtributos(idClase);
		
		
		String agregar = "sin Atributos definidos.";
		
		if (claseConAtributos.getListaAtributos().size()>0) {
		agregar = "donde sus atributos son: ";}
		
		armado = armado +agregar;
		
		for (Atributo atributo: claseConAtributos.getListaAtributos()) {
			
			String valor = "";
			
			if (atributo.getPrivilegio().equals("Publica")) {
				valor = "publico";
			}
			
			if (atributo.getPrivilegio().equals("Privada")) {
				valor = "privado";
			}
			
			if (atributo.getPrivilegio().equals("Protected")) {
				valor = "protegido";
			}
			
			if (atributo.getPrivilegio().equals("Estatico")) {
				valor = "estático";
			}
			
			if (atributo.getPrivilegio().equals("Sin Definir")) {
				valor = "sin definir";
			}
			
			
			armado = armado +"Un atributo "+valor +" del tipo " +atributo.getTipo() +" " +" denominado " +atributo.getNombre() +".";
			
			
			
			
		}//Cierro lista de atributos
		
		
		
		
		
		
		//////////////////////
		
		
		
		///////////////VAMOS CON LOS METODOS//////////////
		
		
		String agregoMetodo = "Sin métodos definidos.";
		
		
		Clase claseConMetodos = claseabm.traerClaseYListaMetodos(idClase);
		
		if (claseConMetodos.getListaMetodos().size()>0) {
			agregoMetodo = "Donde sus métodos son: ";
		}
		
		
		for (Metodo metodo : claseConMetodos.getListaMetodos()) {
			boolean primerArgumento = true;
			
			String valor = "";
			
			if (metodo.getPrivilegio().equals("Publica")) {
				valor = "publico";
			}
			
			if (metodo.getPrivilegio().equals("Privada")) {
				valor = "privado";
			}
			
			if (metodo.getPrivilegio().equals("Protected")) {
				valor = "protegido";
			}
			
			if (metodo.getPrivilegio().equals("Sin Definir")) {
				valor = "sin definir";
			}
			
			
			armado = armado +" un método " +valor +" con nombre " +metodo.getNombre() +".";
			
			MetodoABM metodoabm = new MetodoABM();
			Metodo metodoConArgumentos = metodoabm.traerMetodoYListaArgumentos(metodo.getIdMetodo());
			
			String agregarArgumento = " Sin argumentos.";
			
			if (metodoConArgumentos.getListaArgumentos().size()>=1) {
				agregarArgumento = " Con los argumentos: ";
			}
			
			for (Argumento argumento: metodoConArgumentos.listaArgumentos) {
				
				
				armado = armado +" Con un argumento del tipo "+ argumento.getTipo() +" con nombre " +argumento.getNombre() +". ";
				
				
				
				
				
				
			}//Cierro argumento
			
			armado =armado +", este método retorna un " +metodo.getRetorno() +".";
			
			
		} //cierro el metodo
		
		
		
		
		/////////////////////////////////////////////////////
		
		
		
		
		
		return armado;
	}



public String armandoRelaciones() {
	String texto = "\n";
	
	
	for (Relacion relacion:listaRelaciones) {
		
		String tipo = "";
		
		if (relacion.getTipoRelacion().equals("Agregacion")) {
			tipo = "o--";
		}
		
		if (relacion.getTipoRelacion().equals("Composicion")) {
			tipo = "*--";
		}
		
		if (relacion.getTipoRelacion().equals("Hereda a")) {
			tipo = "<|--";
		}
		
		if (relacion.getTipoRelacion().equals("Hereda de")) {
			tipo = "--|>";
		}
		
		if (relacion.getTipoRelacion().equals("Dependencia")) {
			tipo = "-->";
		}
		
		if (relacion.getTipoRelacion().equals("Implementacion")) {
			tipo = "..>";
		}
		
		
		if(relacion.getInicioRelacion().contains(".") && relacion.getFinRelacion().contains(".")) {
		texto = texto +relacion.getClaseInicial().nombre +" " +"&quot;" +relacion.getInicioRelacion() +"&quot;" +" " +tipo +" " +"&quot;" +relacion.getFinRelacion() +"&quot;" +" " +relacion.getClase() +"\n";
		}//Cierro el if
		
		
		if((!relacion.getInicioRelacion().contains(".")) || (!relacion.getFinRelacion().contains("."))) {
			texto = texto +relacion.getClaseInicial().nombre +" "  +tipo +" "   +relacion.getClase() +"\n";
			}//Cierro el if
		
		
		
		
	}
	
	
	
	return texto;
}

	

	
	
	
	
}
