package com.curso.v1;

public class Principal {

	public static void main(String[] args) throws Exception {

		int x = 9;
		int y = 0;
		
		int res = 0;
		
		res = dividir(x,y);
		
		System.out.println("Resultado: "+res);
		
		System.out.println("Fin de Programa");
	}

	private static int dividir(int x,int y) throws Exception {
		
		if (y==0)
			throw new Exception("No puedo dividir entre 0");
		
		return x/y; 
	}
	
}
