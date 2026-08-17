package com.curso.v1;


public class Principal {
	
	//Static Inner Class
	static class Estudiante{
		String nombre;
	}
	
	public static void main(String[] args) {
		
		Estudiante e1 = new Principal.Estudiante(); 
		
		Principal p = new Principal();
		
		//Estudiante e2 =  p.new Estudiante(); 
		
	}
	
}
