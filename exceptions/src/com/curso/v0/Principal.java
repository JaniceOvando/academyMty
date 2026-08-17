package com.curso.v0;

public class Principal {

	public static void main(String[] args) {

		int x = 9;
		int y = 0;
		
		int res = 0;
		
		res = dividir(x,y);
		
		System.out.println("Resultado: "+res);
		
		System.out.println("Fin de Programa");
	}

	private static int dividir(int x,int y) {
		return x/y; // RuntimeException
	}

}
