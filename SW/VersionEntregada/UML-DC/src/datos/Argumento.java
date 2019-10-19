package datos;

public class Argumento {
	
	private int idArgumento;
	private String tipo;
	private String nombre;
	
	
	private Metodo metodo;
	
	
	public Argumento(String tipo, String nombre, Metodo metodo) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.metodo = metodo;
	}
	public Metodo getMetodo() {
		return metodo;
	}
	public void setMetodo(Metodo metodo) {
		this.metodo = metodo;
	}
	public int getIdArgumento() {
		return idArgumento;
	}
	protected void setIdArgumento(int idArgumento) {
		this.idArgumento = idArgumento;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Argumento(int idArgumento, String tipo, String nombre) {
		super();
		this.idArgumento = idArgumento;
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public Argumento(String tipo, String nombre) {
		super();
		
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public Argumento(){}
	
	
	@Override
	public String toString() {
		return "Argumento [idArgumento=" + idArgumento + ", tipo=" + tipo + ", nombre=" + nombre + "]";
	};
	
	
	
	
	
	

}
