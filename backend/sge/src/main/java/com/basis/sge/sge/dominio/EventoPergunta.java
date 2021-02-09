package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "evento_pergunta")
@Getter
@Setter
public class EventoPergunta implements Serializable {

    @EmbeddedId
    private EventoPerguntaId id;

    @MapsId("eventoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @MapsId("perguntaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inscricao_pergunta")
    private Pergunta pergunta;
}
