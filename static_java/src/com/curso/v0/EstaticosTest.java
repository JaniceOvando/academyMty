package com.curso.v0;

class Vehiculo {
	static String tipo() {
		return "Vehiculo";
	}

	String nombre() {
		return "Vehiculo";
	}
}

class Moto extends Vehiculo {
	String nombre() {
		return "Moto";
	}
}

public class EstaticosTest {
	public static void main(String[] args) {
		Vehiculo v = new Moto();
		System.out.println(v.tipo());
		System.out.println(Vehiculo.tipo());
		System.out.println(v.nombre());
	}
}