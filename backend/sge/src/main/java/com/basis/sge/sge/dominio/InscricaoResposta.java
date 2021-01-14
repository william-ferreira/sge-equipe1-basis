package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "inscricao_resposta")
public class InscricaoResposta {

    @Id
    @Column(name = "id_inscricao")
    private int idInscricao;

    @Id
    @Column(name = "id_evento")
    private int idEvento;

    @Id
    @Column(name = "id_pergunta")
    private int idPergunta;

    @Column(name = "resposta")
    private String resposta;
}
