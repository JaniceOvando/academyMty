package com.curso.v0;

class Pato{}

public class Principal {

	public static void main(String[] args) {

		Pato pato1 = new Pato();
		System.out.println(pato1); 
		//DIRECCION DE MEMORIA //FALSO
		
		Pato pato2 = new Pato();
		System.out.println(pato2);
		
	}

}
