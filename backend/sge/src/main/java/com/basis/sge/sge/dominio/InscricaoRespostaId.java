package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class InscricaoRespostaId implements Serializable {

    private Integer eventoId;
    private Integer perguntaId;
    private Integer preInscricaoId;

}
