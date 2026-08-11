package com.curso.v0;

public class Principal {

	public static void main(String[] args) {

		int x = 10;
		String cadena = "Hello";
		StringBuilder sb = new StringBuilder("Hola");

		cadena = transforma(x,cadena,sb);

		System.out.println(x); //10
		System.out.println(cadena); //Hello World
		System.out.println(sb); //Hola Mundo

	}

	private static String transforma(int x, String cadena, StringBuilder sb) {

		x = x +10;
		sb.append(" Mundo");

//		System.out.println(cadena); //Hello
//		System.out.println(sb); //Hola Mundo

		return cadena.concat(" World");

	}

}
