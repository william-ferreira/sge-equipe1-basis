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

    // TODO: Testar nomes de variavel idEvento e idPergunta em EventoPerguntage
    @MapsId("eventoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Evento evento;

    @MapsId("perguntaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Pergunta pergunta;
}
