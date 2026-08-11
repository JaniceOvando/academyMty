package com.curso.v1;

import java.util.Random;


public class Principal {
	
	public static void main(String[] args) {
		
		Ave ave = getAve();
		
		if (ave != null)
			ave.volar();
		else
			System.out.println("Soy null");
		
	}

	private static Ave getAve() {
		
		Ave[] aves = {
				new Ave(), //0
				new Pinguino(), //1
				new Aguila(), //2
				null, //3
				new Pato() //4
		};
		
		int random = new Random().nextInt(aves.length);
		
		System.out.println("random: "+random);
		
		return aves[random];
	}

}
