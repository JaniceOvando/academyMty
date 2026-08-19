package com.imperativa.v0;

import java.util.Comparator;

/**
 * Comparator implementado como clase concreta, no como lambda.
 * Criterio primario: departamento (alfabetico).
 * Criterio de desempate: nombre del empleado.
 */
public class ComparadorPorDepartamento implements Comparator<Empleado> {

    @Override
    public int compare(Empleado a, Empleado b) {
        int resultado = a.getDepartamento().compareTo(b.getDepartamento());
        if (resultado == 0) {
            resultado = a.getNombre().compareTo(b.getNombre());
        }
        return resultado;
    }
}
