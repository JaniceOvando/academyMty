package com.curso.v5;

import com.curso.v5.strategy.ComportamientoVolar;

public abstract class Ave {
	
	ComportamientoVolar cv; //HAS-A
	
	void volar() {
		cv.ejecutaVuelo(); //DELEGAR
	}
	
	@Override
	public  String toString() {
		return this.getClass().getSimpleName(); //Polimorfismo
	}
	
}
