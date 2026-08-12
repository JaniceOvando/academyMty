package com.curso.v4;

import java.util.Arrays;
import java.util.Comparator;

class Empleado{
	
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}

public class Principal {
	public static void main(String[] args) {
		
		System.out.println("V4 Comparator Functional");
		
		Empleado[] empleados = {
				new Empleado("Patrobas",19,150.0),
				new Empleado("Tercio",25,350.0),
				new Empleado("Epeneto",18,150.0),
				new Empleado("Andronico",28,250.0),
				new Empleado("Filologo",19,150.0),
		};
		
		//PROGRAMACION DECLARATIVA (QUE (SQL))
		Comparator<Empleado> comparator = Comparator.comparingDouble(Empleado::getSueldo)
											.thenComparingInt(Empleado::getEdad)
											.thenComparing(Empleado::getNombre)
											.reversed();
		
		Arrays.sort(empleados, comparator );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
