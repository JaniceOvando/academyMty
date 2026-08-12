package com.curso.v2A;

public class Contenedor<T,U,Z> {
	
	T t; //HAS-A
	U u;
	Z z;

	public Contenedor(T t,U u,Z z) {
		this.t = t;
		this.u = u;
		this.z = z;
	}

}
