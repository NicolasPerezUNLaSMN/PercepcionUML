package test;


import java.util.Set;

import datos.Relacion;
import negocio.ClaseABM;

public class TestTraerClaseYRelaciones {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		ClaseABM claseabm = new ClaseABM();
		
		
		
			
	Set<Relacion> lista = claseabm.traerClaseYListaRelaciones(1).getListaRelaciones();
	
	for (Relacion r:lista) {
		System.out.println(r.getTipoRelacion());
	}
		
		

	}

}
