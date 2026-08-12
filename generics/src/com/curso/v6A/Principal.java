package com.curso.v6A;

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
		
		contenedor1.<StringBuilder>showCertificate(new StringBuilder("xyz123"));
		contenedor2.<Random>showCertificate(new Random());
		contenedor2.<Integer>showCertificate(new Random().nextInt(10));
		contenedor3.<String>showCertificate("TUV987");
		
	}
}
