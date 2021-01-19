package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@EntityScan(basePackages = {"com.mypackage.entity"})
@Table(name = "inscricao_resposta")
@Getter
@Setter
public class InscricaoResposta implements Serializable {

    @EmbeddedId
    private InscricaoRespostaId id;

    @Column(name = "resposta")
    private String resposta;

    @ManyToOne
    @MapsId("idEvento")
    @JoinColumn(name = "id")
    private Evento evento;

    @ManyToOne
    @MapsId("idPergunta")
    @JoinColumn(name = "id")
    private Pergunta pergunta;

    @ManyToOne
    @MapsId("idInscricao")
    @JoinColumn(name = "id")
    private PreInscricao idInscricao;

}
