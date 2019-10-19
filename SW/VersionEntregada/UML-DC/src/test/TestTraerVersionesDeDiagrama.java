package test;

import datos.Clase;
import datos.Version;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;

public class TestTraerVersionesDeDiagrama {

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		DiagramaDeClaseABM dcabm = new DiagramaDeClaseABM();
		VersionABM vabm = new VersionABM();
		
		int idABuscar = dcabm.traerDiagramaDeClase("nico_feo", "wouuu").getIdDiagramaDeClase();
		
		for (Version version: dcabm.traerDiagramaDeClaseYListaVersiones(idABuscar).getListaVersiones()) {
			
			
			int idVersion =  version.getIdVersion();
			
			
			
			System.out.println(vabm.traerVersionYListaClases(idVersion).getListaClases());
				
				
			
				
			} //Cierra lista de clases
			
			
			
			System.out.println("--------------------FIN VERSION----------------");
			
		}//cierra lista de versiones
			
		
		
		
		
		
		
		
	}
	
