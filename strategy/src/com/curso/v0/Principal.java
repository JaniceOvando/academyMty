package com.curso.v0;

public class Principal {
	
	public static void main(String[] args) {
		
		Ave ave = getAve();
		
		ave.volar(); //Polimorfismo
		
	}

	private static Ave getAve() {
		return new Pinguino();
	}

}
