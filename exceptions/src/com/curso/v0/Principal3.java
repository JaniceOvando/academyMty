package com.curso.v0;

public class Principal3 {
	
	public static void main(String[] args) {
		
		System.out.println("Principal3");
		
		String nombre = "Filologo";
		
		try {
			System.out.println(nombre.charAt(7));
			nombre = null;
			System.out.println(nombre.length());
		}
		catch(RuntimeException e) {
			System.out.println(e);
		}
		
		System.out.println("Fin de programa");
	}

}
