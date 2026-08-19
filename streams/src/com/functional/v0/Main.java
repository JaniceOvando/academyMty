package com.functional.v0;


import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Main {

    private static final int EDAD_FILTRO = 30;
    private static final double SALARIO_FILTRO = 100.0;

    public static void main(String[] args) {

    	List<Empleado> listaEmpleados = FabricaEmpleados.crearEmpleados(50);
    	
        GestorEmpleados gestor = new GestorEmpleados(listaEmpleados);

        imprimirTitulo("NOMINA COMPLETA (50 EMPLEADOS)");
        gestor.getEmpleados().forEach(System.out::println);

        // ---------- 1 ----------
        imprimirTitulo("1. EMPLEADOS CON MAS DE " + EDAD_FILTRO + " ANOS");
        List<Empleado> mayores = gestor.filtrarPorEdadMayorA(EDAD_FILTRO);
        mayores.forEach(System.out::println);
        System.out.println("Total encontrados: " + mayores.size());

        // ---------- 2 ----------
        imprimirTitulo("2. EMPLEADOS QUE GANAN MAS DE $" + SALARIO_FILTRO);
        List<Empleado> bienPagados = gestor.filtrarPorSalarioMayorA(SALARIO_FILTRO);
        bienPagados.forEach(System.out::println);
        System.out.println("Total encontrados: " + bienPagados.size());

        // ---------- 3 ----------
        imprimirTitulo("3. DEPARTAMENTOS EXISTENTES");
        gestor.obtenerDepartamentos()
                .forEach(departamento -> System.out.println(" - " + departamento));

        // ---------- 4 ----------
        imprimirTitulo("4. DEPARTAMENTO Y SUMA DE SALARIOS");
        gestor.sumarSalariosPorDepartamento()
                .forEach((departamento, suma) ->
                        System.out.printf("%-20s $%10.2f%n", departamento, suma));

        // ---------- 5 ----------
        imprimirTitulo("5. EMPLEADOS ORDENADOS POR DEPARTAMENTO");
        gestor.ordenarPorDepartamento().forEach(System.out::println);

        // ---------- 6 ----------
        imprimirTitulo("6. REPORTE POR DEPARTAMENTO");
        System.out.printf("%-20s %-10s %-14s %s%n",
                "DEPARTAMENTO", "EMPLEADOS", "SUMA SUELDOS", "PROMEDIO");
        System.out.println("-".repeat(60));
        Map<String, DoubleSummaryStatistics> estadisticas = gestor.estadisticasPorDepartamento();
        estadisticas.forEach((departamento, stats) ->
                System.out.printf("%-20s %-10d $%-13.2f $%.2f%n",
                        departamento, stats.getCount(), stats.getSum(), stats.getAverage()));

        // ---------- 7 ----------
        imprimirTitulo("7. SUMA TOTAL DE SUELDOS");
        System.out.printf("Nomina total: $%.2f%n", gestor.sumarTotalSalarios());
    }

    private static void imprimirTitulo(String titulo) {
        System.out.println();
        System.out.println("=".repeat(60));
        System.out.println(titulo);
        System.out.println("=".repeat(60));
    }
}
