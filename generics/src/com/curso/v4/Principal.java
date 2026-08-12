package com.curso.v4;

import java.util.Random;

class Bici{}
class Patines{}
class Moto{}

public class Principal {
	public static void main(String[] args) {
		
		Bici bici = new Bici();
		Patines patines = new Patines();
		Moto moto = new Moto();
		
		Contenedor<Moto> contenedor1 = new Contenedor<>(moto);
		Contenedor<Bici> contenedor2 = new Contenedor<>(bici);
		
		Contenedor<Random> contenedor3 = new Contenedor<>(new Random());
		Contenedor<Object> contenedor4 = new Contenedor<>(new Object());
		
		

	}
}
