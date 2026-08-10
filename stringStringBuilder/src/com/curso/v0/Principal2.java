package com.curso.v0;

public class Principal2 {
	
	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = new String("Hello");
		
		System.out.println(s1.equals(s2)); //true
		
		StringBuilder sb1 = new StringBuilder("Hola");
		StringBuilder sb2 = new StringBuilder("Hola");
		
		System.out.println(sb1.equals(sb2)); //false
	}

}
