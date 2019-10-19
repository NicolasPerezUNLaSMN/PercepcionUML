package test;

import java.util.GregorianCalendar;

import datos.Clase;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;

public class TestAgregarVersion {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		VersionABM vabm = new VersionABM();
		DiagramaDeClaseABM dabm = new DiagramaDeClaseABM ();
		
		GregorianCalendar fechaHoy = new GregorianCalendar();
		
		
		//vabm.agregar(fechaHoy, "Segundoo comentario", "Nykolai",dabm.traerDiagramaDeClase("nico_FEO", "wouuu"));
		
		int id = 1;
		System.out.println(vabm.traerVersion(id).toString());
		
		
		for (Clase c: vabm.traerVersionYListaClases(id).getListaClases()) {
			System.out.println(c.toString());
		}
		
		
		

	}

}
