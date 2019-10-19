package test;

import datos.Clase;
import datos.Version;
import negocio.ClaseABM;
import negocio.DiagramaDeClaseABM;
import negocio.VersionABM;

public class TestEscribirUML {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		//Vamos a graficar solo una version
		VersionABM versionabm = new VersionABM();
		DiagramaDeClaseABM diagramaabm = new DiagramaDeClaseABM();
		
		
		//La version que graficaremos es la: 
		Version version = versionabm.traerVersionYListaClases(1);
		
		String texto = " ";
		
		texto = "Diagrama de clases, " +"creado por " +version.getQuien() +" el dia " +funciones.FuncionesNico.traerFechaCorta(version.getUltimaActualizacion()) +" esta compuesto por: \n\\n\\n";
	
		for (Clase c: version.getListaClases()) {
			
			texto = texto + c.dictadoUML();
			
		}
		
		
		texto = texto +"El Diagrama de clase posee las siguientes relaciones entre las clases: \n\n";
		
		//veamos las relaciones
		for (Clase cRelaciones: version.getListaClases()) {
			
			ClaseABM claseabm = new ClaseABM();
			Clase claseConRelaciones = claseabm.traerClaseYListaRelaciones(cRelaciones.getIdClase());
			
			
			texto = texto + claseConRelaciones.dictadoRelaciones();
		}
		
		
		//texto = texto +"\n@enduml";
		
		
		System.out.println(texto);
		
		

	}

}
