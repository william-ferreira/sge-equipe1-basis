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
    private InscricaoRespostaId inscricaoRespostaId;

    @Column(name = "resposta")
    private String resposta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idEvento")
    @JoinColumn(name = "id_evento", referencedColumnName = "id")
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPergunta")
    @JoinColumn(name = "id_pergunta", referencedColumnName = "id")
    private Pergunta pergunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idInscricao")
    @JoinColumn(name = "id_inscricao", referencedColumnName = "id")
    private PreInscricao preInscricao;
}
