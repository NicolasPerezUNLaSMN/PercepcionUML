package test;

import java.util.HashSet;
import java.util.Set;

import datos.Argumento;
import datos.Atributo;
import datos.Clase;
import datos.DiagramaDeClase;
import datos.Metodo;
import datos.Relacion;

public class PrimerDiagrama {
	
		
		
	
	
	public Clase instanciarClase() {
		//Creo el primer diagrama
		//instancio a la lista de clases
		Set<Clase> listaDeClases = new HashSet<Clase>();
		DiagramaDeClase dC = new DiagramaDeClase(1, "Primer test", "nico_perez_velez@hotmail.com", "kdfjlka", listaDeClases);
		
		
		//Creo las clases que necesito
		//Listas que voy a necesitar
		Set<Atributo> listaDeAtributos = new HashSet<Atributo>();
		Set<Metodo> listaDeMetodos = new HashSet<Metodo>();
		Set<Relacion> listaDeRelaciones = new HashSet<Relacion>();
		Set<Argumento> listaDeArgumentos = new HashSet<Argumento>();
		
		//Instancio los dos atributos
		Atributo a1 = new Atributo (1, "privado", "int","edad");
		Atributo a2 = new Atributo (2, "privado", "String","nombre");
		listaDeAtributos.add(a1);
		listaDeAtributos.add(a2);
		
		//Genero el metodo
		Argumento argumento = new Argumento (1,"int", "edad");
		listaDeArgumentos.add(argumento);
		Metodo m1 = new Metodo (1,"publico", "boolean", "esMayorDeEdad", listaDeArgumentos);
		listaDeMetodos.add(m1);
		
		//Genero la relacion
		Relacion r1 = new Relacion(1,"Agregacion", "Materia");
		listaDeRelaciones.add(r1);
		
		//Instancio al estudiante
		Clase estudiante = new Clase(1, "Estudiante", "publica", listaDeAtributos, listaDeMetodos, listaDeRelaciones);
		
		
		return estudiante;
	} //Cierro el metodo

}