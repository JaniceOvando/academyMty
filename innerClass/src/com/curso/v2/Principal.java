package com.curso.v2;

public class Principal {
	
	private String cadena = "Patrobas";

	public static void main(String[] args) {

		// Local Class
		class Estudiante {
			String nombre;
		}

		Estudiante e = new Estudiante();
		
		//System.out.println();
		
		new Principal().method1();

	}

	void method1() {
		// Local Class
		class Estudiante {
			String nombre = cadena;
		}

		Estudiante e = new Estudiante();
		
		System.out.println("Estudiante.nombre :"+e.nombre); //Hola
	}

}
