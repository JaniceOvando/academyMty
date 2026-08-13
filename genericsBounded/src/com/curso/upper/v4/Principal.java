package com.curso.upper.v4;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		List<Object> listObject = new ArrayList<>();
		listObject.add(new Object());
		listObject.add("Hola");
		listObject.add(Integer.valueOf(10));

		show(listObject);
		//showUpperbounded(listObject);
		
		List<String> listString = new ArrayList<>();
		listString.add("A");
		listString.add("B");
		listString.add("C");
		
		//show(listString);
		showUpperbounded(listString);
		
		List<StringBuilder> listStringBuilder = new ArrayList<>();
		listStringBuilder.add(new StringBuilder("AA"));
		listStringBuilder.add(new StringBuilder("BB"));
		listStringBuilder.add(new StringBuilder("CC"));
		
		//show(listStringBuilder);
		showUpperbounded(listStringBuilder);
	}
	
	static void show(List<Object> list) {
		list.add(new Random());
		list.add("A");
		for (Object f:list)
			System.out.println(f.getClass().getSimpleName());
	}
	
	
	//SOLO DE LECTURA
	//UPPER BOUNDED WILDCARD
	static void showUpperbounded(List<? extends CharSequence> list) {
		for (CharSequence f:list)
			System.out.println(f.getClass().getSimpleName());
	}
	
}
