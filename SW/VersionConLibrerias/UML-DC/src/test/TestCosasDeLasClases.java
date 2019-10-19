package test;

import negocio.ClaseABM;

public class TestCosasDeLasClases {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		
		ClaseABM claseabm = new ClaseABM();
		
		
	
			
			int cantiAtributos = 0, cantiRelaciones= 0 , cantiMetodos= 0;
			
			
		
		
			
			if(!claseabm.traerClaseYListaAtributos(3).getListaAtributos().isEmpty() || claseabm.traerClaseYListaAtributos(3).getListaAtributos().equals(null)) {
		cantiAtributos = claseabm.traerClaseYListaAtributos(3).getListaAtributos().size();}
			
			System.out.println("-----------" +cantiAtributos  +"---" +cantiRelaciones +"-----" +cantiMetodos);
			
			if(!claseabm.traerClaseYListaRelaciones(3).getListaRelaciones().isEmpty() || claseabm.traerClaseYListaRelaciones(3).getListaRelaciones().equals(null)) {
		cantiRelaciones = claseabm.traerClaseYListaRelaciones(3).getListaRelaciones().size();}
			
			System.out.println("-----------" +cantiAtributos  +"---" +cantiRelaciones +"-----" +cantiMetodos);
			
			if(!claseabm.traerClaseYListaMetodos(3).getListaMetodos().isEmpty() || claseabm.traerClaseYListaMetodos(3).getListaMetodos().equals(null)){
		cantiMetodos = claseabm.traerClaseYListaMetodos(3).getListaMetodos().size();}
			
			System.out.println("-----------" +cantiAtributos  +"---" +cantiRelaciones +"-----" +cantiMetodos);
			
			
		
		
		
		
		
		

	}

}
