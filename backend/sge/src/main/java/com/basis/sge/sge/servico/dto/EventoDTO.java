package com.basis.sge.sge.servico.dto;

import com.basis.sge.sge.dominio.TipoEvento;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class EventoDTO implements Serializable {
    private Integer id;
    @NotNull(message = "o título deve ser informado")
    private String titulo;
    @NotNull(message = "a data e hora do inicio do evento deve ser informado")
    private LocalDateTime dataInicio;
    @NotNull(message = "a data e hora do termino do evento deve ser informado")
    private LocalDateTime dataTermino;
    private String descricao;
    private Integer quantVagas;
    private Double valor;
    private String localEvento;
    // TODO: Encontrar melhor nome para variavel e tabela de tipo inscricao.
    @NotNull(message = "o tipo da inscricao deve ser informado")
    private Boolean tipoInscricao;
    @NotNull(message = "o id do tipo do evento deve ser informado")
    private Integer idTipoEvento;
    private List<EventoPerguntaDTO> perguntas;
}
