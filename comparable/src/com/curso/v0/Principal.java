package com.curso.v0;

import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {

		String[] arreglo = {"a", "9a", "Aa", "111", "zA"};
		
		System.out.println(Arrays.toString(arreglo));
		
		Arrays.sort(arreglo);
		
		System.out.println(Arrays.toString(arreglo));
		
		//111, 9a, Aa, a, zA
		
	}

}
