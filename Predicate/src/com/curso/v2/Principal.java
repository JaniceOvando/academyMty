package com.curso.v2;

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
		
		System.out.println("default");
		
		List<String> nombres = new ArrayList<>();
		
		nombres.add("Patrobas");
		nombres.add("Epeneto");
		nombres.add("Filologo");
		nombres.add("Andronico");
		nombres.add("Tercio");
		
		Predicado<String> pre1 = w -> w.contains("n");
		Predicado<String> pre2 = r -> r.length() > 8;
		
		System.out.println("***AND***");
		
		Predicado<String> pre3 = pre1.and(pre2); //CONTRUIR LAMBDA
		//pato -> (this.probar(pato) && pre.probar(pato));
		
		for(String name:nombres) {
			if (pre3.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
		System.out.println("***OR***");
		
		pre3 = pre1.or(pre2);
		
		for(String name:nombres) {
			if (pre3.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
		
		System.out.println("***NEGATE***");
		Predicado<String> pre4 = pre3.negate();
		
		for(String name:nombres) {
			if (pre4.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
		
	}

	
}
