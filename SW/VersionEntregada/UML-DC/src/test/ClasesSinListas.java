package test;

import java.util.Set;

import datos.Atributo;
import datos.Clase;
import negocio.ClaseABM;

public class ClasesSinListas {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		ClaseABM claseabm = new ClaseABM();
		
		
		Clase clase = claseabm.traerClase(2);
		
		System.out.println(clase.toString());
		
		
		Clase claseConAtributos = claseabm.traerClaseYListaAtributos(2);
		
		Set<Atributo> atributos = null;
		
		if(!claseConAtributos.getListaAtributos().isEmpty()) {
			atributos = claseConAtributos.getListaAtributos();
		}
		
		boolean vacio = false;
		boolean nulo = false;
		
		
		
		
		if (!atributos.isEmpty()) {
			nulo = false;
		}
		
		
		System.out.println(vacio);
		System.out.println(nulo);
		

	}

}
