package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="evento")
@Getter
@Setter
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_evento")
    @SequenceGenerator(name = "sq_evento", allocationSize = 1, sequenceName = "sq_evento")
    private Integer id;

    @Column(name= "titulo")
    private String titulo;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataTermino;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidade_vagas")
    private Integer quantVagas;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "local_evento")
    private String localEvento;

    @Column(name = "tipo_inscricao")
    private Boolean tipoInscricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_evento")
    private TipoEvento tipoEvento;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "evento")
    private List<EventoPergunta> perguntas;
}
