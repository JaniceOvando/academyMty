package com.curso.v2;

import java.util.Random;


public class Principal {
	
	public static void main(String[] args) {
		
		Ave ave = getAve();
		
		ave.volar();
		
	}

	private static Ave getAve() {
		
		Ave[] aves = {
				//new Ave(), 
				new Pinguino(), //0
				new AveDummy(), //1
				new Aguila(), //2
				new Pato() //3
		};
		
		int random = new Random().nextInt(aves.length);
		
		System.out.println("random: "+random);
		
		return aves[random];
	}

}
