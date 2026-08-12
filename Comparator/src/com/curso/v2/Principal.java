package com.curso.v2;

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
		
		System.out.println("V1 Comparator Lambda");
		
		Empleado[] empleados = {
				new Empleado("Patrobas",19,450.0),
				new Empleado("Tercio",25,350.0),
				new Empleado("Epeneto",19,650.0),
				new Empleado("Andronico",28,250.0),
				new Empleado("Filologo",23,150.0),
		};
		
		System.out.println("***POR EDAD***");
		
		Comparator<Empleado> compEdad = (o1,o2) -> o1.edad - o2.edad;
		
		Arrays.sort(empleados, compEdad );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***POR SUELDO***");
		
		Comparator<Empleado> compSueldo = (emp1,emp2) -> (int)(emp1.sueldo - emp2.sueldo);
		
		Arrays.sort(empleados, compSueldo );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		
		System.out.println("***POR NOMBRE***");
		
		Arrays.sort(empleados, (e1,e2)-> e1.nombre.compareTo(e2.nombre) );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
