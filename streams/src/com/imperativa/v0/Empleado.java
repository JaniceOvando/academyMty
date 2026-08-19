package com.imperativa.v0;


/**
 * Entidad de dominio. Inmutable: todos los campos son final y solo hay getters.
 */
public class Empleado {

    private final int id;
    private final String nombre;
    private final int edad;
    private final double salario;
    private final String departamento;

    public Empleado(int id, String nombre, int edad, double salario, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return String.format("[%02d] %-18s edad: %2d  salario: $%7.2f  depto: %s",
                id, nombre, edad, salario, departamento);
    }
}
