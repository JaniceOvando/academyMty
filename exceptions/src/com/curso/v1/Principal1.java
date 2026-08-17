package com.curso.v1;

public class Principal1 {

	public static void main(String[] args) {

		int x = 9;
		int y = 0;
		
		int res = 0;
		
		try {
			res = dividir(x,y);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Resultado: "+res);
		
		System.out.println("Fin de Programa");
	}

	private static int dividir(int x,int y) throws Exception {
		
		if (y==0)
			throw new Exception("No puedo dividir entre 0");
		
		return x/y; 
	}
	
}
