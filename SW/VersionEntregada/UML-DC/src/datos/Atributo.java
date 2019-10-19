package datos;

public class Atributo {
	
	private int idAtributo;
	private String privilegio;
	private String tipo;
	private String nombre;
	
	
	private Clase clase;
	
	
	public int getIdAtributo() {
		return idAtributo;
	}
	protected void setIdAtributo(int idAtributo) {
		this.idAtributo = idAtributo;
	}
	public String getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(String privilegio) {
		this.privilegio = privilegio;
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
	public Atributo(int idAtributo, String privilegio, String tipo, String nombre) {
		super();
		this.idAtributo = idAtributo;
		this.privilegio = privilegio;
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	
	
	
	public Atributo(String privilegio, String tipo, String nombre, Clase clase) {
		super();
		this.privilegio = privilegio;
		this.tipo = tipo;
		this.nombre = nombre;
		this.clase = clase;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public Atributo(){}
	@Override
	public String toString() {
		return "Atributo [idAtributo=" + idAtributo + ", privilegio=" + privilegio + ", tipo=" + tipo + ", nombre="
				+ nombre + "]";
	};
	
	
	
	
	
	
	

}
