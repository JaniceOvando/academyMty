package com.taskflow.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * InfoController — el endpoint más pequeño de la API, y el más útil al desplegar.
 *
 * Expone GET /info con {"app":"taskflow-api","version":"3.0.0"}: PÚBLICO (sin token) para que un
 * simple `curl http://<host>:8080/info` confirme QUÉ versión está viva ahí. Un healthcheck dice
 * "responde"; esto dice "responde Y es la versión que acabo de publicar", que es la pregunta real.
 *
 * FREEZE S3D5 (integrador, fase 1): nació en D4 como "3.0.0-rc1" (release candidate); hoy, en el code
 * freeze, se sube a "3.0.0" al taggear v3.0 — el bump PROMETIDO por D4, y la ÚNICA línea de Java que
 * cambia el día de la demo (excepción explícita a la regla de oro: es metadato de versión, no una
 * feature). Se deja como constante para que el test sea determinista, sin depender de config externa.
 *
 * OJO seguridad: sin la línea permitAll("/info") en SecurityConfig, este endpoint hereda
 * anyRequest().authenticated() y responde 401 sin token — el curl del deploy fallaría. El test de
 * integración (200 SIN token) atrapa justo ese olvido.
 */
@RestController
@Tag(name = "Info", description = "Metadatos públicos del servicio (nombre y versión). Sin token.")
public class InfoController {

    private static final String APP = "taskflow-api";
    private static final String VERSION = "3.0.0";   // FREEZE S3D5: subido de "3.0.0-rc1" al taggear v3.0

    @Operation(summary = "Nombre y versión del servicio",
            description = "Público (sin token): lo consume el smoke test del deploy tras cada release.")
    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of("app", APP, "version", VERSION);
    }
}
