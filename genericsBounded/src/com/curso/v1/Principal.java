package com.curso.v1;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		
		List<Object> listObject = new ArrayList<>();
		listObject.add(new Object());
		listObject.add("Hola");
		listObject.add(Integer.valueOf(10));

		//show(listObject);
		showUnbounded(listObject);
		
		List<String> listString = new ArrayList<>();
		listString.add("A");
		listString.add("B");
		listString.add("C");
		
		
		//show(listString);
		showUnbounded(listString);
	}
	
	static void show(List<Object> list) {
		for (Object f:list)
			System.out.println(f.getClass().getSimpleName());
	}
	
	
	
	static void showUnbounded(List<?> list) {
		for (Object f:list)
			System.out.println(f.getClass().getSimpleName());
	}
	
	
	
	
}
