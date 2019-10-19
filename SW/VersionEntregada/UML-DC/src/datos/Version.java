package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.FuncionesNico;


public class Version {
	
	private int idVersion;
	private GregorianCalendar ultimaActualizacion;
	private String comentario;
	private String quien;
	
	private Set<Clase> listaClases;
	private DiagramaDeClase diagramaDeClase;
	
	
	
	
	public Version( GregorianCalendar ultimaActualizacion, String comentario, String quien, DiagramaDeClase diagramaDeClase) {
		super();
		
		this.ultimaActualizacion = ultimaActualizacion;
		this.comentario = comentario;
		this.quien = quien;
		
		this.diagramaDeClase = diagramaDeClase;
	}


	public DiagramaDeClase getDiagramaDeClase() {
		return diagramaDeClase;
	}


	public void setDiagramaDeClase(DiagramaDeClase diagramaDeClase) {
		this.diagramaDeClase = diagramaDeClase;
	}


	public String getQuien() {
		return quien;
	}


	public void setQuien(String quien) {
		this.quien = quien;
	}

	
	
	
	public Version() {}


	public int getIdVersion() {
		return idVersion;
	}


	protected void setIdVersion(int idVersion) {
		this.idVersion = idVersion;
	}


	public GregorianCalendar getUltimaActualizacion() {
		return ultimaActualizacion;
	}


	public void setUltimaActualizacion(GregorianCalendar ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Set<Clase> getListaClases() {
		return listaClases;
	}


	public void setListaClases(Set<Clase> listaClases) {
		this.listaClases = listaClases;
	}


	public Version(int idVersion, GregorianCalendar ultimaActualizacion, String comentario, Set<Clase> listaClases) {
		super();
		this.idVersion = idVersion;
		this.ultimaActualizacion = ultimaActualizacion;
		this.comentario = comentario;
		this.listaClases = listaClases;
	}

	
	public Version(GregorianCalendar ultimaActualizacion, String comentario, String quien) {
		super();
		
		this.ultimaActualizacion = ultimaActualizacion;
		this.comentario = comentario;
		this.quien = quien;
		
	}

	@Override
	public String toString() {
		return "Version [idVersion=" +idVersion + ", ultimaActualizacion=" + FuncionesNico.traerFechaCortaParaHibernateConHora(ultimaActualizacion) + ", comentario="
				+ comentario ;
	}


	public Version(int idVersion, GregorianCalendar ultimaActualizacion, String comentario, String quien,
			Set<Clase> listaClases, DiagramaDeClase diagramaDeClase) {
		super();
		this.idVersion = idVersion;
		this.ultimaActualizacion = ultimaActualizacion;
		this.comentario = comentario;
		this.quien = quien;
		this.listaClases = listaClases;
		this.diagramaDeClase = diagramaDeClase;
	};
	
	
	
	

	

}
