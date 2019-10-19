package test;

import java.util.List;

import datos.DiagramaDeClase;
import negocio.DiagramaDeClaseABM;

public class TraerTodosLosDiagramas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		DiagramaDeClaseABM dabm = new DiagramaDeClaseABM ();
		
		List<DiagramaDeClase>  lista = dabm.traerDiagramaDeClase();
		
		
		System.out.println(lista.size());
		
		for (DiagramaDeClase c : lista) {
			
			System.out.println((c.toString()));
			
		}
		
		
		

	}

}
