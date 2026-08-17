package com.curso.v1;

class MyExceptionZero extends Exception {
	MyExceptionZero(String msg) {
		super(msg);
	}
}

public class Principal2 {

	public static void main(String[] args) {

		int x = 9;
		int y = 0;

		int res = 0;

		try {
			res = dividir(x, y);
		} catch (MyExceptionZero e) {
			e.printStackTrace();
		}

		System.out.println("Resultado: " + res);

		System.out.println("Fin de Programa");
	}

	private static int dividir(int x, int y) throws MyExceptionZero {

		if (y == 0)
			throw new MyExceptionZero("No puedo dividir entre 0");

		return x / y;
	}

}
