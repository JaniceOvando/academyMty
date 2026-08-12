package com.curso.v0;

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

class ComparatorEdad implements Comparator<Empleado>{
	@Override
	public int compare(Empleado o1, Empleado o2) {
		return o1.edad - o2.edad;
	}
}

class ComparatorSueldo implements Comparator<Empleado>{
	@Override
	public int compare(Empleado o1, Empleado o2) {
		return (int)(o1.sueldo - o2.sueldo);
	}
}

//PROGRAMACION IMPERATIVA (QUE Y COMO)
class ComparatorEdadSueldo implements Comparator<Empleado>{
	@Override
	public int compare(Empleado o1, Empleado o2) {
		int x = o1.edad - o2.edad;
		if (x==0)
			return (int)(o1.sueldo - o2.sueldo);
		else
			return x;
	}
}

class ComparatorNombre implements Comparator<Empleado>{
	@Override
	public int compare(Empleado o1, Empleado o2) {
		return o1.nombre.compareTo(o2.nombre);
	}
}


public class Principal {
	public static void main(String[] args) {
		
		System.out.println("V0 Comparator");
		
		Empleado[] empleados = {
				new Empleado("Patrobas",19,450.0),
				new Empleado("Tercio",25,350.0),
				new Empleado("Epeneto",19,650.0),
				new Empleado("Andronico",28,250.0),
				new Empleado("Filologo",23,150.0),
		};
		
		System.out.println("***POR EDAD***");
		
		Arrays.sort(empleados, new ComparatorEdad() );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***POR SUELDO***");
		
		Arrays.sort(empleados, new ComparatorSueldo() );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***POR EDAD/SUELDO***");
		
		Arrays.sort(empleados, new ComparatorEdadSueldo() );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
		System.out.println("***POR NOMBRE***");
		
		Arrays.sort(empleados, new ComparatorNombre() );
		
		for (Empleado e:empleados)
			System.out.println(e);
		
	}

}
