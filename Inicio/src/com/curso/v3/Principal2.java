package com.curso.v3;

public class Principal2 {

	public static void main(String[] args) {

		String cadena = "Hello";
		cadena  = cadena.concat("World");
		
		System.out.println(cadena);
		
		System.out.println("*********");
		
		Object cadena2 = "Hola";
		
		cadena2 = ((String)cadena2).concat("Mundo");
		
		System.out.println(cadena2);
		
		
		
	}

}
