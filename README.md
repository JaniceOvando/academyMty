# academyMty — Ejercicios de clase

Código que trabajamos en vivo durante las sesiones de Java de la **Academia Monterrey**.

Cada proyecto es un proyecto de Eclipse independiente. Dentro de cada uno, los paquetes
`com.curso.v0`, `v1`, `v2`, `v3` son **versiones sucesivas del mismo ejemplo**: v0 es el punto
de partida y cada versión siguiente cambia una sola cosa para que se vea el efecto. Conviene
leerlos en ese orden.

Varias líneas están **comentadas a propósito**: son los casos que no compilan o que truenan en
ejecución. Descoméntalas y observa el error — ese es el ejercicio.

---

## `Inicio` — Objetos, polimorfismo y casting

| Paquete | Archivo | Tema |
|---|---|---|
| `v0` | `Principal` | Qué imprime realmente `System.out.println(objeto)`. **No es la dirección de memoria.** |
| `v1` | `Principal` | Sobrescribir `hashCode()` y `equals()` y ver cómo cambia lo anterior. |
| `v1` | `Principal2` | Polimorfismo: una referencia `Ave` apuntando a `Pinguino`, `Aguila`, `Perico`. |
| `v2` | `Principal` | El padre aporta `volarAve()`; para llegar a `volarPerico()` hace falta un cast. |
| `v2` | `Principal2` | `String` es inmutable: `concat()` no modifica, devuelve otro objeto. |
| `v3` | `Principal` | Jerarquía de 3 niveles: **upcast**, **downcast**, `instanceof` y `ClassCastException`. |

## `static_java` — Instancia vs. clase

| Paquete | Tema |
|---|---|
| `v0` | Método de instancia (`new Principal().transforma(...)`) contra método de clase (`static`). |
| `v1` | `contador` como atributo de instancia: cada `Pato` lleva el suyo, los tres imprimen `1`. |
| `v2` | `contador` como `static`: se comparte entre todos, los tres imprimen `3`. |
| `v3` | Encapsulamiento: `private static` + `getContador()` estático. |

## `final_java` — La palabra `final`

| Paquete | Tema |
|---|---|
| `v0` | `final` sobre un primitivo, sobre un mutable (`StringBuilder`) y sobre un inmutable (`String`). La clave: **`final` congela la referencia, no el contenido.** |
| `v1`, `v2` | `final class Ave` — una clase final no se puede heredar (descomenta `Pato extends Ave`). |

## `stringStringBuilder` — String vs. StringBuilder

| Paquete | Archivo | Tema |
|---|---|---|
| `v0` | `Principal` | Concatenar `String` dentro de un ciclo de 1,000,000 de iteraciones. Ojo al tiempo. |
| `v0` | `Principal1` | El mismo ciclo con `StringBuilder.append()`. Compara. |
| `v0` | `Principal2` | `String` sobrescribe `equals()` → `true`. `StringBuilder` **no** → `false`. |
| `v1` | `Principal` | `equals()` propio en `Pato`, comparando con `==`. ¿Por qué funciona aquí y cuándo dejaría de hacerlo? |

---

## Cómo abrirlo en Eclipse

1. Clona el repositorio:
   ```bash
   git clone https://github.com/cursosmrugerio/academyMty.git
   ```
2. En Eclipse: **File → Import… → General → Existing Projects into Workspace**.
3. Selecciona la carpeta `academyMty` y marca **Search for nested projects**.
4. Importa los cuatro proyectos.

Solo se versiona el código fuente (`src/`). Las clases compiladas (`bin/`) las genera Eclipse
al importar, por eso no están en el repositorio.
