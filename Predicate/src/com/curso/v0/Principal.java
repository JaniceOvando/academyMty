package com.curso.v0;

interface Predicado<T>{
	
	boolean probar(T t);
	
}


public class Principal {

	public static void main(String[] args) {
		
		
		
	}
	
	int getPrimitivo() {
		return 0;
	}
	
	String getObject() {
		return "cadena";
	}
	
	Predicado<String> getFunction() {
		return x -> true;
	}
	
}
