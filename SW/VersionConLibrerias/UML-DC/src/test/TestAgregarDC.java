package test;

import dao.DiagramaDeClaseDao;
import datos.DiagramaDeClase;
import datos.Version;
import negocio.DiagramaDeClaseABM;

public class TestAgregarDC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		DiagramaDeClaseABM dabm = new DiagramaDeClaseABM();
		
		//dabm.agregar("Tercero", "nico_wi", "wouuu");
		
		
		System.out.println("El id del dc es: --->" +dabm.traerDiagramaDeClase("nico_FEO", "wouuu").getIdDiagramaDeClase());
		
		
		for (Version v : dabm.traerDiagramaDeClaseYListaVersiones(2).getListaVersiones()) {
			System.out.println(v.toString());
		}

	}

}
