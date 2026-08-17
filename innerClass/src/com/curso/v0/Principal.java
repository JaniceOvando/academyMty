package com.curso.v0;


public class Principal {
	
	private String cadena;
	
	//Instance Inner Class
	class Estudiante{
		String nombre = cadena;
	}
	
	public static void main(String[] args) {
		
		Estudiante e1 = new Principal().new Estudiante(); 
		
	}
	
}
