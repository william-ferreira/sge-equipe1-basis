package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
public class PreInscricaoId implements Serializable {

    private Integer idUsuario;

    private Integer idEvento;

    private Integer idTipoSituacao;
}
