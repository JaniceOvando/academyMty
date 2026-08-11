package com.curso.v4;

public abstract class Ave {
	
	abstract void volar();
	
	@Override
	public  String toString() {
		return this.getClass().getSimpleName(); //Polimorfismo
	}
	
}
