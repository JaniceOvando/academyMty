package com.curso.v1;

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
	public int hashCode() {
		return Objects.hash(Integer.valueOf(edad), nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
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
