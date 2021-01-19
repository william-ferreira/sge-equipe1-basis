package com.basis.sge.sge.dominio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inscricao_resposta")
@Getter
@Setter
public class InscricaoResposta implements Serializable {

    @EmbeddedId
    private InscricaoRespostaId id;

    @Column(name = "resposta")
    private String resposta;

    @MapsId("eventoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Evento evento;

    @MapsId("perguntaId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Pergunta pergunta;

    @MapsId("preInscricaoId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private PreInscricao preInscricaoId;

}
