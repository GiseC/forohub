package com.forohub.forohub.domain.topicos.dto;

import com.forohub.forohub.domain.topicos.EstadoTopico;
import com.forohub.forohub.domain.topicos.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        EstadoTopico status,
        String autor,
        String curso,
        LocalDateTime fecha
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getStatus(),
                topico.getAutor().getLogin(),
                topico.getCurso(),
                topico.getFecha()
        );
    }
}
