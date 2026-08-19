package com.curso.v0;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record Empleado(int id, String nombre, int edad, double salario, String departamento){}

public class Principal {

	public static void main(String[] args) {
		
		
		//Crear 50 empleados Collection Set
		
		
		//filtra los que tengan mas de 30 años de edad
		//filtra los que ganen mas de 100 dlls
		//Dame la lista en que Departamentos se encuentran
		//Obten el departamento y suma de salarios del departamento
		//Ordena por departamento
		//Muestrame el departamento y la suma total de sueldos
		//Suma total de sueldos
		
		//DECLARATIVA, NO ME DIGAS EL "COMO" DIME EL "QUE"
		
		//int[] array = {0,1,2,3,4,5,6,7,8,9,10}; //.....50
		
		IntStream intStream = IntStream.range(0, 50);
		
		//intStream.forEach(i -> System.out.println(i));
		
		Stream<Empleado> streamEmpleados = intStream.mapToObj(x -> new Empleado(x+1,"",x+10, 0.00,""));
		
		//streamEmpleados.forEach(e -> System.out.println(e));
		
		List<Empleado> listaEmpleados = streamEmpleados.toList();
		
		System.out.println("***************");
		
		List<Integer> li = List.of(1,2,3,4,5,6,7,8,9);
		Stream<Integer> si = li.stream();
		
		Stream<Integer> s2 = Stream.of(1,2,3,4,5,6,7,8,9);
		
		IntStream intStream2 = s2.mapToInt(i -> i);
		
		IntSummaryStatistics iss = intStream2.summaryStatistics();
		
		System.out.println("Average: "+iss.getAverage()); 
		System.out.println("Sum: "+iss.getSum()); 
		System.out.println("Count: "+iss.getCount()); 
		System.out.println("Max: "+iss.getMax()); 
		System.out.println("Min: "+iss.getMin());
		
		
		
	}

}
