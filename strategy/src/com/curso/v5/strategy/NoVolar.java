package com.curso.v5.strategy;

public class NoVolar implements ComportamientoVolar {

	@Override
	public void ejecutaVuelo() {
		System.out.println("No volar");
	}

}
