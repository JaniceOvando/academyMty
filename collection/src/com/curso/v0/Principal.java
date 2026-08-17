package com.curso.v0;

import java.util.*;

class Estudiante{
	private String nombre;
	private int edad;
	public Estudiante(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", edad=" + edad + "]";
	}	
	
	@Override
	public boolean equals(Object e) {
		Estudiante other = (Estudiante)e;
		if (nombre.equals(other.nombre) && edad == other.edad)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		//return 99;
		//return nombre.hashCode();
		return edad;
	}

	
}


public class Principal {

	public static void main(String[] args) {
		
		Set<Estudiante> estudiantes = new HashSet<>();
		
		estudiantes.add(new Estudiante("Filologo",20));
		estudiantes.add(new Estudiante("Epeneteo",25));
		estudiantes.add(new Estudiante("Filologo",20));
		
		for(Estudiante e: estudiantes)
			System.out.println(e);

	}

}
