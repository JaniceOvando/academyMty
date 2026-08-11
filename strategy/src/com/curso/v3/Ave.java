package com.curso.v3;

public abstract class Ave {
	
	abstract void volar();
	
	@Override
	public  String toString() {
		return this.getClass().getSimpleName(); //Polimorfismo
	}
	
}
