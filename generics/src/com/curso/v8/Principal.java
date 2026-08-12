package com.curso.v8;

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
		
		Contenedor.showCertificate(moto,new StringBuilder("xyz123"));
		Contenedor.showCertificate(bici,"TRU987");
		Contenedor.showCertificate(patines,new StringBuffer("234"));
		
		

	}
}
