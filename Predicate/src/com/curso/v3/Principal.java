package com.curso.v3;

import java.util.*;

interface Predicado<T>{
	boolean probar(T t);
	
	default Predicado<T> and(Predicado<T> pre) {
		return pato -> (this.probar(pato) && pre.probar(pato));	
	}
	
	default Predicado<T> or(Predicado<T> pre) {
		return w -> (this.probar(w) || pre.probar(w));	
	}
	
	default Predicado<T> negate() {
		return n -> !this.probar(n);	
	}
}


public class Principal {

	public static void main(String[] args) {
				
		List<String> nombres = new ArrayList<>();
		
		nombres.add("Patrobas");
		nombres.add("Epeneto");
		nombres.add("Filologo");
		nombres.add("Andronico");
		nombres.add("Tercio");
		
		Predicado<String> pre = w -> w.contains("n");
				
		Predicado<String> pre1 = pre.or(w -> w.contains("n")).and(r -> r.length() > 8);
		
		for(String name:nombres) {
			if (pre1.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
	}
	
}
