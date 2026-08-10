package com.curso.v1;

class Pato{
	
	String nombre;

	@Override
	public int hashCode() {
		return 9999;
	}

	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
}

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("V1"); 

		Pato pato1 = new Pato();
		System.out.println(pato1); 
		
		Pato pato2 = new Pato();
		System.out.println(pato2);
		
	}

}
