package com.curso.v3;

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

		show(listaFigura);
		show2(listaFigura);
		
		List<Triangulo> listTriangulo = new ArrayList<>();
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		listTriangulo.add(new Triangulo());
		
		//show(listTriangulo);
		show2(listTriangulo);
		
		List<Circulo> listCirculo = new ArrayList<>();
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		listCirculo.add(new Circulo());
		
		//show(listCirculo);
		show2(listCirculo);
	}
	
	static void show(List<Figura> listaFigura) {
		for (Figura f:listaFigura)
			System.out.println(f.getClass().getSimpleName());
	}
	
	//Unbounded wildcard
	//Trata al collection solo de lectura
	static void show2(List<?> listaFigura) {
		
//		listaFigura.add(new Figura());
//		listaFigura.add(new Object());
		
		for (Object f:listaFigura)
			System.out.println(f.getClass().getSimpleName());
	}
	
	
	
}
