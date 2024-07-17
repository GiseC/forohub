package com.forohub.forohub.domain.topicos.dto;

import com.forohub.forohub.domain.topicos.EstadoTopico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        EstadoTopico status,
        String autor,
        String nombreCurso,
        LocalDateTime fecha
) {
}
