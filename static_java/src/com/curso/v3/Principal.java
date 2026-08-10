package com.curso.v3;

class Pato{
	
	//Instancia
	private String nombre; //null
	//Clase
	private static int contador; //0
	
	public Pato(String nombre) {
		this.nombre = nombre;
		contador++;
	}
	
	static int getContador(){
		return contador;
	}
}
public class Principal {

	public static void main(String[] args) {
		
		System.out.println(Pato.getContador()); //0
		
		Pato pato1 = new Pato("Donald");
		Pato pato2 = new Pato("Lucas");
		Pato pato3 = new Pato("Patito Feo");

		System.out.println(Pato.getContador()); //3

	}

}
