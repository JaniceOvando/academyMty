package com.curso.v8;

public class Contenedor<T extends Transporte> {
	
	private T t; 

	public Contenedor(T t) {
		this.t = t;
	}
	
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	static public <Q extends Transporte, Z extends CharSequence> void showCertificate(Q q, Z z) {
		System.out.println( q.getClass().getSimpleName() +" : "+z);
	}
}
