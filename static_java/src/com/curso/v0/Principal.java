package com.curso.v0;

public class Principal {

	public static void main(String[] args) {

		String cadena = "Hola";
		
		new Principal().transforma(cadena);
		
	}
	
	//metodo de instancia
	void transforma(String cadena) {
		System.out.println(cadena);
	}

}
