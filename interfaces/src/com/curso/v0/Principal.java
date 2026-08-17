package com.curso.v0;

interface Ave{
	void volar(); //public abstract 
}

class Aguila implements Ave{

	@Override
	public void volar() {
		
	}
	
}

class Empleado{
	protected void cobrar() {}
}

class EmpleadoExterno extends Empleado{
	@Override
	public void cobrar() {}
}

public class Principal {

	public static void main(String[] args) {

	}

}
