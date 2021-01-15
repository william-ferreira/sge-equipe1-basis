package com.basis.sge.sge.servico.dto;

import com.basis.sge.sge.dominio.TipoEvento;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
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
