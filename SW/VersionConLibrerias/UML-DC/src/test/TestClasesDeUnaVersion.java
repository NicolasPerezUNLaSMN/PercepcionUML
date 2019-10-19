package test;

import datos.Clase;
import negocio.VersionABM;

public class TestClasesDeUnaVersion {
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		VersionABM versionabm = new VersionABM();
		
		for (Clase c: versionabm.traerVersionYListaClases(1).getListaClases()) {
			
			System.out.println(c.toString());
			
		}
		
		
	
	
	

}

	
}