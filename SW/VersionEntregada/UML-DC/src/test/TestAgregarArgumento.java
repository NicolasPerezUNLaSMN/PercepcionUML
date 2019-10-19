package test;

import dao.DiagramaDeClaseDao;
import datos.DiagramaDeClase;
import negocio.ArgumentoABM;
import negocio.DiagramaDeClaseABM;
import negocio.MetodoABM;

public class TestAgregarArgumento {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		ArgumentoABM argumentoabm = new ArgumentoABM();
		MetodoABM mabm = new MetodoABM();
		
		mabm.traerMetodo(1);
		
		argumentoabm.agregar("String", "nombre",mabm.traerMetodo(1));
		argumentoabm.agregar("String", "apellido",mabm.traerMetodo(1));
		argumentoabm.agregar("Long", "DNI",mabm.traerMetodo(1));
		

	}

}
