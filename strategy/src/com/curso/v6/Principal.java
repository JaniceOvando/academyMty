package com.curso.v6;

import java.util.Random;

import com.curso.v5.strategy.*;


public class Principal {
	
	public static void main(String[] args) {
		
		ComportamientoVolar cv1 = new SiVolar();
		ComportamientoVolar cv2 = new NoVolar();
		ComportamientoVolar cv3 = new AleatorioVolar();
		
		Ave ave = getAve();
		
		ave.volar(); //DEFAULT
		
		ave.setComportamientoVolar(cv3);
		
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
