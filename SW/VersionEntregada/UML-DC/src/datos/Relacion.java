package datos;

public class Relacion {
	
	private int idRelacion;
	private String tipoRelacion;
	private String clase;
	private String inicioRelacion;
	private String finRelacion;
	
	
	private Clase claseInicial;
	
	
	public int getIdRelacion() {
		return idRelacion;
	}
	protected void setIdRelacion(int idRelacion) {
		this.idRelacion = idRelacion;
	}
	public String getTipoRelacion() {
		return tipoRelacion;
	}
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public Relacion(int idRelacion, String tipoRelacion, String clase) {
		super();
		this.idRelacion = idRelacion;
		this.tipoRelacion = tipoRelacion;
		this.clase = clase;
	}
	
	public Relacion(){}
	
	
	
	
	
	public Clase getClaseInicial() {
		return claseInicial;
	}
	public void setClaseInicial(Clase claseInicial) {
		this.claseInicial = claseInicial;
	}
	
	
	public Relacion(int idRelacion, String tipoRelacion, String clase, Clase claseInicial) {
		super();
		this.idRelacion = idRelacion;
		this.tipoRelacion = tipoRelacion;
		this.clase = clase;
		this.claseInicial = claseInicial;
	}
	
	public Relacion(String tipoRelacion, String clase, Clase claseInicial) {
		super();
		
		this.tipoRelacion = tipoRelacion;
		this.clase = clase;
		this.claseInicial = claseInicial;
	}
	
	
	@Override
	public String toString() {
		return "Relacion [idRelacion=" + idRelacion + ", tipoRelacion=" + tipoRelacion + ", clase=" + clase + "]";
	}
	public String getInicioRelacion() {
		return inicioRelacion;
	}
	public void setInicioRelacion(String inicioRelacion) {
		this.inicioRelacion = inicioRelacion;
	}
	public String getFinRelacion() {
		return finRelacion;
	}
	public void setFinRelacion(String finRelacion) {
		this.finRelacion = finRelacion;
	}
	public Relacion(String tipoRelacion, String clase, String inicioRelacion, String finRelacion, Clase claseInicial) {
		super();
		this.tipoRelacion = tipoRelacion;
		this.clase = clase;
		this.inicioRelacion = inicioRelacion;
		this.finRelacion = finRelacion;
		this.claseInicial = claseInicial;
	};
	
	
	
	
	
	

}
