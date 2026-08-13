package com.curso.v2;

import java.util.*;

class Figura{}

class Triangulo extends Figura{}
class Cuadrado extends Figura{}
class Circulo extends Figura{}

public class Principal {

	public static void main(String[] args) {
		
		List<Figura> listaFigura = new ArrayList<>();
		listaFigura.add(new Figura());
		listaFigura.add(new Triangulo());
		listaFigura.add(new Circulo());

		
		List<Triangulo> listTriangulo = new ArrayList<>();
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		
		//List<Figura> listaFigura1 = listTriangulo;
		List<?> listaFigura2 = listTriangulo;
		
		List<Circulo> listCirculo = new ArrayList<>();
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		
		//List<Figura> listaFigura1 = listCirculo;
		listaFigura2 = listCirculo;
		
		//listaFigura2.add(new Circulo());

	}
	
	
	
	
}
