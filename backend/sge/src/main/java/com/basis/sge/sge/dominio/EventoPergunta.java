package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "EventoPergunta")
@Table(name = "evento_pergunta")
@Getter
@Setter
public class EventoPergunta implements Serializable {

    @EmbeddedId
    private EventoPerguntaId id;

    @ManyToOne
    @MapsId("idEvento")
    @JoinColumn(name = "id")
    private Evento evento;

    @ManyToOne
    @MapsId("idPergunta")
    @JoinColumn(name = "id")
    private Pergunta pergunta;
}
