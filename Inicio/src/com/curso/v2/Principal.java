package com.curso.v2;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
	
	void volarAve() {
		System.out.println("volarAve();");
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
	@Override
	void volar() {
		System.out.println("Perico volar");
	}
	void volarPerico() {
		System.out.println("volarPerico()");
	}
}

public class Principal {
	public static void main(String[] args) {
		Ave ave = new Pinguino();
		ave.volar(); //<===
		
		ave = new Aguila();
		ave.volar(); //<===
		
		ave = new Perico();
		ave.volar(); //<===
		
		ave.volarAve();	
		((Perico)ave).volarPerico();
		
	}
}
