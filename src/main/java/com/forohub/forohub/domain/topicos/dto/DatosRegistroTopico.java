package com.forohub.forohub.domain.topicos.dto;

import com.forohub.forohub.domain.topicos.EstadoTopico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        EstadoTopico status,
        @NotNull
        Long autorId,
        @NotBlank
        String nombreCurso
) {
}
