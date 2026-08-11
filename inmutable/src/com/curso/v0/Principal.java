package com.curso.v0;

import java.util.Arrays;

final class Alumno{
	
	//ESTADO DEL OBJECTO
	private final String nombre; 
	private final int edad;
	private final int[] calificaciones; //MUTABLE
	
	public Alumno(String nombre, int edad, int[] calificaciones) {
		this.nombre = nombre;
		this.edad = edad;
		this.calificaciones = Arrays.copyOf(calificaciones, calificaciones.length);
		//this.calificaciones = calififaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int[] getCalificaciones() {
		return Arrays.copyOf(calificaciones, calificaciones.length);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + 
				", calififaciones=" + Arrays.toString(calificaciones)
				+ "]";
	}
	
	
}

public class Principal {

	public static void main(String[] args) {
		
		int[] calificaciones = {9,8,7,9,8};
		
		Alumno patrobas = new Alumno("Patrobas",20,calificaciones);
		
		System.out.println(patrobas);
		
		calificaciones[2] = 10;
		
		System.out.println(patrobas);
		
		calificaciones = patrobas.getCalificaciones();
		
		calificaciones[2] = 10;
		
		System.out.println(patrobas);
		
		

	}

}
