package com.curso.upper.v5;

import java.util.*;

class Figura{}

class Triangulo extends Figura{}
class Cuadrado extends Figura{}
class Circulo extends Figura{}

public class Principal {

	public static void main(String[] args) {
		
		//Solo Lectura
		//Upper Bounded Wildcard
		List<? extends Figura> list;
		
		List<Object> listObject = new ArrayList<>();
		listObject.add(new Object());
		listObject.add("Hola");
		listObject.add(Integer.valueOf(10));
		//list = listObject;
		
		List<String> listString = new ArrayList<>();
		listString.add("A");
		listString.add("B");
		listString.add("C");
		//list = listString;
		
		List<Figura> listaFigura = new ArrayList<>();
		listaFigura.add(new Figura());
		listaFigura.add(new Triangulo());
		listaFigura.add(new Circulo());
		list = listaFigura;

		List<Triangulo> listTriangulo = new ArrayList<>();
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		list = listTriangulo;
				
		List<Circulo> listCirculo = new ArrayList<>();
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		list = listCirculo;
		

	}
	
	
	
	
}
