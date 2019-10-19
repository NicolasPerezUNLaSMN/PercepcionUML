package test;

import datos.Clase;
import negocio.ClaseABM;
import negocio.RelacionABM;

public class TestAgregarRelacion {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		RelacionABM rabm = new RelacionABM ();
		ClaseABM cabm = new ClaseABM ();
		
		Clase c = cabm.traerClase(1);
		
		rabm.agregar("Extension", "Empleado", "1", "many",c);
		

	}

}
