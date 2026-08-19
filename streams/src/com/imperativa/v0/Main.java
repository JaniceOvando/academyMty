package com.imperativa.v0;


import java.util.List;
import java.util.Map;

public class Main {

    private static final int EDAD_FILTRO = 30;
    private static final double SALARIO_FILTRO = 100.0;

    public static void main(String[] args) {

        GestorEmpleados gestor = new GestorEmpleados(FabricaEmpleados.crearEmpleados(50));

        imprimirTitulo("NOMINA COMPLETA (50 EMPLEADOS)");
        imprimirLista(gestor.getEmpleados());

        // ---------- 1 ----------
        imprimirTitulo("1. EMPLEADOS CON MAS DE " + EDAD_FILTRO + " ANOS");
        List<Empleado> mayores = gestor.filtrarPorEdadMayorA(EDAD_FILTRO);
        imprimirLista(mayores);
        System.out.println("Total encontrados: " + mayores.size());

        // ---------- 2 ----------
        imprimirTitulo("2. EMPLEADOS QUE GANAN MAS DE $" + SALARIO_FILTRO);
        List<Empleado> bienPagados = gestor.filtrarPorSalarioMayorA(SALARIO_FILTRO);
        imprimirLista(bienPagados);
        System.out.println("Total encontrados: " + bienPagados.size());

        // ---------- 3 ----------
        imprimirTitulo("3. DEPARTAMENTOS EXISTENTES");
        List<String> departamentos = gestor.obtenerDepartamentos();
        for (String departamento : departamentos) {
            System.out.println(" - " + departamento);
        }

        // ---------- 4 ----------
        imprimirTitulo("4. DEPARTAMENTO Y SUMA DE SALARIOS");
        Map<String, Double> salariosPorDepto = gestor.sumarSalariosPorDepartamento();
        for (Map.Entry<String, Double> entrada : salariosPorDepto.entrySet()) {
            System.out.printf("%-20s $%10.2f%n", entrada.getKey(), entrada.getValue());
        }

        // ---------- 5 ----------
        imprimirTitulo("5. EMPLEADOS ORDENADOS POR DEPARTAMENTO");
        imprimirLista(gestor.ordenarPorDepartamento());

        // ---------- 6 ----------
        imprimirTitulo("6. REPORTE POR DEPARTAMENTO");
        Map<String, Integer> conteoPorDepto = gestor.contarEmpleadosPorDepartamento();
        System.out.printf("%-20s %-10s %-14s %s%n",
                "DEPARTAMENTO", "EMPLEADOS", "SUMA SUELDOS", "PROMEDIO");
        System.out.println("-".repeat(60));
        for (Map.Entry<String, Double> entrada : salariosPorDepto.entrySet()) {
            String departamento = entrada.getKey();
            double suma = entrada.getValue();
            int cantidad = conteoPorDepto.get(departamento);
            System.out.printf("%-20s %-10d $%-13.2f $%.2f%n",
                    departamento, cantidad, suma, suma / cantidad);
        }

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

    private static void imprimirLista(List<Empleado> lista) {
        for (Empleado empleado : lista) {
            System.out.println(empleado);
        }
    }
}
