package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="evento")
@Getter
@Setter
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_sequence")
    @SequenceGenerator(name="evento_sequence", sequenceName = "sq_evento")
    private Integer id;

    @Column(name="titulo")
    private String titulo;

    //LocalDate se apenas existir o Date no liquibase
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "quantidade-vagas")
    private int quantVagas;

    @Column(name = "valor")
    private double valor;

    @Column(name = "local_evento")
    private String localEvento;

    @Column(name = "tipo_inscricao")
    private boolean tipoInscricao;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private TipoEvento idTipoEvento;
}
