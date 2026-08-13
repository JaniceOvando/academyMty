package com.curso.lower.v7;

import java.util.*;

class Figura {}

class Triangulo extends Figura{}
class Cuadrado extends Figura{}
class Circulo extends Figura{}

public class Principal {

	public static void main(String[] args) {
		
		List<Object> listObject = new ArrayList<>();
		listObject.add(new Object());
		listObject.add("Hola");
		listObject.add(Integer.valueOf(10));
		show(listObject);
		
		List<String> listString = new ArrayList<>();
		listString.add("A");
		listString.add("B");
		listString.add("C");
		
		//show(listString);
		
		List<Figura> listaFigura = new ArrayList<>();
		listaFigura.add(new Figura());
		listaFigura.add(new Triangulo());
		listaFigura.add(new Circulo());
		
		//show(listaFigura);

		List<Triangulo> listTriangulo = new ArrayList<>();
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		
		//show(listTriangulo);
		
		List<Circulo> listCirculo = new ArrayList<>();
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		
		//show(listCirculo);
		
	}
	
	//Si se pueden añadir elementos (Escritura)
	//Lower bounded wildcard
	static void show(List<? super Figura> list) {
		list.add(new Figura());
		//list.add(new Object());
		list.add(new Triangulo());
		list.add(new Circulo());
		for (Object o:list)
			System.out.println(o);
	}
	
	
	
}
