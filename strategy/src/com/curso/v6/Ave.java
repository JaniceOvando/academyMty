package com.curso.v6;

import com.curso.v5.strategy.ComportamientoVolar;

public abstract class Ave {
	
	//ENCAPSULAR
	private ComportamientoVolar cv; //HAS-A
	
	Ave(ComportamientoVolar cv){
		this.cv= cv;
	}
	
	void volar() {
		cv.ejecutaVuelo(); //DELEGAR
	}
	
	@Override
	public  String toString() {
		return this.getClass().getSimpleName(); //Polimorfismo
	}
	
	public void setComportamientoVolar(ComportamientoVolar cv) {
		this.cv = cv;
	}
	
}
