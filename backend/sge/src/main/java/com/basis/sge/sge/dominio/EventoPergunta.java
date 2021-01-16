package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "EventoPergunta")
@Table(name = "evento_pergunta")
@Getter
@Setter
public class EventoPergunta {

    @EmbeddedId
    private EventoPerguntaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id")
    private Pergunta pergunta;
}
