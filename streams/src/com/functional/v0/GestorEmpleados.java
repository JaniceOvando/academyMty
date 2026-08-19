package com.functional.v0;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Toda la logica resuelta con Streams y lambdas.
 * Ningun ciclo, ninguna variable acumuladora, ninguna mutacion.
 */
public class GestorEmpleados {

    private final List<Empleado> empleados;

    public GestorEmpleados(List<Empleado> empleados) {
        this.empleados = List.copyOf(empleados);
    }

    public List<Empleado> getEmpleados() {
        return List.copyOf(empleados);
    }

    // 1. Filtra los que tengan mas de 30 anos de edad
    public List<Empleado> filtrarPorEdadMayorA(int edadMinima) {
        return empleados.stream()
                .filter(e -> e.edad() > edadMinima)
                .toList();
    }

    // 2. Filtra los que ganen mas de 100 dlls
    public List<Empleado> filtrarPorSalarioMayorA(double salarioMinimo) {
        return empleados.stream()
                .filter(e -> e.salario() > salarioMinimo)
                .toList();
    }

    // Filtro generico: el criterio se recibe como funcion
    public List<Empleado> filtrarPor(Predicate<Empleado> criterio) {
        return empleados.stream()
                .filter(criterio)
                .toList();
    }

    // 3. Lista de departamentos en los que se encuentran
    public List<String> obtenerDepartamentos() {
        return empleados.stream()
                .map(Empleado::departamento)
                .distinct()
                .sorted()
                .toList();
    }

    // 4. Departamento -> suma de salarios (TreeMap para llaves ordenadas)
    public Map<String, Double> sumarSalariosPorDepartamento() {
        return empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::departamento,
                        TreeMap::new,
                        Collectors.summingDouble(Empleado::salario)));
    }

    // 5. Ordena por departamento, desempata por nombre
    public List<Empleado> ordenarPorDepartamento() {
        return empleados.stream()
                .sorted(Comparator.comparing(Empleado::departamento)
                        .thenComparing(Empleado::nombre))
                .toList();
    }

    // 6. Estadisticas por departamento: conteo, suma y promedio en una pasada
    public Map<String, DoubleSummaryStatistics> estadisticasPorDepartamento() {
        return empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::departamento,
                        TreeMap::new,
                        Collectors.summarizingDouble(Empleado::salario)));
    }

    // 7. Suma total de sueldos
    public double sumarTotalSalarios() {
        return empleados.stream()
                .mapToDouble(Empleado::salario)
                .sum();
    }
}
