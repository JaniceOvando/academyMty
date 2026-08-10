package com.curso.v1;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
}

class Pinguino extends Ave{
	void volar() {
		System.out.println("Pinguino volar");
	}
}

class Aguila extends Ave{
	void volar() {
		System.out.println("Aguila volar");
	}
}

class Perico extends Ave{
	void volar() {
		System.out.println("Perico volar");
	}
}

public class Principal2 {
	public static void main(String[] args) {
		Ave ave = new Pinguino();
		ave.volar(); //<===
		
		ave = new Aguila();
		ave.volar(); //<===
		
		ave = new Perico();
		ave.volar(); //<===
		
	}
}
