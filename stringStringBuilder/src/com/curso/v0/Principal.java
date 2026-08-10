package com.curso.v0;

public class Principal {
	
	public static void main(String[] args) {
		
		String cadena = "Patrobas";
		
		for (int x=0;x<1_000_000;x++) {
			cadena += x;
			System.out.println(cadena);
		}
		
		System.out.println("End Program");
		
		
	}

}
