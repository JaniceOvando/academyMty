package com.curso.v6;

import java.util.Random;

interface Transporte{}

class Bici implements Transporte{}
class Patines implements Transporte{}
class Moto implements Transporte{}

public class Principal {
	public static void main(String[] args) {
		
		Bici bici = new Bici();
		Patines patines = new Patines();
		Moto moto = new Moto();
		
		Contenedor<Moto> contenedor1 = new Contenedor<>(moto);
		Contenedor<Bici> contenedor2 = new Contenedor<>(bici);
		Contenedor<Patines> contenedor3 = new Contenedor<>(patines);
		
		contenedor1.showCertificate(new StringBuilder("xyz123"));
		contenedor2.showCertificate(new Random().nextInt(10));
		contenedor3.showCertificate("TUV987");
		
		

	}
}
