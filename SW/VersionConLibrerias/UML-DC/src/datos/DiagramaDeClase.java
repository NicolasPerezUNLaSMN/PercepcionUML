package datos;

import java.util.Set;

public class DiagramaDeClase {
	
	
	private int idDiagramaDeClase;
	private String titulo;
	private String emailCreador;
	private String contrasenia;
	
	private Set<Version> listaVersiones;

	
	
	

	public int getIdDiagramaDeClase() {
		return idDiagramaDeClase;
	}


	protected void setIdDiagramaDeClase(int idDiagramaDeClase) {
		this.idDiagramaDeClase = idDiagramaDeClase;
	}


	public String getEmailCreador() {
		return emailCreador;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTitulo() {
		return titulo;
	}



	public void setEmailCreador(String emailCreador) {
		this.emailCreador = emailCreador;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	

	
	public DiagramaDeClase(){}


	public DiagramaDeClase(int idDiagramaDeClase, String titulo, String emailCreador, String contrasenia,
			Set<Clase> listaClases) {
		super();
		this.idDiagramaDeClase = idDiagramaDeClase;
		this.titulo = titulo;
		this.emailCreador = emailCreador;
		this.contrasenia = contrasenia;
		
	}

	
	
	
	public Set<Version> getListaVersiones() {
		return listaVersiones;
	}


	public void setListaVersiones(Set<Version> listaVersiones) {
		this.listaVersiones = listaVersiones;
	}


	public DiagramaDeClase(String titulo, String emailCreador, String contrasenia) {
		super();
		//this.idDiagramaDeClase = idDiagramaDeClase;
		this.titulo = titulo;
		this.emailCreador = emailCreador;
		this.contrasenia = contrasenia;
		
	}

	@Override
	public String toString() {
		return "DiagramaDeClase [idDiagramaDeClase=" + idDiagramaDeClase + ", titulo=" + titulo + ", emailCreador="
				+ emailCreador + ", contrasenia=" + contrasenia  ;
	};

	
	


	
	
	
	
	
	
	
	
	
	

}
