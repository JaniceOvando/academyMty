# `testing` — JUnit paso a paso

Material de la Academia Monterrey para el tema de pruebas unitarias. Sigue el temario de
[la guía de JUnit 5 de Baeldung](https://www.baeldung.com/junit-5), con el código actualizado
a **JUnit 6.1.3** y verificado ejecutándolo.

Cinco guías y cuatro proyectos Maven independientes. Cada proyecto tiene al menos un script
que demuestra, corriéndolo, la idea central de su guía.

---

## Las guías

| | Guía | De qué va |
|---|---|---|
| `00` | [Por qué se prueba](https://claude.ai/code/artifact/dc6ceb37-bac9-4a8c-bbd0-89f91dbc7def) | Conceptos, **sin código**. Qué es un test, qué no es, y por qué verde no significa probado. Requisito de la 01. |
| `01` | [Anatomía de un test](https://claude.ai/code/artifact/6755acb6-a6c0-42ac-95dd-e2ffb84a3a71) | `@Test`, ciclo de vida, aserciones, la trampa del `double` — y el test que atrapa un bug de un carácter. |
| `02` | [El catálogo](https://claude.ai/code/artifact/b02ccd10-cb0b-4545-a130-a0dc29e6a26c) | `assertThrows`, timeouts, *assumptions*, `@Nested`, `@Tag`, inyección de parámetros, `@Suite`. |
| `03` | [Un test, muchos datos](https://claude.ai/code/artifact/dec3fbf5-39f0-411c-8daa-02bb3dec3eb0) | `@ParameterizedTest` con todas sus fuentes, `@RepeatedTest`, `@TestFactory`. |
| `04` | [Dobles de prueba](https://claude.ai/code/artifact/33074df8-6377-44cd-a3c6-68f766ff4b78) | **Mockito**: `@Mock`, `when`/`verify`, `@InjectMocks`, `ArgumentCaptor`, espías, estrictez — y cuándo NO mockear. |
| `··` | [JUnit 5 contra JUnit 6](https://claude.ai/code/artifact/53f58e3c-f8ea-4c4c-a6a9-ae93e2b9ca9a) | Fe de erratas: qué versión usas de verdad, y la tabla de migración desde JUnit 4. |

Los enlaces de arriba son las guías publicadas. Los archivos fuente están en `guias/`: son
HTML autocontenidos y también se abren con doble clic, sin servidor.

## Los proyectos

| Proyecto | Tests | Código bajo prueba | Script |
|---|---|---|---|
| [`01-junit-fundamentos`](proyectos/01-junit-fundamentos) | 22 | `Boleta` — promedio y regla de aprobación | `ver-fallar.sh` |
| [`02-junit-catalogo`](proyectos/02-junit-catalogo) | 37 (4 abortados a propósito) | `Curso` — cupo, cierre, acta lenta | `filtrar.sh` |
| [`03-junit-datos`](proyectos/03-junit-datos) | 211 (desde 32 métodos) | `ValidadorCurp`, `Calificador` | `contar.sh` |
| [`04-mockito-dobles`](proyectos/04-mockito-dobles) | 45 | `ServicioInscripcion` y sus 3 colaboradores | `por-que-mockear.sh`, `la-mentira.sh` |

```bash
cd proyectos/01-junit-fundamentos
./mvnw test
./scripts/ver-fallar.sh
```

En Windows: `mvnw.cmd test`. Los `.sh` necesitan **Git Bash** o **WSL**.

### Los tres scripts

Cada uno demuestra algo que no se puede enseñar solo con texto:

- **`ver-fallar.sh`** — cambia un carácter en `Boleta.aprobado()` (`>=` pasa a `>`), corre la
  suite y restaura el código. **20 de los 22 tests siguen en verde con el bug dentro.** Solo
  caen los dos que se pararon justo encima del límite. Es la lección de la guía 01 en un número.
- **`filtrar.sh`** — corre la misma suite con tres filtros de `@Tag` y mide el tiempo real de
  ejecución (no el reloj de pared, que en un proyecto de este tamaño lo domina el arranque de
  Maven). Los 3 tests lentos de 37 se llevan más de la mitad del tiempo.
- **`contar.sh`** — cuenta los métodos escritos a mano contra los tests ejecutados: 32 → 211.
- **`por-que-mockear.sh`** — la misma prueba contra el repositorio real (300 ms por consulta) y
  con dobles. **5 tests reales tardan más que los 40 con mocks.** Justifica Mockito midiéndolo.
- **`la-mentira.sh`** — el más importante de los cuatro. Rompe la regla del cupo dentro de `Curso`
  y corre dos clases que prueban lo mismo: la que usa un `Curso` real **cae**, la que lo mockea
  **sigue en verde**. Las dos «cubren» el mismo código; solo una lo protege.

---

## Cómo abrirlo en Eclipse

**File → Import… → Maven → Existing Maven Projects**, y selecciona la carpeta `testing`.
Los tres proyectos aparecen a la vez. No uses *Existing Projects into Workspace*: no llevan
`.project` — los genera m2e al importar.

Para correr un test suelto: clic derecho sobre la clase → **Run As → JUnit Test**.

## Versiones

| | |
|---|---|
| JUnit | 6.1.3 (vía `junit-bom`) |
| Mockito | 5.23.0 (vía `mockito-bom`) — solo en el proyecto 04 |
| Java | 21 (JUnit 6 exige 17 como mínimo) |
| Maven Surefire | 3.5.6 — **con 2.x no se ejecuta ningún test, y no falla** |

Los proyectos **no** usan Spring Boot: son `pom.xml` mínimos, a propósito, para que se vea qué
pide JUnit por sí solo. En un proyecto de Spring Boot no hace falta nada de esto —
`spring-boot-starter-test` ya trae JUnit, Mockito y AssertJ con las versiones coordinadas.

### Dos cosas del proyecto 04 que conviene saber

**Mockito dice depender de JUnit 5, y no pasa nada.** `mockito-junit-jupiter:5.23.0` declara
`junit-jupiter-api:5.13.4`, pero el `junit-bom` va antes en el `dependencyManagement` y fija
6.1.3 para todo el árbol. Verificado: `./mvnw dependency:tree "-Dincludes=org.junit*:*"`.

**El `pom` carga Mockito como `-javaagent`, y no es opcional.** Sin esa línea, cada corrida en
Java 21 avisa de que Mockito se auto-engancha y que *«dynamic loading of agents will be
disallowed by default in a future release»*. Con ella, el aviso desaparece y además los tests
van más rápido (medido: 0.427 s → 0.169 s).
