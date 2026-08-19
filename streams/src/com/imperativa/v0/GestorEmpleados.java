package com.imperativa.v0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Encapsula la lista de empleados y resuelve los requerimientos
 * usando solo ciclos, condicionales y colecciones (POO imperativa).
 */
public class GestorEmpleados {

    private final List<Empleado> empleados;

    public GestorEmpleados(List<Empleado> empleados) {
        // Copia defensiva: el gestor es dueno de su propia lista.
        this.empleados = new ArrayList<>(empleados);
    }

    public List<Empleado> getEmpleados() {
        return Collections.unmodifiableList(empleados);
    }

    // 1. Filtra los que tengan mas de 30 anos de edad
    public List<Empleado> filtrarPorEdadMayorA(int edadMinima) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getEdad() > edadMinima) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    // 2. Filtra los que ganen mas de 100 dlls
    public List<Empleado> filtrarPorSalarioMayorA(double salarioMinimo) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getSalario() > salarioMinimo) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    // 3. Lista de departamentos en los que se encuentran (sin repetir)
    public List<String> obtenerDepartamentos() {
        List<String> departamentos = new ArrayList<>();
        for (Empleado empleado : empleados) {
            String departamento = empleado.getDepartamento();
            if (!departamentos.contains(departamento)) {
                departamentos.add(departamento);
            }
        }
        Collections.sort(departamentos);
        return departamentos;
    }

    // 4 y 6. Departamento -> suma de salarios de ese departamento
    //        TreeMap mantiene las llaves ordenadas alfabeticamente.
    public Map<String, Double> sumarSalariosPorDepartamento() {
        Map<String, Double> acumulado = new TreeMap<>();
        for (Empleado empleado : empleados) {
            String departamento = empleado.getDepartamento();
            if (acumulado.containsKey(departamento)) {
                double sumaPrevia = acumulado.get(departamento);
                acumulado.put(departamento, sumaPrevia + empleado.getSalario());
            } else {
                acumulado.put(departamento, empleado.getSalario());
            }
        }
        return acumulado;
    }

    // Extra util para el reporte: cuantos empleados hay por departamento
    public Map<String, Integer> contarEmpleadosPorDepartamento() {
        Map<String, Integer> conteo = new TreeMap<>();
        for (Empleado empleado : empleados) {
            String departamento = empleado.getDepartamento();
            if (conteo.containsKey(departamento)) {
                conteo.put(departamento, conteo.get(departamento) + 1);
            } else {
                conteo.put(departamento, 1);
            }
        }
        return conteo;
    }

    // 5. Ordena por departamento (no muta la lista original)
    public List<Empleado> ordenarPorDepartamento() {
        List<Empleado> copia = new ArrayList<>(empleados);
        Collections.sort(copia, new ComparadorPorDepartamento());
        return copia;
    }

    // 7. Suma total de sueldos
    public double sumarTotalSalarios() {
        double total = 0.0;
        for (Empleado empleado : empleados) {
            total += empleado.getSalario();
        }
        return total;
    }
}
