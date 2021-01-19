package com.basis.sge.sge.servico.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class InscricaoRespostaDTO implements Serializable {

    private String resposta;
    private Integer idInscricao;
    private Integer idEvento;
    private Integer idPergunta;

}
