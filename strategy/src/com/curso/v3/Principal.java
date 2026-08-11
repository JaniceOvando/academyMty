package com.curso.v3;

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
				new Aguila(), //1
				new Pato() //2
		};
		
		int random = new Random().nextInt(aves.length);
		
		System.out.println("random: "+random);
		System.out.println(aves[random]);
		
		return aves[random];
	}

}
