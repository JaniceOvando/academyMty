package com.curso.v1;

import java.util.Objects;
import java.util.function.BiFunction;


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
		Empleado other = (Empleado) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre);
	}	
	
}

public class Principal {

	public static void main(String[] args) {
		
		BiFunction<String,Integer,Empleado> biFunction = (name,age) -> {

		    // Limpieza
			name = name.trim();

		    // Validación
		    if (name.isEmpty()) {
		    	name = "Sin nombre";
		    }

		    if (age < 18) {
		        throw new IllegalArgumentException("Debe ser mayor de edad");
		    }

		    return new Empleado(name, age);
		};
		
		Empleado emp1 = biFunction.apply("", 20);
		
		System.out.println(emp1);
		
		try {
			Empleado emp2 = biFunction.apply("Patrobas", 17);
			System.out.println(emp2);
		}catch (RuntimeException e) {
			
		}
		
		System.out.println("Fin Programa");
		
		
		
	}

}
