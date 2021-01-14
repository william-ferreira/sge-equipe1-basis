package com.basis.sge.sge.servico.dto;

import com.basis.sge.sge.dominio.TipoEvento;


import java.time.LocalDateTime;

public class EventoDTO {
    private Integer id;
    private String titulo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String descricao;
    private int quantVagas;
    private double valor;
    private String localEvento;
    private boolean tipoInscricao;
    private TipoEvento idTipoEvento;
}
