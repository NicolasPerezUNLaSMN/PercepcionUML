package test;

import datos.Atributo;
import negocio.ClaseABM;
import negocio.VersionABM;

public class TestAgregarClase {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		ClaseABM cabm = new ClaseABM();
		VersionABM vabm = new VersionABM();
		
		//cabm.agregar("Persona", "Publica", vabm.traerVersion(1));
		//cabm.agregar("Contacto", "Publica", vabm.traerVersion(1));
		
		
	for (Atributo atri: cabm.traerClaseYListaAtributos(1).getListaAtributos()) {
		System.out.println(atri.toString());
	}
		
		
		
		

	}

}
