package test;

import negocio.ClaseABM;
import negocio.MetodoABM;

public class TestAgregarMetodo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		MetodoABM mabm = new MetodoABM();
		ClaseABM cabm = new ClaseABM();
		
		
		mabm.agregar("public", "int", "calcularEdad", cabm.traerClase(1));
		mabm.agregar("public", "String", "darConsejo", cabm.traerClase(1));

	}

}
