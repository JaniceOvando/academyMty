package com.curso.v0;

public class Principal {
	
	public static void main(String[] args) {
		
		System.out.println("***** PRIMITIVOS *****");
		final int x = 10;
		
		//x += 10;
		
		System.out.println(x);
		
		System.out.println("***** MUTABLE *****");
		final StringBuilder sb = new StringBuilder("Hello");
		
		sb.append("World");
		
		//sb = sb.append("World");
		//sb = new StringBuilder("Hola");
		//sb = null;
		
		System.out.println(sb);
		
		System.out.println("***** INMUTABLE *****");
		
		final String s = "Hola";
		
		s.concat("Mundo");
		
		//s = null;
		
		System.out.println(s);
		
		
		
	}

}
