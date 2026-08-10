package com.curso.v0;

public class Principal1 {
	
	public static void main(String[] args) {
		
		String cadena = "Patrobas";
		
		StringBuilder sb = new StringBuilder(cadena);
		
		for (int x=0;x<1_000_000;x++) {
			sb.append(x);
			System.out.println(sb);
		}
		
		cadena = sb.toString();
		
		System.out.println("End Program");
		
		
	}

}
