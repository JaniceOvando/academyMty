package com.curso.v3;

import java.util.function.Predicate;

public class Principal {

	public static void main(String[] args) {
		
		Predicate<String> predicate0 = pato -> pato.contains("x");

		Predicate<String> predicate = new Predicate<>() {
			@Override
			public boolean test(String pato) {
				return pato.contains("x");
			}
		};
		
		boolean res = predicate.test("Epenexto");
		
		System.out.println(res);

	}

}
