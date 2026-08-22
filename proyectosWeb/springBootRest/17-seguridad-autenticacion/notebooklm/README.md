# Fuentes para Gemini Notebook (NotebookLM)

Los cuatro `.md` de esta carpeta son el material del tema empaquetado para subirlo
como fuentes a Gemini Notebook (`notebook.google.com`).

## Por qué existen

Gemini Notebook **no acepta** `.java`, `.xml`, `.sh`, `.sql` ni `.properties`: solo
PDF, texto plano, Markdown, Google Docs, URLs y audio. Y aunque los aceptara, subir
45 archivos sueltos fragmenta el tema y empeora las respuestas.

Así que cada documento reúne una unidad con sentido propio — la guía y el código que
la implementa, juntos:

| Documento | Contenido |
|---|---|
| `00-setup-y-referencia.md` | instalación, SQL, mapa de puertos, el CRUD base, los 3 scripts de prueba, tabla comparativa de las tres etapas |
| `01-basic.md` | guía 01 + SecurityConfig + pom + properties |
| `02-jwt.md` | guía 02 + SecurityConfig + AuthController + pom + properties |
| `03-oauth2.md` | guía 03 + SecurityConfig + keycloak-setup.sh |

Dos decisiones de empaquetado, ambas medidas:

- Las guías HTML son **63% CSS y SVG**. Gemini Notebook solo indexa texto, así que se
  convierten a Markdown y se descarta el resto.
- **6 de las 7 clases Java son byte por byte idénticas** en los tres proyectos (vienen
  del proyecto 16 y no se tocaron). Van una sola vez, en el documento de referencia.
- Las llaves `.pem` **no se incluyen**: no aportan nada al índice y una llave privada
  no debe circular.

## SON ARCHIVOS DERIVADOS

No los edites a mano. Si cambias una guía, un `SecurityConfig` o el `instalacion.txt`,
regenéralos:

    ./generar.sh

Y vuelve a subirlos al notebook.

## Cómo subirlos

Gemini Notebook usa el selector de archivos nativo del sistema, así que la subida no se
puede automatizar desde el navegador. La vía que funciona es pegar el contenido:

1. `pbcopy < 01-basic.md`   (macOS; en Linux: `xclip -sel clip < 01-basic.md`)
2. En el notebook: **Add sources → Copied text**
3. Cmd+V (o Ctrl+V) en el cuadro de texto → **Insert**
4. Repetir con cada documento

El notebook se pone el título solo a partir del primer documento.
