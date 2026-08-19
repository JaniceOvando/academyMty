package com.curso.v0;


import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Genera los 50 empleados de forma declarativa con IntStream.
 * Misma semilla que la version imperativa: los datos son identicos.
 */
public final class FabricaEmpleados {

    private static final List<String> NOMBRES = List.of(
            "Miguel Rugerio", "Ana Torres", "Luis Mendoza", "Carla Ibarra", "Pedro Salas",
            "Sofia Nunez", "Jorge Rivas", "Elena Castro", "Raul Ochoa", "Diana Vega",
            "Hugo Ramos", "Paula Cano", "Ivan Duarte", "Mara Solis", "Oscar Pineda",
            "Lucia Fuentes", "Cesar Mora", "Nadia Reyes", "Tomas Aguilar", "Rocio Lara",
            "Bruno Palma", "Ines Quiroz", "Felipe Bravo", "Sara Montiel", "Andres Gil");

    private static final List<String> DEPARTAMENTOS = List.of(
            "Desarrollo", "Finanzas", "Recursos Humanos", "Ventas", "Soporte");

    public static List<Empleado> crearEmpleados(int cantidad) {
    	
        Random aleatorio = new Random(2026);

        return IntStream.range(0, cantidad)
                .mapToObj(i -> new Empleado(
                        i + 1,
                        NOMBRES.get(i % NOMBRES.size()) + (i < NOMBRES.size() ? "" : " II"),
                        22 + aleatorio.nextInt(24),
                        80 + (aleatorio.nextInt(1701) / 10.0),
                        DEPARTAMENTOS.get(aleatorio.nextInt(DEPARTAMENTOS.size()))))
                .toList();
    }
}
