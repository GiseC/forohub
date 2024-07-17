package com.forohub.forohub.domain.topicos.dto;

import com.forohub.forohub.domain.topicos.EstadoTopico;
import com.forohub.forohub.domain.topicos.Topico;

import java.time.LocalDateTime;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        EstadoTopico status,
        Long autorId,
        String curso
) {
    public DatosDetallesTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso()
        );
    }
}
