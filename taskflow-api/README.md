# `taskflow-api` — la API REST completa

El proyecto grande del curso, en su estado final (**v3.0**). A diferencia del resto del
repositorio —donde cada carpeta aísla **un** concepto— aquí conviven todos a la vez, que es
como se los va a encontrar en un trabajo: REST, DTOs, validación, JPA, seguridad con JWT,
manejo centralizado de errores, tests en tres niveles y un contenedor.

## Qué resuelve

**Nodo Digital**, una agencia de software de ~15 personas, coordinaba sus proyectos entre un
grupo de WhatsApp y un Google Sheets. Cuatro dolores concretos: nadie sabía quién tenía qué;
«ya está» no significaba nada porque nadie firmaba; el Sheets lo editaba cualquiera (un viernes
alguien borró la pestaña de otro squad); y las fechas se perdían en el chat.

TaskFlow es la API que ordena eso: proyectos con tareas, cada tarea con un responsable, un
estado y una fecha; nadie entra sin identificarse y nadie borra el proyecto de otro.

**Esto importa para leer el código:** cada regla de negocio de abajo nació de uno de esos cuatro
dolores. No son validaciones decorativas.

## Los datos con los que arranca

Con la base vacía, `DataSeeder` crea tres usuarios y tres proyectos. No son relleno: son el
reparto de la historia.

| Usuario | Password | Rol | Es dueño de | Sirve para ver |
|---|---|---|---|---|
| `ana` | `ana123` | `USER` | Plataforma TaskFlow, Migración Legacy | El camino feliz |
| `luis` | `luis123` | `USER` | App Móvil | **El 403**: tiene proyecto propio y aun así no puede borrar el de Ana |
| `admin` | `admin123` | `ADMIN` | — | La excepción: pasa por encima de la regla de dueño |

## Los endpoints

| Método | Ruta | Notas |
|---|---|---|
| `POST` | `/auth/register` · `/auth/login` | Público. El login devuelve el JWT |
| `GET` | `/auth/me` | Quién soy, según el token |
| `GET` `POST` | `/projects` | Listar y crear |
| `GET` `PUT` `DELETE` | `/projects/{id}` | El `DELETE` solo lo puede el dueño o un `ADMIN` |
| `GET` `POST` | `/projects/{id}/tasks` | Las tareas de un proyecto. Una tarea **nace** dentro de su proyecto |
| `GET` | `/tasks` · `/tasks/{id}` | `/tasks?status=DONE` filtra |
| `PUT` `DELETE` | `/tasks/{id}` | Actualizar completa / borrar |
| `PATCH` | `/tasks/{id}/status` | Cambiar solo el estado |
| `GET` | `/info` | Público: nombre y versión. Es el smoke test de un despliegue |

Documentación viva en `http://localhost:8080/swagger-ui/index.html`.
Colección de Postman lista para importar en [`postman/`](postman/).

## Las reglas, y el código HTTP que verías al romperlas

La tabla que vale la pena saberse: **cada regla vive en un lugar concreto**, y ese lugar es una
decisión de diseño, no un accidente.

| Regla | Dónde vive | Rompela y ves |
|---|---|---|
| Una tarea no existe sin proyecto | Constructor de `Task` + el `projectId` sale del path | `400` |
| `title` entre 3 y 120 caracteres | Constructor de `Task` → `TaskValidationException` | `400` |
| `dueDate` no puede ser pasada **al crear** | Factory `Task.crear` — el constructor sí rehidrata tareas vencidas, o `estaVencida()` no tendría sentido | `400` |
| No se pasa a `DONE` sin responsable | `Task.setStatus` — la regla vive en el **dominio**; `TaskService` la traduce | `422` |
| Solo el dueño o `ADMIN` borra un proyecto | `@PreAuthorize` + el bean `ProjectSecurity` | `403` |
| Nadie entra sin identificarse | Filtro JWT | `401` |
| Una tarea que no existe se dice claro | `TaskNotFoundException` → el `@RestControllerAdvice` | `404` |

Ojo a la distinción **401 vs 403**: sin token es `401` («no sé quién eres»); con token válido
pero sin permiso es `403` («sé quién eres, y no puedes»). Que salgan los dos códigos correctos
depende de que `SecurityConfig` declare **ambos**, `authenticationEntryPoint` y
`accessDeniedHandler` — con uno solo, todo cae en `401` y la diferencia se pierde.

## Cómo correrlo

### Desde Eclipse
Importar como proyecto Maven y ejecutar `TaskflowApiApplication` como Java Application. Levanta
en `http://localhost:8080` con una base H2 **en archivo** (`data/taskflow.mv.db`), así que los
datos sobreviven al reinicio. Consola SQL en `/h2-console`.

### Desde la terminal
```bash
mvn spring-boot:run
```

### Con Docker: la misma app contra Postgres
```bash
cp .env.example .env      # y pon dentro un JWT_SECRET de verdad
docker compose up --build
```
Levanta dos contenedores: `postgres:16` y la API con el perfil `docker`. El `depends_on` espera
al **healthcheck** de la base, no solo a que el contenedor arranque — la diferencia entre eso y
un `depends_on` pelado es una API que se cae al iniciar porque Postgres todavía no aceptaba
conexiones. Para bajarlo todo, incluidos los datos: `docker compose down -v`.

## Los tests

| Comando | Qué corre |
|---|---|
| `mvn test` | **67 tests**: unitarios, slices (`@WebMvcTest`, `@DataJpaTest`) e integración (`@SpringBootTest`) |
| `mvn verify` | Los 67 **+ el gate de cobertura**: falla por debajo del 70% de líneas. Hoy va en 86.7% |
| `mvn test -Ddocker.tests=true` | **70**: añade `TaskRepositoryPostgresIT`, el mismo test de repositorio contra un Postgres 16 real y efímero (Testcontainers). Requiere Docker levantado |

Informe de cobertura tras `mvn verify`: `target/site/jacoco/index.html`.

### Dos trampas que ya están resueltas aquí

**JaCoCo vive en un perfil, no en `<build>`.** Instrumenta con un `-javaagent` que inyecta en
`${argLine}`, y m2e no ejecuta `prepare-agent`: dentro de Eclipse la variable se queda sin
resolver y **`Run As > JUnit Test` revienta**. El perfil `cobertura` se activa con
`!m2e.version`, o sea en la terminal y no en Eclipse. Es el mismo patrón que usa el proyecto
[`mockito`](../mockito/) de este repositorio, por la misma razón.

**El test de Testcontainers fija `api.version=1.41`.** Sin eso, el cliente `docker-java` que
arrastra Spring Boot 3.5 negocia por debajo de la API mínima de Docker moderno (Min API 1.40) y
falla con «*Could not find a valid Docker environment*» — un mensaje que no menciona versiones
y te manda a revisar si el demonio está encendido, que no era el problema.

## Qué NO está aquí, a propósito

- **Nada de AWS**: ni despliegue en EC2/RDS, ni las evidencias, ni el plan sin cuenta de nube.
- **Nada de CI/CD**: el pipeline de GitHub Actions y la publicación de la imagen no viajaron.
- **Ninguna feature nueva**: comentarios en tareas, etiquetas y notificaciones son el backlog
  del cliente, no parte de v3.0.
- **Sin frontend**: TaskFlow es una API. Si algún día se le sirve una UI estática desde
  `src/main/resources/static/`, hay que abrirla en `SecurityConfig` — con el `anyRequest()
  .authenticated()` actual, hasta el CSS responde `401`.
