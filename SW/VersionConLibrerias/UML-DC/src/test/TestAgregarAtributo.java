package test;

import datos.Clase;
import negocio.AtributoABM;
import negocio.ClaseABM;

public class TestAgregarAtributo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		AtributoABM aabm = new AtributoABM();
		ClaseABM cabm = new ClaseABM();
		
		
		Clase c = cabm.traerClase(1);
		
		aabm.agregar("private", "String", "nombre", c);
		aabm.agregar("private", "String", "apellido", c);
		aabm.agregar("private", "float", "DNI", c);
		

	}

}
