package com.curso.v0;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		List nombres = new ArrayList();
		
		nombres.add("Patrobas");
		nombres.add("Epeneto");
		nombres.add("Filologo");
		nombres.add("Andronico");
		nombres.add(new Object());
		nombres.add(Integer.valueOf(10));
		
		for(Object name : nombres) {
			System.out.println(name);
			
			if (name instanceof String)
				System.out.println("length: "+((String)name).length());
			if (name instanceof Integer)
				System.out.println(((Integer)name).toHexString(10));
		}
		
		
	}

}
