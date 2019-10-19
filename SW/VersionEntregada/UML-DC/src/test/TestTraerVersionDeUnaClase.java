package test;

import datos.Clase;
import negocio.ClaseABM;

public class TestTraerVersionDeUnaClase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		int idClase = 14;
		
		ClaseABM cabm = new ClaseABM ();
		
		Clase clase = cabm.traerClase(idClase);
		
		int idVersion = clase.getVersion().getIdVersion();
		
		
		System.out.println(idVersion);

	}

}
