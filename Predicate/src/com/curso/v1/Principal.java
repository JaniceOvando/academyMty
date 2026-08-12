package com.curso.v1;

import java.util.*;

interface Predicado<T>{
	boolean probar(T t);
	
	static <Z> Predicado<Z> and(Predicado<Z> pre1, Predicado<Z> pre2) {
		return pato -> (pre1.probar(pato) && pre2.probar(pato));	
	}
	
	static <E> Predicado<E> or(Predicado<E> pre1, Predicado<E> pre2) {
		return w -> (pre1.probar(w) || pre2.probar(w));	
	}
	
	static <Y> Predicado<Y> negate(Predicado<Y> pre) {
		return n -> !pre.probar(n);	
	}
}

//class MyPredicado implements Predicado<String>{
//	@Override
//	public boolean probar(String oso) {
//		return oso.contains("n");
//	}
//}


public class Principal {

	public static void main(String[] args) {
		
		System.out.println("static");
		
		List<String> nombres = new ArrayList<>();
		
		nombres.add("Patrobas");
		nombres.add("Epeneto");
		nombres.add("Filologo");
		nombres.add("Andronico");
		nombres.add("Tercio");
		
		Predicado<String> pre1 = w -> w.contains("n");
		Predicado<String> pre2 = r -> r.length() > 8;
		
		Predicado<String> pre3 = Predicado.and(pre1, pre2); //CONTRUIR LAMBDA
		//x -> (pre1.probar(x) & pre2.probar(x));
		
		System.out.println("***AND***");
		
		for(String name:nombres) {
			if (pre3.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
		System.out.println("***OR***");
		
		pre3 = Predicado.or(pre1, pre2);
		
		for(String name:nombres) {
			if (pre3.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
		
		System.out.println("***NEGATE***");
		Predicado<String> pre4 = Predicado.negate(pre3);
		
		for(String name:nombres) {
			if (pre4.probar(name)) //EJECUTA LAMBDA
				System.out.println(name);
		}
		
	}

	
}
