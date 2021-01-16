package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class EventoPerguntaId implements Serializable {

    @Column(name = "id_evento")
    private int idEvento;

    @Column(name = "id_pergunta")
    private int idPergunta;
}
