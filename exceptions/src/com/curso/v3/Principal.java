package com.curso.v3;

class MyExceptionZero extends Exception {
	MyExceptionZero(String msg) {
		super(msg);
	}
}

class MyExceptionNegative extends Exception {
	MyExceptionNegative(String msg) {
		super(msg);
	}
}

public class Principal {
	
	public static void main(String[] args) {
	
		System.out.println("V3");
		int x = 2;
		int y = 2;
		int res = 0;
		
		try {
			res = dividir(x,y);
		} catch (MyExceptionZero | MyExceptionNegative | UnsupportedOperationException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Siempre pasa por finally");
		}
		
		System.out.println("Resultado: "+res);
		System.out.println("Fin de Programa");
	}

	private static int dividir(int x,int y) throws MyExceptionZero,MyExceptionNegative,UnsupportedOperationException {
		if (y==0)
			throw new MyExceptionZero("No puedo dividir entre 0");
		else if (y<0)
			throw new MyExceptionNegative("El divisor no puede ser negativo");
		else if (x>1000)
			throw new UnsupportedOperationException("El dividendo no puede ser mayor a 1000");
			
		return x/y; 
	}
	
}
