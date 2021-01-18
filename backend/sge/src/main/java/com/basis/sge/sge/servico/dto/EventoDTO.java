package com.basis.sge.sge.servico.dto;

import com.basis.sge.sge.dominio.EventoPergunta;
import com.basis.sge.sge.dominio.TipoEvento;
import lombok.Getter;
import lombok.Setter;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventoDTO implements Serializable {
    private Integer id;
    private String titulo;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String descricao;
    private Integer quantVagas;
    private Double valor;
    private String localEvento;
    private Boolean tipoInscricao;
    private Integer idTipoEvento;
    private List<EventoPerguntaDTO> perguntas;
}
