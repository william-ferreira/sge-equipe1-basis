package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class InscricaoRespostaId {

    private Integer idEvento;

    private Integer idPergunta;

    private Integer idInscricao;

}
