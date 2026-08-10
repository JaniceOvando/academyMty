package com.curso.v1;

class Pato extends Object{
	String nombre;
	
	Pato(String nombre){
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		Pato other = (Pato) obj;
		return this.nombre == other.nombre;
	}
	
}
public class Principal {

	public static void main(String[] args) {
		
		Pato pato1 = new Pato("Donald");
		Pato pato2 = new Pato("Donald");
		
		System.out.println(pato1.equals(pato2));

	}

}
