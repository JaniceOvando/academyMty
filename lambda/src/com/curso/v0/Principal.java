package com.curso.v0;

import java.util.function.Supplier;


class Empleado{
	String nombre;
	int edad;
	public Empleado(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + "]";
	}	
	
}

public class Principal {

	public static void main(String[] args) {

		//DEFINIMOS LA LAMBA
		Supplier<Double> supplier1 = () -> Math.random();
		
		double d = supplier1.get();
		
		System.out.println(d);
		
		Supplier<Empleado> supplier2 = () -> new Empleado("Filologo",20);
		
		Empleado e = supplier2.get();
		
		System.out.println(e);
		
		Empleado e1 = supplier2.get();
		
		System.out.println(e);
		
		System.out.println(e == e1); //false
		
		
		
	}

}
