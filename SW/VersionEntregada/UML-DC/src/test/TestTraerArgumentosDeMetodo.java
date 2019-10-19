package test;

import datos.Metodo;
import negocio.MetodoABM;

public class TestTraerArgumentosDeMetodo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		MetodoABM metodoabm = new MetodoABM();
		
		Metodo metodo = metodoabm.traerMetodoYListaArgumentos(5);

	}

}
