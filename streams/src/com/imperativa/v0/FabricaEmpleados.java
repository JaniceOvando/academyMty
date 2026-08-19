package com.imperativa.v0;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Genera el conjunto de datos de prueba: 50 empleados.
 * Se usa una semilla fija en Random para que la salida sea reproducible.
 */
public class FabricaEmpleados {

    private static final String[] NOMBRES = {
            "Miguel Rugerio", "Ana Torres", "Luis Mendoza", "Carla Ibarra", "Pedro Salas",
            "Sofia Nunez", "Jorge Rivas", "Elena Castro", "Raul Ochoa", "Diana Vega",
            "Hugo Ramos", "Paula Cano", "Ivan Duarte", "Mara Solis", "Oscar Pineda",
            "Lucia Fuentes", "Cesar Mora", "Nadia Reyes", "Tomas Aguilar", "Rocio Lara",
            "Bruno Palma", "Ines Quiroz", "Felipe Bravo", "Sara Montiel", "Andres Gil"
    };

    private static final String[] DEPARTAMENTOS = {
            "Desarrollo", "Finanzas", "Recursos Humanos", "Ventas", "Soporte"
    };

    private FabricaEmpleados() {
        // Clase de utilidad: no se instancia.
    }

    public static List<Empleado> crearEmpleados(int cantidad) {
        List<Empleado> empleados = new ArrayList<>();
        Random aleatorio = new Random(2026); // semilla fija = resultados repetibles

        for (int i = 0; i < cantidad; i++) {
            String nombreBase = NOMBRES[i % NOMBRES.length];
            String nombre = (i < NOMBRES.length) ? nombreBase : nombreBase + " II";

            int edad = 22 + aleatorio.nextInt(24);          // 22 .. 45
            double salario = 80 + (aleatorio.nextInt(1701) / 10.0); // 80.0 .. 250.0
            String departamento = DEPARTAMENTOS[aleatorio.nextInt(DEPARTAMENTOS.length)];

            empleados.add(new Empleado(i + 1, nombre, edad, salario, departamento));
        }
        return empleados;
    }
}
