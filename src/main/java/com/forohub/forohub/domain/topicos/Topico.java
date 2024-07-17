package com.forohub.forohub.domain.topicos;

import com.forohub.forohub.domain.autores.Autor;
import com.forohub.forohub.domain.topicos.dto.DatosActualizarTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private EstadoTopico status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    @Column(name = "nombre_curso")
    private String curso;

    public Topico(String titulo, String mensaje, LocalDateTime fecha, EstadoTopico status, Autor autor, String nombreCurso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.status = status;
        this.autor = autor;
        this.curso = nombreCurso;
    }

    public void actualizar(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.nombreCurso() != null) {
            this.curso = datosActualizarTopico.nombreCurso();
        }
    }
}
