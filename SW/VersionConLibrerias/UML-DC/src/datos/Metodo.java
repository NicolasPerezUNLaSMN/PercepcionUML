package datos;

import java.util.Set;

public class Metodo {
	
	
	private int idMetodo;
	private String privilegio;
	private String retorno;
	private String nombre;
	
	
	private Clase clase;
	Set<Argumento> listaArgumentos;
	
	

	public int getIdMetodo() {
		return idMetodo;
	}

	protected void setIdMetodo(int idMetodo) {
		this.idMetodo = idMetodo;
	}

	public String getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Argumento> getListaArgumentos() {
		return listaArgumentos;
	}

	public void setListaArgumentos(Set<Argumento> listaArgumentos) {
		this.listaArgumentos = listaArgumentos;
	}

	public Metodo(int idMetodo, String privilegio, String retorno, String nombre, Set<Argumento> listaArgumentos) {
		super();
		this.idMetodo = idMetodo;
		this.privilegio = privilegio;
		this.retorno = retorno;
		this.nombre = nombre;
		this.listaArgumentos = listaArgumentos;
	}
	
	
	
	
	
	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}
	
	
	

	public Metodo(int idMetodo, String privilegio, String retorno, String nombre, Clase clase,
			Set<Argumento> listaArgumentos) {
		super();
		this.idMetodo = idMetodo;
		this.privilegio = privilegio;
		this.retorno = retorno;
		this.nombre = nombre;
		this.clase = clase;
		this.listaArgumentos = listaArgumentos;
	}
	
	

	public Metodo(String privilegio, String retorno, String nombre, Clase clase) {
		super();
		
		this.privilegio = privilegio;
		this.retorno = retorno;
		this.nombre = nombre;
		this.clase = clase;
		
	}

	public Metodo(){};
	
	
	
	
	

}
