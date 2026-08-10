package com.curso.v3;

class Ave{
	void volar() {
		System.out.println("Ave volar");
	}
	
	void volarAve() {
		System.out.println("volarAve();");
	}
}

class Aguila extends Ave{
	void volar() {
		System.out.println("Aguila volar");
	}
	void volarAguila() {
		System.out.println("volarAguila();");
	}
}

class AguilaReal extends Aguila{
	void volar() {
		System.out.println("AguilaReal volar");
	}
	void volarAguilaReal() {
		System.out.println("volarAguilaReal();");
	}
}

class AguilaCalva extends Aguila{
	void volar() {
		System.out.println("AguilaCalva volar");
	}
	void volarAguilaCalva() {
		System.out.println("volarAguilaCalva();");
	}
}





public class Principal {
	public static void main(String[] args) {
		AguilaCalva ave1 = new AguilaCalva();
		
		ave1.volarAguilaCalva();
		ave1.volarAguila();
		ave1.volarAve();
		
		Aguila ave2 = ave1; //UPCAST
		
		//ave2.volarAguilaCalva();
		ave2.volarAguila();
		ave2.volarAve();
		
		Ave ave3 = ave2;
		
		//ave3.volarAguilaCalva();
		//ave3.volarAguila();
		ave3.volarAve();
		
		Object ave4 = ave3;
		((AguilaCalva)ave4).volarAguilaCalva();
		((Aguila)ave4).volarAguila();
		((Ave)ave4).volarAve();
		
		//HASTA ESTE PUNTO ***UPCAST***
		
		//EMPIEZA ***DOWNCAST***
		Ave ave5 = (Ave)ave4;
		
		Aguila ave6 = (Aguila)ave5;
		
		//instanceof
		
		if (ave6 instanceof AguilaReal) {
			AguilaReal ave7 = (AguilaReal)ave6;
			ave7.volarAguilaReal(); //ClassCastException
		}else {
			AguilaCalva ave7 = (AguilaCalva)ave6;
			ave7.volarAguilaCalva();
		}
		System.out.println("End Program");
	}
		
}
