package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "inscricao_resposta")
public class InscricaoResposta implements Serializable {

    @Id
    @Column(name = "id_inscricao")
    private Integer idInscricao;

    @Column(name = "resposta")
    private String resposta;
}
