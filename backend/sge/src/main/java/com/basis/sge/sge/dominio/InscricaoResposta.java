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

    @Id
    @Column(name = "id_inscricao")
    private Integer idInscricao;

    @EmbeddedId
    private EventoPerguntaId eventoPerguntaId;

    @Column(name = "resposta")
    private String resposta;
}
