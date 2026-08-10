package com.curso.v1;

class Pato{
	
	//Instancia
	String nombre; //null
	int contador; //0
	
	public Pato(String nombre) {
		this.nombre = nombre;
		contador++;
	}
	
}
public class Principal {

	public static void main(String[] args) {
		
		Pato pato1 = new Pato("Donald");
		Pato pato2 = new Pato("Lucas");
		Pato pato3 = new Pato("Patito Feo");
		
		System.out.println(pato1.contador); //1
		System.out.println(pato2.contador); //1
		System.out.println(pato3.contador); //1

	}

}
