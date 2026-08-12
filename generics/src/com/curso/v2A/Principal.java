package com.curso.v2A;

class Bici{}
class Patines{}
class Moto{}

public class Principal {
	public static void main(String[] args) {
		
		Bici bici = new Bici();
		Patines patines = new Patines();
		Moto moto = new Moto();
		
		Contenedor<Moto,Bici,StringBuilder> contenedor1 = 
				new Contenedor<>(moto,bici,new StringBuilder("Hello"));
		
		System.out.println(contenedor1);

	}
}
