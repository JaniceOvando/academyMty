package com.functional.v0;

/**
 * Record: portador de datos inmutable por definicion.
 * El compilador genera constructor canonico, accesores, equals, hashCode.
 */
public record Empleado(int id, String nombre, int edad, double salario, String departamento) {

    @Override
    public String toString() {
        return String.format("[%02d] %-18s edad: %2d  salario: $%7.2f  depto: %s",
                id, nombre, edad, salario, departamento);
    }
}
