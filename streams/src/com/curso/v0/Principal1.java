package com.curso.v0;

//import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Principal1 {

	public static void main(String[] patitos) {
		
		//PrintStream ps = System.out;
		//ps.println("Hola Mundo");
		
		List<Empleado> listaEmpleados = FabricaEmpleados.crearEmpleados(20);
		
		listaEmpleados.forEach(emp -> System.out.println(emp));
		
		List<String> lista = listaEmpleados.stream()
        	.filter(e -> e.edad() > 30) //Predicate
        	.filter(e -> e.salario() > 100) //Predicate
        	.map(Empleado::departamento) //Function 
            .distinct() 
            .sorted()
            .toList();
        	
		//lista.forEach(System.out::println);
		
		
		Map<String,Double> map = listaEmpleados.stream()
        	.collect(Collectors.groupingBy(
        			Empleado::departamento,
        			TreeMap::new,
        			Collectors.summingDouble(Empleado::salario)));
		
		map.forEach((x,y)-> System.out.println("Departamento: "+x+
				", Suma Sueldos:"+y));
		
		
	}

}
