package com.curso.v2;

class Bici{}
class Patines{}
class Moto{}

public class Principal {
	public static void main(String[] args) {
		
		Bici bici = new Bici();
		Patines patines = new Patines();
		Moto moto = new Moto();
		
		Contenedor<Moto> contenedor1 = new Contenedor<>(moto);
		
		System.out.println(contenedor1);

	}
}
