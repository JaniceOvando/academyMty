package com.curso.v3;

import java.util.Arrays;
import java.util.Comparator;

class Empleado{
	
	String nombre;
	int edad;
	double sueldo;
	
	public Empleado(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}
}

public class Principal {
	public static void main(String[] args) {
		
		System.out.println("V3 Comparator Lambda");
		
		Empleado[] empleados = {
				new Empleado("Patrobas",19,450.0),
				new Empleado("Tercio",25,350.0),
				new Empleado("Epeneto",19,650.0),
				new Empleado("Andronico",28,250.0),
				new Empleado("Filologo",23,150.0),
		};
		
		System.out.println("***POR EDAD***");
		
		Arrays.sort(empleados, (pato1,pato2) -> pato1.edad - pato2.edad );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***POR SUELDO***");
		
		Arrays.sort(empleados, (x,z) -> (int)(x.sueldo - z.sueldo) );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		
		System.out.println("***POR NOMBRE***");
		
		Arrays.sort(empleados, (e1,e2)-> e1.nombre.compareTo(e2.nombre) );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
