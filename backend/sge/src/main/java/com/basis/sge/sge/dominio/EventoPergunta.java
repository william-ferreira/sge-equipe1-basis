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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEvento")
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPergunta")
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id")
    private Pergunta pergunta;
}
