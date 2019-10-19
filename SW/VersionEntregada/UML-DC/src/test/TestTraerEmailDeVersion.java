package test;

import datos.DiagramaDeClase;
import datos.Version;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;

public class TestTraerEmailDeVersion {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		VersionABM v = new VersionABM(); 
		Version version = v.traerVersion(1);
		
		int i = version.getDiagramaDeClase().getIdDiagramaDeClase();
		
		DiagramaDeClaseABM dabm = new DiagramaDeClaseABM();
		DiagramaDeClase d = dabm.traerDiagramaDeClaseYListaVersiones(i);
		
							
		String emailCreador = d.getEmailCreador(); 	
		String contrasenia = d.getContrasenia(); 
		
		System.out.println(emailCreador); 

	}

}
