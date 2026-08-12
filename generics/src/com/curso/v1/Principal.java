package com.curso.v1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		List<String> nombres = new ArrayList<>();
		
		nombres.add("Patrobas");
		nombres.add("Epeneto");
		nombres.add("Filologo");
		nombres.add("Andronico");
//		nombres.add(new Object());
//		nombres.add(Integer.valueOf(10));
		
		for(String name : nombres) {
			System.out.println(name);
			System.out.println("length: "+name.length());
		}
		
		
	}

}
