package com.forohub.forohub.domain.autores;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosValidarAutor(
        @NotBlank
        @Email
        String login,
        @NotBlank
        String clave
) {
}
