package com.curso.v2;

import java.util.Arrays;

class Empleado implements Comparable<Empleado> {
	
	private String nombre;
	private int edad;
	private double sueldo;
	
	public Empleado(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}

	@Override
	public int compareTo(Empleado o) {
		return (int)(o.sueldo - sueldo);
	}
	
}

public class Principal {
	
	
	public static void main(String[] args) {
		
		System.out.println("V2");
		
		Empleado[] empleados = {
				new Empleado("Patrobas",30,450.0),
				new Empleado("Tercio",25,350.0),
				new Empleado("Epeneto",19,650.0),
				new Empleado("Andronico",28,250.0),
				new Empleado("Filologo",23,150.0),
		};
		
		Arrays.sort(empleados);
		
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
