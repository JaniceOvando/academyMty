package com.curso.v5.strategy;

public class SiVolar implements ComportamientoVolar {

	@Override
	public void ejecutaVuelo() {
		System.out.println("Si volar");
	}

}
