package com.curso.v2;

class Pato{
	
	//Instancia
	String nombre; //null
	//Clase
	static int contador; //0
	
	public Pato(String nombre) {
		this.nombre = nombre;
		contador++;
	}
	
}
public class Principal {

	public static void main(String[] args) {
		
		System.out.println(Pato.contador); //0
		
		Pato pato1 = new Pato("Donald");
		Pato pato2 = new Pato("Lucas");
		Pato pato3 = new Pato("Patito Feo");
		
		System.out.println(pato1.contador); //3
		System.out.println(pato2.contador); //3
		System.out.println(pato3.contador); //3
		
		System.out.println(Pato.contador); //3

	}

}
