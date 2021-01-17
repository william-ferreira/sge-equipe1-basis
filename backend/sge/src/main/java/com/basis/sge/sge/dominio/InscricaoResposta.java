package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "inscricao_resposta")
@Getter
@Setter
public class InscricaoResposta implements Serializable {

    @Id
    @Column(name = "id_inscricao")
    private Integer idInscricao;

    @EmbeddedId
    private EventoPerguntaId eventoPerguntaId;

    @Column(name = "resposta")
    private String resposta;
}
